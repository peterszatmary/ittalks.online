---
layout: post
title: Java - JAXB Tutorial - Generating XSD schemas from java files and vice versa
date: 2014-10-12
categories: programming java
tags: programming java jaxb xsd
page.image.thumbnail: TODO
---

JAXB from the English Java Architecture for XML Binding is a major technology that allows you to easily map XML
files to Java objects and vice versa. In addition, it can work with schemes.
For this article is sufficient to mention [XSD](http://www.w3schools.com/schema/).

JAXB has been a part of the standard JDK since version 6. Currently, the current version is 2.2.12 (11.10.2014).

The basic capabilities of this technology are:

- **Marshalling:** save XML file from Java objects
- **Unmarshalling:** Load XML file as Java objects
- **Generating XSD file from java objects**
- **Generating java objects from XSD file**


The last two will be described, namely generating an XSD schema from java files and generating java files from an XSD schema. Marshalling a
Unmarshalling were described in the article
[JAXB - Marshalling a Unmarshalling](/2014-10-12-java-jaxb-tutorial-marshalling-a-unmarshalling.html).


### Generate XSD file from Java objects

Generate an XSD file from java objects by implementing your own **SchemaOutputResolver**.
Again, we will use the Person.java and Address.java class codes from the previous article
[JAXB - Marshalling a Unmarshalling](/2014-10-12-java-jaxb-tutorial-marshalling-a-unmarshalling.html).

```java
package java2xsd;

import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class ICodeSchemaOutputResolver extends SchemaOutputResolver {

        public Result createOutput(String namespaceURI, String fileName) throws IOException {
            File file = new File(fileName);
            StreamResult result = new StreamResult(file);
            System.out.println(file.toURI().toURL().toString());
            result.setSystemId(file.toURI().toURL().toString());
            return result;
        }
}
```

We start generating the XSD file.


```java
package java2xsd;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.SchemaOutputResolver;
import java.io.IOException;

public class Main {

   // generate schema with Java code
    public static void main(String[] args) {
        try {
            // list of classes from which to generate
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
            SchemaOutputResolver sor = new ICodeSchemaOutputResolver();
            jaxbContext.generateSchema(sor);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
```

The generated schema1.xsd file contains the following code.


```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<xs:schema version="1.0" xmlns:xs="http://www.w3.org/2001/XMLSchema">

  <xs:element name="person" type="person"/>

  <xs:complexType name="person">
    <xs:sequence>
      <xs:element name="address" type="address" minOccurs="0"/>
      <xs:element name="age" type="xs:int"/>
      <xs:element name="name" type="xs:string" minOccurs="0"/>
      <xs:element name="surname" type="xs:string" minOccurs="0"/>
    </xs:sequence>
    <xs:attribute name="id" type="xs:int" use="required"/>
  </xs:complexType>

  <xs:complexType name="address">
    <xs:sequence>
      <xs:element name="address" type="xs:string" minOccurs="0"/>
      <xs:element name="postcode" type="xs:string" minOccurs="0"/>
    </xs:sequence>
  </xs:complexType>
</xs:schema>
```



### Generating java objects from an XSD file

Use the tool **[[XJC](http://docs.oracle.com/javase/6/docs/technotes/tools/share/xjc.html)**,
which is located at the JDK installation site in the bin directory. It's about the JAXB Binding Compiler.
The tool does not have a graphical extension.

### Using XJC

`` `
xjc -d <path_to_directory_here_to_generate> <address_to_xsd_file>
`` `

First, I set up a directory that contains xjc. On my Linux, it's like this:

`` `
cd /usr/lib/jvm/jdk1.7.0_67/bin
`` `

### Start generation:

`` `
xjc -d /home/nue/gen/ /home/nue/schema1.xsd
`` `

The **- d** switch specifies where to generate java files. This is followed by the path to the xsd schema.

XJC generated files: ObjectFactory.java, Address.java, Person.java.

![xjc](/assets/icode/xjc.png)


Those of you who have tried
[marshalling](/2014-10-12-java-jaxb-tutorial-marshalling-a-unmarshalling.html)
with these generated classes by [last article](/2014-10-12-java-jaxb-tutorial-marshalling-a-unmarshalling.html)
 encountered a problem. Does not work !

For the classes generated in this way, it is necessary to modify the mashalling code a bit. 
The code will work with the following lines:

```java
ObjectFactory of = new ObjectFactory();
JAXBElement<Person> jaxbPerson =  of.createPerson(person);
```

Here is the full text of Main.java

 
### Main.java

```java
package java2xmlof;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Main {

    public static void main(String[] args) {

        Person person = new Person();
        person.setAge(24);
        person.setId(1);
        person.setName("Jan");
        person.setSurname("Atos");

        Address address = new Address();
        address.setAddress("Alejova 5");
        address.setPostcode("04056");

        person.setAddress(address);

        // added
        ObjectFactory of = new ObjectFactory();
        JAXBElement<Person> jaxbPerson =  of.createPerson(person);

        try {

            final String PATH = System.getProperty("user.home") + System.getProperty("file.separator") + "java2xml.xml";
            File file = new File(PATH);
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // format the output
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(jaxbPerson, file);
            jaxbMarshaller.marshal(jaxbPerson, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
```

For completeness, I present the codes generated by the XJC tool. To keep the codes from being too long, I removed the comments.
### ObjectFactory.java

```java
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 

package java2xmlof;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName _Person_QNAME = new QName("", "person");

    public ObjectFactory() {
    }

    public Person createPerson() {
        return new Person();
    }

    public Address createAddress() {
        return new Address();
    }

    @XmlElementDecl(namespace = "", name = "person")
    public JAXBElement<Person> createPerson(Person value) {
        return new JAXBElement<Person>(_Person_QNAME, Person.class, null, value);
    }
}
```


### Person.java
 
```java

package java2xmlof;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "person", propOrder = {
    "address",
    "age",
    "name",
    "surname"
})
public class Person {

    protected Address address;
    protected int age;
    protected String name;
    protected String surname;
    @XmlAttribute(name = "id", required = true)
    protected int id;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address value) {
        this.address = value;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int value) {
        this.age = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String value) {
        this.surname = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }
}
```


### Address.java
 
```java
package java2xmlof;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "address", propOrder = {
    "address",
    "postcode"
})
public class Address {

    protected String address;
    protected String postcode;

    public String getAddress() {
        return address;
    }

    public void setAddress(String value) {
        this.address = value;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String value) {
        this.postcode = value;
    }
}
```