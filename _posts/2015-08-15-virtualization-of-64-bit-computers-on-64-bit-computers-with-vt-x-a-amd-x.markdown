---
layout: post
title: Virtualization of 64-bit computers on 64-bit computers with VT-x and AMD-v
date: 2015-08-15
categories: linux
tags: linux virtualization
page.image.thumbnail: TODO
---

[Virtualization](https://en.wikipedia.org/wiki/Virtualization) has a number of benefits, for example: saving money,
 since there is no need to buy new hardware ...

In order to run a 64-bit virtual machine on your 64-bit machine, you need
 that the CPU supports one of the technologies.


For **AMD** processors, the CPU must support
** [AMD-v](https://en.wikipedia.org/wiki/X86_virtualization#AMD_virtualization_.28AMD-V.29)**,
 in the case of **Intel** processors
 ** [VT-x](https://en.wikipedia.org/wiki/X86_virtualization#Intel_virtualization_.28VT-x.29)**.

### How to do it

- **Find out the CPU version**: the command **[lshw](/2014-06-21-linux-information-about-your-hardware-from-linux.html)** is enough on my linux
- **Find support info**: example of my CPU [Intel Pentium P6200](http://ark.intel.com/products/50176/Intel-Pentium-Processor-P6200-3M-Cache-2_13-GHz),
which, by the way, does not support VT-x, so only 32-bit versions of virtual machines will run on my machine.


In case you have found that your CPU supports these virtualization technologies it is necessary
 turn them on in the BIOS (since there are different BIOS versions, I do not provide specific info),
 then directly in the virtualization software such as Virtualbox (see image below).
 
 ![virtualbox](/assets/icode/virtualbox.gif)
