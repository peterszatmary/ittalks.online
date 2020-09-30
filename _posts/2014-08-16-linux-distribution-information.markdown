---
layout: post
title: (Linux) Distribution information commands
date: 2014-08-16
categories: linux
tags: linux
---

Dnešná rýchlovka bude o Linuxe a dolovaní informácií. 
Informácie o Vašej Linux distribúcii sa zisťujú aj v termináli.

Slúži na to príkaz **lsb_release**, ktorý vypisuje špecifické informácie o 
Vašej práve nainštalovanej Linux distribúcii.

Skratka lsb je z anglického Linux Standard Base. Pre viac informácii o 
tomto príkaze využite man stránky man lsb_release alebo <a href="http://refspecs.linuxbase.org/LSB_3.1.1/LSB-Core-generic/LSB-Core-generic/lsbrelease.html" title="odkaz na man lsb_release">odkaz man lsb_release</a>.

### Použitie

`lsb_release -a`

vypíše napríklad nasledujúce

![lscpu](/assets/icode/lsb.png)

Čo znamená:

- **LSB version:** názov modulu, verzia a názov architektúry
- **Distributor ID:** reťazec reprezentujúci meno distribútora distribúcie
- **Description:** opis distribúcie, v tomto prípade je to ID distribútora nasledovaná číslom distribúcie
- **Release:** číslo distribúcie
- **Codename:** kódove označenie distribúcie
