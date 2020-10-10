---
layout: post
title: Java - Usage of a class without being defined in a CLASSPATH
date: 2014-08-17
categories: programming java
tags: programming java
page.image.thumbnail: TODO
---

It is possible to work with external libraries in the Java language without adding them to the so-called CLASSPATH.

I downloaded the [cofoja library](http://code.google.com/p/cofoja/) for testing.
The name of the downloaded file is **cofoja-1.1-r150.jar**.

I saved it to the computer in the directory */home/nue/nue/libs/* so the exact URI to the library looks like
following */home/nue/nue/libs/cofoja-1.1-r150.jar/*.

I'm loading the class **com.google.java.contract.Ensures** in the code,
where I list only its name, but it is possible to work with it arbitrarily.

```java
public class Main {
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


### Output

![Output](/assets/icode/withoutclasspath.png)