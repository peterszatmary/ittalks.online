---
layout: post
title: How to convert html file to pdf file
date: 2015-07-26
categories: linux
tags: linux
---

Command wkhtmltopdf is able to convert HTML files to PDF.

PDF format pro is that file in this format looks in same way on any operating system.

![wkhtmltopdf](/assets/icode/wkhtmltopdf.png)

### Convert of remote HTML to PDF

Let us say we would like to convert [google.com](https://google.com) to PDF.

```
wkhtmltopdf https://www.google.com google.pdf
```

Result is **google.pdf** file.


### Convert local HTML to PDF

Converting looks same as with remote html. Difference is URL that we typed. 
File is located in */home/Downloads/page.html* Instead of URL we will use path to file.

`wkhtmltopdf file:///home/Downloads/page.html pageinpdf.pdf`

Result is file **pageinpdf.pdf**.

For more information try [wkhtmltopdf docs](http://wkhtmltopdf.org/docs.html) or help `wkhtmltopdf -H`.
