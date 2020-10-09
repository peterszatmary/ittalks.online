---
layout: post
title: Java - JVM virtual machine type recognition
date: 2014-08-17
categories: programming java
tags: programming java
page.image.thumbnail: TODO
---

There are several types of JVMs that your application can run on.
The following code can be identified by the JVM implementation.

```java
public class JvmTypeChecker() {
    public static String check() {
        String jvmType = Toolkit.getDefaultToolkit().toString();
        System.out.println(jvmType);
        return jvmType;
    }
}
```