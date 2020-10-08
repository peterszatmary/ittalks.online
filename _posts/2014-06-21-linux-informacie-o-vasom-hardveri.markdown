---
layout: post
title: Informácie o Vašom hardvéri z Linuxu
date: 2014-06-21
categories: linux
tags: linux
page.image.thumbnail: TODO
---


Informácie o Vašom hardvéri možno získať pohodlne aj z terminálu v Linuxe. Slúži na to príkaz.

**lshw** čo je skratkou od anglického **list hardware**, teda zoznam hardvéru.

Príkaz vypisuje najrôznejšie informácie o Vašom hardvéri. 
Pre viac informácií nasledujte manuálove stránky man `lshw` alebo [odkaz](http://linux.die.net/man/1/lshw).

Pre kompletný výpis je lepšie spustiť príkaz s právamu superpoužívateľa:

```
sudo lshw
```

Program zvláda výstupné formáty html, xml, json.

Pre pohodlnejší výstup preto odporúčam html alebo xml výstup: (každopádne html výstup je podľa mňa najpohodlnejší)

### HTML výstup
```
sudo lshw -html > hw.html
```

### XML výstup

```
sudo lshw -xml > hw.xml
```

Posledné dva príkazy vytvoria html alebo xml súbor vo Vašom aktuálnom adresári,
 ktorý následne otvorte. Aktuálny adresár pre úplnosť zistíte príkazom:

```
pwd
```

![Hw](/assets/icode/hw.png)