---
layout: post
title: Java - Measuring time slots in code
date: 2014-08-17
categories: programming java
tags: programming java
page.image.thumbnail: TODO
---

In some cases, it is useful if the programmer can measure the duration of a certain piece of code. In other cases it
is required directly by the application. It is possible to use 2 methods with different accuracy for measurement in Java.

### System.currentTimeMillis()

Returns the time measured in milliseconds. It is less accurate than the variant I will present in a moment.

```java
long start = System.currentTimeMillis();
// merany kod
long end = System.currentTimeMillis();
System.out.println("time: " + (end - start) + " ms");
```

### System.nanoTime()
 
Returns the time measured in nanoseconds. It's more accurate. 
Suitable for very accurate c.

```java
long start = System.nanoTime();
// merany kod
long end = System.nanoTime();
System.out.println("time: " + (end - start) + " ns");
```