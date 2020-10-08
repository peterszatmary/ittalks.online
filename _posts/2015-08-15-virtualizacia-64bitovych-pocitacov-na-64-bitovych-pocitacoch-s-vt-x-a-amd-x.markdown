---
layout: post
title: Virtualizácia 64 bitových počítačov na 64 bitových počítačoch s VT-x a AMD-v
date: 2015-08-15
categories: linux
tags: linux virtualization
page.image.thumbnail: TODO
---

[Virtualizácia](https://en.wikipedia.org/wiki/Virtualization) má množstvo výhod napríklad: šetrenie peňazí,
 kedže nie je potrebné kupovať nový hardvér... TODO

Na to aby ste rozbehali 64 bitový virtuálny stroj na vašej mašine 64 bitovej mašine je potrebné,
 aby  CPU podporovalo jednu z technológií.


V prípade procesorov **AMD** musí CPU podporovať 
**[AMD-v](https://en.wikipedia.org/wiki/X86_virtualization#AMD_virtualization_.28AMD-V.29)**,
 v prípade procesorov **Intel** technológiu 
 **[VT-x](https://en.wikipedia.org/wiki/X86_virtualization#Intel_virtualization_.28VT-x.29)**.

### Ako na to

- **Zistiť verziu CPU** : na mojom linuxe stačí príkaz **[lshw](/2014-06-21-linux-informacie-o-vasom-hardveri.html)**
- **Vyhľadať info o podpore** : príklad môjho CPU [Intel Pentium P6200](http://ark.intel.com/products/50176/Intel-Pentium-Processor-P6200-3M-Cache-2_13-GHz), 
ktoré mimochodom nepodporuje VT-x, čiže na mojom stroji pobežia žial iba 32 bitové verzie virtuálnych počítačov.


V prípade, že ste zistili, že vaše CPU podporuje tieto virtualizačné technológie je potrebné
 ich zapnúť v BIOSE (keďže existujú rôzne verzie BIOSu neuvádzam konkrétne info), 
 potom priamo vo virtualizačnom softvéri napríklad Virtualbox (viď obrázok nižšie).
 
 ![virtualbox](/assets/icode/virtualbox.gif)
