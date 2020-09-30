---
layout: post
title: (Linux) JDK instalation
date: 2014-08-24
categories: linux
tags: linux
---

Java Development Kit (JDK) je základný balík potrebný pre vývoj v jazyku java. 
Je potrebné ho stiahnuť z Oracle stránok rozbaliť a nainštalovať. Inštalácia na operačných systémoch Windows 
je priamočiarejšia a líši sa od inštalácie na operačných systémoch Linux.

Po stiahnutí JDK a rozbalení.


```
# iba ak /usr/lib/jvm/ neexistuje
sudo mkdir -p  /usr/lib/jvm/ 
# presun rozbalených súborov
sudo mv jdk-7-oracle/ /usr/lib/jvm/
# pridanie repozitára
sudo add-apt-repository ppa:nilarimogard/webupd8
# aktualizácia repozitárov
sudo apt-get update
# inštalácia nástroja update-java
sudo apt-get install update-java
# spustenie nástroja update-java, ktorým nastaví defaultná verzia JDK alebo JRE
sudo update-java
```

Po spustení nástroja update-java stačí vybrať verziu JDK alebo JRE a potvrdiť voľbu.

Pre kontrolu správnosti stačí zadať:


```
# kontrola verzie javy
java -version
# kontrola verzia prekladača javy
javac -version</pre> 
```