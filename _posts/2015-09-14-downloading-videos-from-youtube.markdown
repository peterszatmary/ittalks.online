---
layout: post
title: (Linux) Downloading videos from youtube
date: 2015-09-14
categories: linux
tags: linux
---

Pre Linux používam command line aplikáciu napísanú v pythone s názvom **youtube-dl**
skrátene od youtube downloader.

Aplikácia sa používa veľmi jednoducho, má množstvo prepínačov ( pre záujmcov man youtube-dl ).

### Základné použitie

Základné použitie spočíva v pridaní url videa, ktoré sa ide kopírovať z youtube.com
 
`youtube-dl https://www.youtube.com/watch?v=WPvGqX-TXP0` 


### Kvalita stihanutého videa

Čo zvyknem používať je ovplyvňovanie kvality stiahnutého videa. Slúži na to prepínač -F.

Zistenie dostupných kvalít:

`youtube-dl -F https://www.youtube.com/watch?v=WPvGqX-TXP0`  

![youtube-dl](/assets/icode/ydl1.png)


Následný výber jednej z nich použitím čiselného označenia. Slúži na to prepínač -f.

`youtube-dl -f 22 https://www.youtube.com/watch?v=WPvGqX-TXP0`

![youtube-dl](/assets/icode/ydl2.png)