---
layout: post
title: (Linux) Work with PDF files
date: 2014-08-21
categories: linux
tags: linux
---

Rozdelenie jedného veľkého PDF súboru na viac malých:

`pdftk largepdfile.pdf burst`

Výsledkom bude viac malých pdf súborov v tvare: pg_XXXX.pdf, kde XXXX je poradové číslo.

Spojenie viacerých malých PDF súborov do jedného:

`pdftk *.pdf cat output jediny.pdf`

Výsledkom bude PDF súbor s názvom jediny.pdf.



