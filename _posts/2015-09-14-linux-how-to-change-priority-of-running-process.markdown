---
layout: post
title: How to change priority of running process
date: 2015-09-14
categories: linux
tags: linux
---

Priority of running process tells you how often operating system should allocate
CPU resources.

Bigger priority means that CPU is allocating to processes more often which means
that processes have more CPU process time for usage. This means that the process with bigger priority
can be faster than same process with lower piority.

Priority can be changed by **renice** command.

If you need speed up or slow down the application renice and
 priority change is the way how to achieve it.
 
 First list running processes and find your process.
 
 Let su find Caja. Caja copies files in this example, and it is slow. Caja
 is oficial file manager for Mate desktop.  

`ps -e -o pid,ni,cmd | grep caja`

![renice](/assets/icode/renice1.png) 

Priority of process with PID (process ID) 1907 is 0. Priority range is moving from -20 (lowest) to 20 (highest).

Let us try to change priority to -19.  

`renice -n -19 -p 1907`

Now check the process.

![renice](/assets/icode/renice2.png)

As you can see now it is running with changed priority -19. Command renice run as root or with sudo.
