---
layout: post
title: Java - JAXB Tutorial - Marshalling and Unmarshalling
date: 2014-10-12
categories: programming java
tags: programming java jaxb xsd
page.image.thumbnail: TODO
---

JAXB from the English Java Architecture for XML Binding is a major technology that
allows you to easily map XML files to java objects and vice versa.

In addition, it can work with schemes. For this article, just mention [XSD](http://www.w3schools.com/schema/).

JAXB has been a part of the standard JDK since version 6. Currently, the current version is 2.2.12 (11.10.2014).

The basic capabilities of this technology are:

- **Marshalling:** save XML file from java objects
- **Unmarshalling:** Load XML file as java objects
- **Generating XSD file from java objects**
- **Generating java objects from XSD file**

Marshalling and unmarshalling will be described. Generating XSD file and java files is described
in the article [JAXB tutorial - Generating XSD schema from java files and vice versa](/2014-10-12-java-jaxb-tutorial-generating-xsd-schemas-from-java-files-and-vice versa/).

The codes that are in the download article I wrote in [Intelijj Idea](http://www.jetbrains.com/idea/) and used Java SE 7.


### Marshalling

Save XML file from java objects.

Let's have a composition of objects where the Person class contains attributes (id, age, name, surname)
and the address attribute is a reference to an object of type Address. The Address class contains the addressStr and postcode attributes.

### Person.java
 
```java
package java2xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {

    private int id;
    private int age;
    private String name;
    private String surname;
    private Address address;

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    @XmlElement
    public void setAddress(Address address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    @XmlElement
    public void setAge(int age) {
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    @XmlElement
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }
}
```

### Address.java
 
```java
package java2xml;

import javax.xml.bind.annotation.XmlElement;

public class Address {

    private String addressStr;
    private String postcode;

    public String getAddressStr() {
        return addressStr;
    }

    @XmlElement(name="address")
    public void setAddressStr(String addressStr) {
        this.addressStr = addressStr;
    }

    public String getPostcode() {
        return postcode;
    }

    @XmlElement
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
```

### Explanation of JAXB annotations in code

**@XmlRootElement:** specifies the root element in the xml file. It is set for the appropriate class.
**@XmlElement:** indicates that it is an xml element. It is set for the respective setter.
**@XmlAttribute:** indicates that it is an xml attribute. It is set for the respective setter.

One more little thing. Enrollment:


`` `java
@XmlElement (name = "address")
`` `

Forces JAXB to disregard the default xml element name from the setter, but the address we defined.

Of course, the annotations and options how to customize the Java code for subsequent mapping with xml are much more see
[project JAXB](https://jaxb.java.net/tutorial/).

The code that maps these objects and saves them to xml is as follows.

 
```java
package java2xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Main {
    public static void main(String[] args) {

        // creation and filling of a Person object
        Person person = new Person();
        person.setAge(24);
        person.setId(1);
        person.setName("Jan");
        person.setSurname("Atos");

        Address address = new Address();
        address.setAddressStr("Alejova 5");
        address.setPostcode("04056");

        person.setAddress(address);

        try {

            final String PATH = System.getProperty("user.home") + System.getProperty("file.separator") + "java2xml.xml";
            File file = new File(PATH);
            // list of classes from which to generate
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // format the output
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(person, file);
            jaxbMarshaller.marshal(person, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
```

The result is the jml2xml.xml xml file, which was saved in the home directory.

### java2xml.xml

 
```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<person id="1">
    <address>
        <address>Alejova 5</address>
        <postcode>04056</postcode>
    </address>
    <age>24</age>
    <name>Jan</name>
    <surname>Atos</surname>
</person>
``` 


### Unmarshalling

loading XML file as Java objects

Let us use the Person.java and Address.java classes from the marshalling section. 
Let us add the toString () method for them
later simpler listing and checking of java objects for standard output.

### toString() for Person.java

```java
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address=" + address +
                '}';
    }
```

### toString() pre Address.java
 
```java
    @Override
    public String toString() {
        return "Address{" +
                "addressStr='" + addressStr + '\'' +
                ", postcode='" + postcode + '\'' +
                '}';
    }
```


The code responsible for unmarshalling loads the xml file xml2java.xml
(which we obtained as an output from the marshallig section), which is located
in the home directory and prints the loaded objects to standard output:

```java
package xml2java;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        try {

            final String PATH = System.getProperty("user.home") + System.getProperty("file.separator") + "java2xml.xml";
            File file = new File(PATH);
            // zoznam tried, z ktorých sa má generovať
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Person person = (Person) jaxbUnmarshaller.unmarshal(file);
            System.out.println(person);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
```

Output:

![jaxb2](/assets/icode/jaxb2.png)