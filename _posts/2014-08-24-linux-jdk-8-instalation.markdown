---
layout: post
title: JDK instalation
date: 2014-08-24
categories: linux
tags: linux
---

JDK ( Java Development Kit ) is base development package used by Java developers 
to develop Java software.

You need to download JDK files from Oracle site, extract and install it.

Installation on Windows machines is more straightforward. This is recipe for Linux.

So after downloading and extracting JDK.


```
# if /usr/lib/jvm/ does not exist
sudo mkdir -p  /usr/lib/jvm/ 
# move of files already extracted
sudo mv jdk-7-oracle/ /usr/lib/jvm/
# add repository
sudo add-apt-repository ppa:nilarimogard/webupd8
# updating repositories
sudo apt-get update
# instalation of tool update-java
sudo apt-get install update-java
# run tool update-java. with it you can set default version of JDK alebo JRE
sudo update-java
```

After you run update-java everything you need is choose a version of JDK or JRE and apply the selection.

Control if installation was successful.

```
# java version control
java -version
# javac version control
javac -version</pre> 
```