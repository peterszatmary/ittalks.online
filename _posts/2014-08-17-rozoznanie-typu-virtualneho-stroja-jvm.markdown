---
layout: post
title: Java - Rozoznanie typu virtuálneho stroja JVM
date: 2014-08-17
categories: programming java
tags: programming java
page.image.thumbnail: TODO
---

Existuje viacero typov virtuálneho stroja JVM, nad ktorým môže bežať vaša aplikácia. 
Rozoznať implementáciu JVM možno nasledovným kódom.

```java
public class JvmTypeChecker() {
    public static String check() {
        String jvmType = Toolkit.getDefaultToolkit().toString();
        System.out.println(jvmType);
        return jvmType;
    }
}
```