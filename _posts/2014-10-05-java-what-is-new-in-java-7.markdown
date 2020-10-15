---
layout: post
title: Java - What is new in Java 7
date: 2014-10-05
categories: programming java
tags: programming java
page.image.thumbnail: TODO
---

Java 7 saw the light of day 7.7.2011. Compared to the previous version 6, it brought a few innovations that will also affect the written code.

They are:

- ##### String switch
- ##### Binary number literals
- ##### Multicatch
- ##### Implicit resource management in try block (try-with-resources)
- ##### Diamond operator
- ##### Underlining in numerical literatures
- ##### java.nio (new io)
- ##### @ SafeVarargs

<br /><br />

### Switch so Stringom

Until version 6, Java managed the switch with only types: int, byte, short, long, enumeration.
Starting with version 7, the switch can also be used with the String type.

#### Java 7
```java
    String input = "1";
    switch(input) {
        case "1" : {System.out.println("1");break;}
        case "2" : {System.out.println("2");break;}
        case "3" : {System.out.println("3");break;}
        default: {System.out.println("ine cislo");break;}
    }
```

<br /><br />


### Binary number literals

The value of the primitive types byte, short, int, long can be expressed as a binary number from version 7.
You can read more at [Oracle dokumentation](http://docs.oracle.com/javase/8/docs/technotes/guides/language/binary-literals.html).
 
```java
// 8 bitovy byte
byte aByte = (byte)0b00100001; // value: 33

// 16 bitovy short
short aShort = (short)0b0010100101000101; // value: 10565

// 32 bitove  int hodnoty
int anInt1 = 0b00100001010101011010000101000101; // value: 559259973
int anInt2 = 0b101; // value: 5
int anInt3 = 0B101; // value: 5

// 64 bitovy long
long aLong = 0b0010000101010101101000010100010110100001010001011010000101000101L; // value: 2402003296702538053
```

<br /><br />


### Multicatch

It would often be useful to combine multiple reasons for an application crash into a single error message, log, and so on.
  Version 7 has this option and thus shortens the code, making it more readable.  

#### Java 7

```java
try {
    // ....
} catch (UnsupportedOperationException | NullPointerException | ArrayIndexOutOfBoundsException e) {
       e.printStackTrace();
       System.out.println("informacia na standardny vystup");
}
```

#### Java 6

```java
try {
    // ....
} catch (NullPointerException e) {
        e.printStackTrace();
        System.out.println("informacia na standardny vystup");
} catch (ArrayIndexOutOfBoundsException e) {
        e.printStackTrace();
        System.out.println("informacia na standardny vystup");
} catch (UnsupportedOperationException e) {
        e.printStackTrace();
        System.out.println("informacia na standardny vystup");
}
```


<br /><br />


### Implicit resource management in try block (try-with-resources)

In version 6, access to external resources (files, database ...) was required explicitly
  release these resources in the final block. Again, the approach was often less clear and
  added extra lines of code.

In version 7 it is not necessary to release resources explicitly, they will be released immediately after the end
try block. The try block adds parentheses () to which access code can be written
  to resources and accordingly java will know which resources to implicitly release.

#### Java 7
```java
try (FileReader reader = new FileReader("path to file")) {
    int ch;
    while ((ch = reader.read()) != -1) {
          System.out.print(ch);
          reader.read();
    }
} catch (IOException ex) {
        ex.printStackTrace();
}
```


#### Java 6
 
```java
FileReader reader = null;
try {
    try {
        reader = new FileReader("path to file");
        int ch;
        while ((ch = reader.read()) != -1) {
              System.out.print(ch);
              reader.read();
        }
   } finally {
       reader.close();
   }
} catch (IOException ex) {
     ex.printStackTrace();
}
```

<br /><br />

### Diamond operator

Abbreviation of type entries on the right side of the expression in the form of the diamond operator <>
on the one hand, it saves the programmer from unnecessary rewriting of types from left to right,
shortens the notation, reduces the possible error rate of the code.

#### Java 7

```java
List<String> list7 = new ArrayList<>();
Map<String, List<String>> l7 = new HashMap<>();
```

#### Java 6

```java
List<String> list6 = new ArrayList<String>();
Map<String, List<String>> l6 = new HashMap<String, List<String>>();</pre> 
```

<br /><br />


### Underscore in numerical literatures

I use it if the numeral literal is very long and would be difficult to read.
Thus, the underscore increases the readability of long number literals.
You can read more at
[Oracle dokumentation](http://docs.oracle.com/javase/8/docs/technotes/guides/language/underscores-literals.html). 
  
#### Java 7

```java
long creditCardNumber = 1234_5678_9012_3456L; // 1234567890123456</pre> 
```

#### Java 6

```java
long creditCardNumber = 1234567890123456L;</pre> 
```

### java.nio (new io)

It is an alternative to java.io. It brings the necessary utility methods  (for working with files, paths, 
directories),  cleaner exception handling, adds support for symbolic links and metadata, and more. 
It is buffer oriented while the old java.io is stream oriented.For those interested: 
[comparison of io and nio](http://tutorials.jenkov.com/java-nio/nio-vs-io.html).

 
```java
Path path = Paths.get("sources.txt");
Files.copy(Paths.get("sources.txt"), Paths.get("sources2.txt"));
boolean isDir = Files.isDirectory(path);
Files.delete(path);
```
 

### @SafeVarargs

[Code example below](http://www.angelikalanger.com/GenericsFAQ/FAQSections/ProgrammingIdioms.html#Why%20does%20the%20compiler%20sometimes%20issue%20an%20unchecked%20warning%20when%20I%20invoke%20a)
  throws in java version 6 suppress warning (lines 9-12), which can be suppressed by annotation ** @ SuppressWarnings ("unchecked") ** for each dangerous method call (lines 1-3).

```java
public  static <E>; void addAll(List<E> list, E... array) { 
   for (E element : array) list.add(element); 
}
```

```java
@SuppressWarnings("unchecked")
public static void main(String[] args) { 
   addAll(new ArrayList<String>(),           // fine 
          "Leonardo da Vinci", 
          "Vasco de Gama" 
   ); 
   addAll(new ArrayList<Pair<String,String>>(), // unchecked warning 
          new Pair<String,String>("Leonardo","da Vinci"), 
          new Pair<String,String>("Vasco","de Gama") 
   ); 
}
```

 
Version 7 offers the annotation **@ SafeVarargs**, which you just need to apply to a 
similarly dangerous one implementation only once and not on all callers.
You can read why this problem arises [here](http://www.angelikalanger.com/GenericsFAQ/FAQSections/ProgrammingIdioms.html#Why%20does%20the%20compiler%20sometimes%20issue%20an%20unchecked%20warning%20when%20I%20invoke%20a).
In short, fields with generic types are becoming problematic for Java. Varargs translates to a
 field in the background.

#### Java 7

```java
@SafeVarargs
public  static <E> void addAll(List<E> list, E... array) { 
   for (E element : array) list.add(element); 
}

public static void main(String[] args) { 
   addAll(new ArrayList<String>(),           // fine 
          "Leonardo da Vinci", 
          "Vasco de Gama" 
   ); 
   addAll(new ArrayList<Pair<String,String>>(), // not fine
          new Pair<String,String>("Leonardo","da Vinci"), 
          new Pair<String,String>("Vasco","de Gama") 
   ); 
}
```
