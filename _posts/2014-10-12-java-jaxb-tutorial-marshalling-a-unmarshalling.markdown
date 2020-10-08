---
layout: post
title: JAXB tutoriál - Marshalling a Unmarshalling
date: 2014-10-12
categories: programming java
tags: programming java jaxb xsd
page.image.thumbnail: TODO
---

JAXB z anglického Java Architecture for XML Binding je významnou technológiou, ktorá 
umožňuje jednoducho mapovať XML súbory na java objekty a naopak.

Navyše dokáže pracovať aj so schémami. Pre tento článok stačí, keď spomeniem [XSD](http://www.w3schools.com/schema/).

JAXB je súčasťou štadarného JDK od verzie 6. Momentálne je aktuálna verzia 2.2.12 (11.10.2014). 

Základné schopnosti tejto technológie, sú:

- **Marshalling:** uloženie XML súboru z java objektov
- **Unmarshalling:** načítanie XML súboru ako java objekty
- **Generovanie XSD súboru z java objektov**
- **Generovanie java objektov z XSD súboru**

Opísané budú marshalling a unmarshalling. Generovanie XSD súboru a java súborov je popísané 
v článku [JAXB tutoriál – Generovanie XSD schémy z java súborov a naopak](/2014-10-12-java-jaxb-tutorial-generovanie-xsd-schemy-z-java-suborov-a-naopak/).

Kódy, ktoré sú v článku na stiahnutie som písal v [Intelijj Idea](http://www.jetbrains.com/idea/) a použil Java SE 7.


### Marshalling

uloženie XML súboru z java objektov.

Majme kompozíciu objektov, kde trieda Person obsahuje atribúty (id, age, name, surname) 
a atribút address referenciu na objekt typu Address. Trieda Address obsahuje atribúty addressStr a postcode.

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

    @XmlElement(name="address")      // nastavil som nazov tagu, defaultne sa bere nazov tagu z nazvu prislusneho settera
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

### Vysvetlenie JAXB anotácií v kóde

**@XmlRootElement:** určuje koreňový element v xml súbore. Nastavuje sa pre príslušnú triedu.
**@XmlElement:** dáva na vedomie, že ide o xml element. Nastavuje sa pre príslušný setter.
**@XmlAttribute:** dáva na vedomie, že ide o xml atribút. Nastavuje sa pre príslušný setter.

Ešte jedna maličkosť. Zápis:

 
```java
@XmlElement(name="address")
```

Prinúti JAXB nebrať do úvahy defaultne názov xml elementu zo setteru, ale nami definované address.

Samozrejme, že anotácií a možností ako java kód prispôsobiť pre následné mapovanie s xml je omnoho viac viď 
[project JAXB](https://jaxb.java.net/tutorial/).

Kód, ktorý mapuje tieto objekty a uloží ich do xml je nasledovný.

 
```java
package java2xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Main {
    public static void main(String[] args) {

        // tvorba a naplnenie objektu typu Person
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
            // zoznam tried, z ktorých sa má generovať
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // zformatuje vystup
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(person, file);
            jaxbMarshaller.marshal(person, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
```

Výsledkom bude xml súbor java2xml.xml, ktorý sa uloží do domovského adresára.

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

načítanie XML súboru ako Java objekty

Použijeme triedy Person.java a Address.java zo sekcie o marshallingu. Pridáme im metódy toString() pre 
neskorší jednoduchší výpis a kontrolu java objektov na štandardný výstup.

### toString() pre Person.java

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


Kód zodpovedný za unmarshalling načíta xml súbor xml2java.xml 
(ktorý sme získali ako výstup zo sekcie o marshalligu), ktorý sa nachádza 
v domovskom adresári a vypíše na štandardný výstup načítané objekty:

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

Výstup:

![jaxb2](/assets/icode/jaxb2.png)