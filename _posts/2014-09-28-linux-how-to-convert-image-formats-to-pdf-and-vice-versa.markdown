---
layout: post
title: (Linux) How to convert image formats to pdf and vice versa
date: 2014-09-28
categories: linux
tags: linux
---


 V Linuxe to dokáže program **convert**

Občas sa hodí veľmi rýchlo konvertovať obrázky povedzme vo formátoch jpg alebo png
 a ďalších do PDF formátu alebo naopak.

O programe convert som už písal na tomto blogu, kde som opisoval [praca s obrazkami](TODO) 
najčastejšie použitie, ale pre prácu iba s obrázkovými formátmi.


### Prevod obrázka do PDF
 
`convert obr.png obr.pdf`

### Prevod PDF do obrázka

`convert obr.pdf obr.jpg`

Pre zachovanie kvality výstupu používam nasledovné.

`convert -density 300 -quality 100 in.pdf out.png`

Ako vidieť convert dokáže pracovať aj s PDF formátom. 
