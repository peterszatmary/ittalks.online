---
layout: post
title: (Linux) How to convert html file to pdf file
date: 2015-07-26
categories: linux
tags: linux
---

Príkaz (program) wkhtmltopdf dokáže konvertovať html súbor do PDF súboru.

![wkhtmltopdf](/assets/icode/wkhtmltopdf.png)

### Konvert vzdialeného html do pdf

Povezme, že sa nám zapáčila stránka [google.com](https://google.com) natoľko, že ju potrebujeme ako pdf súbor.

`wkhtmltopdf https://www.google.com google.pdf`

Výsledkom je súbor **google.pdf**.


### Konvert lokálneho html do pdf

Povedzme, že máme html stránku lokálne v našom pc uloženú na 
ceste */home/Downloads/page.html* a takisto ju chceme konvertovať do pdf formátu.

`wkhtmltopdf file:///home/Downloads/page.html pageinpdf.pdf`

Výsledkom je pdf súbor **pageinpdf.pdf**.

Toto boli 2 najzákladnejšie ukážky použitia. 

Pre viac info sa oplatí pozrieť [wkhtmltopdf docs](http://wkhtmltopdf.org/docs.html) alebo help  `wkhtmltopdf -H`.
