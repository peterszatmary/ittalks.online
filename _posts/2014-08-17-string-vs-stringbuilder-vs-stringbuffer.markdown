---
layout: post
title: Java - String vs. StringBuilder vs. StringBuffer
date: 2014-08-17
categories: programming java
tags: programming java
page.image.thumbnail: TODO
---

A frequently asked question, for example in Java interviews, can be the difference between classes
String, StringBuilder and StringBuffer.

### String

is the final class, meaning that it is created with each modification of one String instance
  as a result, a new instance of String. Specifically, this happens in the so-called String pool.
This is not the case with the StringBuilder and StringBuffer classes.

In other words, the *String* class is *immutable*, and the *StringBuilder* and *StringBuffer* classes are *mutable*.

This information shows that if we often need to edit, change, delete or add in the application
parts to a single string, etc. Ideally, the use of the *StringBuilder, StringBuffer* classes will be used.
Otherwise, we load the JVM memory. (suboptimal Heap memory usage).

It is therefore not optimal, for example, to use the plus operator frequently when joining strings.

```java
String b = "Hello"
String a = b + " world";
```

More optimal is

```java
String b = " world";
StringBuilder str = new StringBuilder();
str.append("Hello");
str.append(b);
```

So now without variables

```java
StringBuilder str = new StringBuilder();
str.append("Hello ");
str.append("world");
```

### Difference between StringBuilder and StringBuffer

Classes are used to perform the same operations, but there are differences between them.
**StringBuilder class** is not Thread safe and is therefore faster but not suitable for
use in multithreaded applications. Operations are not synchronized.
**The StringBuffer** class is Thread safe and is therefore slower but suitable for use in
  multithreaded applications. Operations are synchronized.

