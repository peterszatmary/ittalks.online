---
layout: post
title: Distribution information commands
date: 2014-08-16
categories: linux
tags: linux
---

Command **lsb_release** can list information about your installed Linux distribution.

Abreviation lsb stands for Linux Standard Base. For more information about command 
`man lsb_release` or [man lsb_release site](http://refspecs.linuxbase.org/LSB_3.1.1/LSB-Core-generic/LSB-Core-generic/lsbrelease.html).

### Usage

`lsb_release -a`

is resulting to

![lscpu](/assets/icode/lsb.png)


- **LSB version:** module name, version, and architecture name
- **Distributor ID:** a string representing the name of the distribution distributor
- **Description:** a description of the distribution, in this case the distributor ID followed by the distribution number
- **Release:** Distribution version number
- **Codename:** Distribution code name
