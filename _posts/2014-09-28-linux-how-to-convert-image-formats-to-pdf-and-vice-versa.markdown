---
layout: post
title: How to convert image formats to pdf and vice versa
date: 2014-09-28
categories: linux
tags: linux
---

**convert** is able to convert images from formats like JPG, PNG ... to PDF and vice versa.

### Image to PDF
 
`convert obr.png obr.pdf`

### PDF to image

`convert obr.pdf obr.jpg`

If you need control quality of the result  use **-quality** like following

`convert -density 300 -quality 100 in.pdf out.png`

