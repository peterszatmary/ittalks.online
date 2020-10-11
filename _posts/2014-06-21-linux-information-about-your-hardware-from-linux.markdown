---
layout: post
title: Linux - Information about your hardware from Linux
date: 2014-06-21
categories: linux
tags: linux
page.image.thumbnail: TODO
---


Information about your hardware can also be conveniently obtained from a terminal in Linux. Use the command to do this.

**lshw** which is an abbreviation from the English **hardware list**, ie a list of hardware.

The command lists various information about your hardware.
For more information, follow the man `lshw` or [link](http://linux.die.net/man/1/lshw) man pages.

For a complete listing, it is better to run the command with superuser rights:

`` `
sudo lshw
`` `

The program handles output formats html, xml, json.

For more convenient output, I therefore recommend html or xml output: (anyway, html output is the most convenient in my opinion)

### HTML output
`` `
sudo lshw -html > hw.html
`` `

### XML output

`` `
sudo lshw -xml > hw.xml
`` `

The last two commands will create an html or xml file in your current directory,
  which then open. To find out the current directory for completeness, use the command:
```
pwd
```

![Hw](/assets/icode/hw.png)