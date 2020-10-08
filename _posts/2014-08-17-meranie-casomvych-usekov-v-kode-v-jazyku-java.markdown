---
layout: post
title: Java - Meranie časových úsekov v kóde
date: 2014-08-17
categories: programming java
tags: programming java
page.image.thumbnail: TODO
---

V určitých prípadoch je vhodné keď si vie programátor zmerať trvanie určitej časti kódu. V iných prípadoch si to
 vyžaduje priamo aplikácia. Pre meranie v Jave je možné použiť 2 spôsoby s rôznou presnosťou.

### System.currentTimeMillis()

Vráti čas meraný v milisekundách. Je menej presný ako varianta, ktorú predstavím neskôr.

```java
long start = System.currentTimeMillis();
// merany kod
long end = System.currentTimeMillis();
System.out.println("time: " + (end - start) + " ms");
```

### System.nanoTime()
 
Vráti čas meraný v nanosekundách. Je presnejší. Hodí sa pre veľmi presné merania.

```java
long start = System.nanoTime();
// merany kod
long end = System.nanoTime();
System.out.println("time: " + (end - start) + " ns");
```