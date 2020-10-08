---
layout: post
title: Java - Použitie triedy bez toho, aby bola definovaná v CLASSPATH
date: 2014-08-17
categories: programming java
tags: programming java
page.image.thumbnail: TODO
---

S externými knižnicami v jazyku Java možno pracovať aj bez toho, aby boli pridané do tzv. CLASSPATH.

Pre testovanie som stiahol knižnicu [cofoja](http://code.google.com/p/cofoja/). 
Názov stiahnutého súboru je **cofoja-1.1-r150.jar**. 

Uložil som ju do počitača do adresára */home/nue/nue/libs/* čiže presné URI ku knižnici vyzerá 
nasledovne */home/nue/nue/libs/cofoja-1.1-r150.jar/*.

V kóde nahrávam triedu **com.google.java.contract.Ensures**, 
kde vypisujem len jej názov avšak je možné s ňou ľubovoľne pracovať.

```java
public class Main {

    /**
     * dostal som sa k triede ktora nieje v classpath
     * @throws MalformedURLException
     * @throws ClassNotFoundException
     */
    public static void run() throws MalformedURLException, ClassNotFoundException {
        File f = new File("/home/nue/nue/libs/cofoja-1.1-r150.jar/");
        URL url = f.toURI().toURL();
        URL[] urls = new URL[]{url};
        ClassLoader cl = new URLClassLoader(urls);
        Class c = cl.loadClass("com.google.java.contract.Ensures");
        System.out.println("Name of class = " + c.getCanonicalName());
        //nad objektom c možno ďalej pracovať
    }


    public static void main(String[] args) 
        throws MalformedURLException, ClassNotFoundException {
        run();
    }
}
```


### Výstup

![vystup](/assets/icode/withoutclasspath.png)