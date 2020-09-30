---
layout: post
title: (Linux) Work with PDF files
date: 2014-08-21
categories: linux
tags: linux pdf
---

### One big file to multiple smaller

Splitting one big PDF file to multiple smaller files:

`pdftk largepdfile.pdf burst`

Result are multiple smaller PDF files with names:  pg_XXXX.pdf, where XXXX is order number.

### Multiple smaller files to one big file

Merging multiple PDF files into one big file:

`pdftk *.pdf cat output one.pdf`

Result is one big PDF file named one.pdf.