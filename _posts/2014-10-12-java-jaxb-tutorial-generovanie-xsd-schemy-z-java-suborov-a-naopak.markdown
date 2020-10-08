---
layout: post
title: Java - JAXB tutoriál - Generovanie XSD schémy z java súborov a naopak
date: 2014-10-12
categories: programming java
tags: programming java jaxb xsd
page.image.thumbnail: TODO
---

JAXB z anglického Java Architecture for XML Binding je významnou technológiou, ktorá umožňuje jednoducho mapovať XML 
súbory na java objekty a naopak. Navyše dokáže pracovať aj so schémami. 
Pre tento článok stačí, keď spomeniem [XSD](http://www.w3schools.com/schema/).

JAXB je súčasťou štadarného JDK od verzie 6. Momentálne je aktuálna verzia 2.2.12 (11.10.2014). 

Základné schopnosti tejto technológie, sú:

- **Marshalling:** uloženie XML súboru z java objektov
- **Unmarshalling:** načítanie XML súboru ako java objekty
- **Generovanie XSD súboru z java objektov**
- **Generovanie java objektov z XSD súboru**


Opísané budú posledné dve a to generovanie XSD schémy z java súborov a generovanie java súborov z XSD schémy. Marshalling a 
Unmarshalling boli opísané v článku
[JAXB tutoriál - Marshalling a Unmarshalling](/2014-10-12-java-jaxb-tutorial-marshalling-a-unmarshalling.html).

Kódy, ktoré sú v článku na stiahnutie som písal v [Intelijj Idea](http://www.jetbrains.com/idea/) a použil Java SE 7.



### Generovanie XSD súboru z Java objektov

Generovať XSD súbor z java objektov možno implementáciou vlastného **SchemaOutputResolver**-a. 
Opäť použijeme kódy tried Person.java a Address.java z predošlého článku 
[JAXB tutoriál - Marshalling a Unmarshalling](/2014-10-12-java-jaxb-tutorial-marshalling-a-unmarshalling.html).

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

A spustíme generovanie XSD súboru.


```java
package java2xsd;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.SchemaOutputResolver;
import java.io.IOException;

public class Main {

    // generovanie schemy kodom java
    public static void main(String[] args) {
        try {
            // zoznam tried, z ktorých sa má generovať
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

Vygenerovaný súbor schema1.xsd bude mať nasledovný kód.


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



### Generovanie java objektov z XSD súboru

Poslúži na to nástroj **[XJC](http://docs.oracle.com/javase/6/docs/technotes/tools/share/xjc.html)**, 
ktorý sa nachádza na mieste inštalácie JDK v adresári bin. Ide o JAXB Binding Compiler. 
Nástroj nemá grafickú nadstavbu.

### Použitie XJC

```
xjc -d <cesta_k_adresaru_kde_sa_ma_generovat> <adresa_k_suboru_xsd>
```

Najprv sa nastavím do adresára ktorý obsahuje xjc. Na mojom Linuxe je to nasledovne:

```
cd /usr/lib/jvm/jdk1.7.0_67/bin
``` 

### Spustenie generovania: 

```
xjc -d /home/nue/gen/ /home/nue/schema1.xsd
``` 

Prepínač **-d** určí kde sa majú generovať java súbory. Nasleduje potom cesta k xsd schéme.

XJC vygenevalo súbory: ObjectFactory.java, Address.java, Person.java.

![xjc](/assets/icode/xjc.png)


Tí z vás, ktorí skušali 
[marshalling](/2014-10-12-java-jaxb-tutorial-marshalling-a-unmarshalling.html)
s týmito vygenerovanými triedami podľa [minuleho clanku](/2014-10-12-java-jaxb-tutorial-marshalling-a-unmarshalling.html)
 narazili na problém. Nefunguje !  

Pre takto vygenerované triedy už je potrebné kód mashallingu trošku upraviť. Kód zfunkčnia nasledovné riadky:

```java
ObjectFactory of = new ObjectFactory();
JAXBElement<Person> jaxbPerson =  of.createPerson(person);
```


Uvádzam celé znenie  Main.java:

 
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

        // pridane
        ObjectFactory of = new ObjectFactory();
        JAXBElement<Person> jaxbPerson =  of.createPerson(person);

        try {

            final String PATH = System.getProperty("user.home") + System.getProperty("file.separator") + "java2xml.xml";
            File file = new File(PATH);
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // zformatuje vystup
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(jaxbPerson, file);
            jaxbMarshaller.marshal(jaxbPerson, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
```


Pre úplnosť uvádzam vygenerované kódy nástrojom XJC. Aby neboli kódy príliš dlhé, odstránil som komentáre.

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