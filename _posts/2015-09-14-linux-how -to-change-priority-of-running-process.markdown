---
layout: post
title: How to change priority of running process
date: 2015-09-14
categories: linux
tags: linux
---

Priorita bežiaceho procesu hovorí systému akým spôsobom má prideľovať zdroje procesoru procesom. 
Tie s vyššou prioritou majú prideľované zdroje procesoru častejšie ako tie s menšou prioritou,
čo znamená, že sa vykonajú rýchlejšie ako keby mali nižšiu prioritu.

Takéto "kúzlo" sa sem tam hodí, ak chceme zrýchliť istý proces (alebo aj spomaliť).

Vylistujeme si všetky bežiace procesy a zároveň vyhľadáme daný proces. 
V tomto prípade hľadám proces caja, ktorý kopíruje momentálne súbory na 
mojom PC a "trvá mu to!". Caja je oficiálny file manažér pre mate desktop.

`ps -e -o pid,ni,cmd | grep caja`

![renice](/assets/icode/renice1.png) 

Zistile sme, že proces beží s prioritou 0 a má PID (process ID) rovné 1907. 
Priority sa pohybujú v rozmedzí od -20 (najvyššia priorita) po prioritu 20 (najnižšia priorita). 

Zvýšime prioritu procesu 1907 na -19.

`renice -n -19 -p 1907`

A opäť si vypíšeme process pre kontrolu.

![renice](/assets/icode/renice2.png)

Momentálne už proces beží s vyššou prioritou a to -19. Poznámka na záver. 
Príkazy v článku je potrebné vykonávať s právami superpoužívateľa alebo roota.
