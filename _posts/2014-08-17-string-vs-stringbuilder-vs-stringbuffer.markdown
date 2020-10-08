---
layout: post
title: Java - String vs. StringBuilder vs. StringBuffer
date: 2014-08-17
categories: programming java
tags: programming java
page.image.thumbnail: TODO
---

Často kladená otázka napríklad aj na pohovoroch ohľadom jazyka Java môže byť práve rozdiel medzi triedami 
String, StringBuilder a StringBuffer.

*String* je finálna trieda, znamená to, že s každou úpravou jednej inštancie String-u vzniká
 ako výsledok nová inštancia Stringu. Konkrétne sa tak deje v takzvanom String poole.
Pri triedach StringBuilder a StringBuffer tomu tak nieje.

Inými slovami trieda *String* je *immutable* a triedy *StringBuilder* a *StringBuffer* sú *mutable*.

Z tejto informácie vyplýva, že ak v aplikácii potrebujeme často editovať, meniť, mazať pridávať 
časti k jednému reťazcu atď ideálne bude použitie tried *StringBuilder, StringBuffer*. 
V opačnom prípade zaťažíme JVM pamäť. (neoptimálne využitie Heap pamäte).

Neoptimálne je preto napríklad časté použitie operátora plus pri spájaní String-ov.

```
String b = "Ahoj"
String a = b + " svet";
```

V tomto prípade by bolo ideálnejšie použitie

```
String b = " svet";
StringBuilder str = new StringBuilder();
str.append("Ahoj");
str.append(b);
```

*Rozdiel medzi StringBuilder a StringBuffer*
Triedy slúžia na vykonávanie tých istých operácií avšak sú medzi nimi rozdiely.
*Trieda StringBuilder* nie je Thread safe a je tým pádom rýchlejšia no nevhodná pre 
použitie v multivláknových aplikáciách. Jej operácie nie sú synchronized.  
*Trieda StringBuffer* je Thread safe a je tým pádom pomalšia avšak vhodná pre použitie v
 multivláknových aplikáciách. Jej operácie sú synchronized.

