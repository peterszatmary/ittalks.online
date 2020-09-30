---
layout: post
title: (Linux) How to captured screen to video
date: 2015-08-24
categories: linux
tags: linux
---

**XVidCap**  s video kodekom MPEG4. Nástroj je jednoduchý a používa sa veľmi ľahko.

**Inštalácia**

Je nutné pridať repozitár do **/etc/apt/sources.list** pridaním riadku **deb http://www.deb-multimedia.org squeeze main**.

```
# update repozitárov
sudo apt-get update
# inštalácia GPG kľúča repozitára
sudo apt-get install deb-multimedia-keyring
# inštalácia xvidcap
sudo apt-get install xvidcap
```

![xvidcap](/assets/icode/xvidcap.png)



 
