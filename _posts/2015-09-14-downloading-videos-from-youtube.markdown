---
layout: post
title: Downloading videos from youtube
date: 2015-09-14
categories: linux
tags: linux
---

**youtube-dl** can donwload files from youtube to your local computer.

youtube-dl is short for youtube downloader and is written in python.

### Basic usage

donwload video by passing video url.
 
`youtube-dl https://www.youtube.com/watch?v=WPvGqX-TXP0` 


### Video quality

First check what video qualities you can download

`youtube-dl -F https://www.youtube.com/watch?v=WPvGqX-TXP0`  

![youtube-dl](/assets/icode/ydl1.png)


Then choose quality number from previous list. 

`youtube-dl -f 22 https://www.youtube.com/watch?v=WPvGqX-TXP0`

![youtube-dl](/assets/icode/ydl2.png)