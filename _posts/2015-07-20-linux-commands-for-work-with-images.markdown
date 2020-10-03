---
layout: post
title: Commands for work with images
date: 2015-07-20
categories: linux
tags: linux
---

Článok pojednáva o 4 základných operáciách so súbormi a 3 príkazoch pomocou, 
ktorých ich možno vykonať pod operačným systémom Linux. Sú to delenie súboru, 
spájanie súborov, mazanie textu so súboru a pridávanie textu do súboru pomocou príkazov

**split**, **cat**, **sed**.

### Rozdelenie súboru

jednoduché delenie súboru možno docieliť príkazom **split**.

Majme súbor input.txt, ktorý má 2000 riadkov. Príkaz

`split -l 500 input.txt prefix` 

rozdelí súbor na 4 súbory po 500 riadkov a to :

- prefixaa
- prefixab
- prefixac
- prefixad


### Spájanie súborov

Pre spájanie súborov plne postačí dobre známy **cat**.
Spojenie súborov, ktoré nám vznikli v minulom kroku a to prefixaa, prefixab, prefixac, 
prefixad vykonáme nasledovne :

`cat prefixaa prefixab prefixac prefixad > oneFile.txt`

Výstupom je súbor oneFile.txt, ktorý bude totožný so súborom input.txt s predošlého príkladu.


Pre viac info `man cat`

### Pridávanie textu do súboru

Povedzme, že chceme pridať text "pridane dna ..." na riadok číslo 20 do súboru input.txt.

`sed -i".tmp" '20ipridane dna ...' input.txt`


### Mazanie textu zo súboru

Povedzme, že chceme vymazať text "pridane dna ..." z riadku číslo 20 zo súboru input.txt.

`sed -i".tmp" '20,20d' input.txt`

Tento zápis vie mazať interval riadkov od - do. Keďže údaj od, do je totožný a to 20 , vymažeme iba jeden riadok a to 20-ty.

Pre viac info `man sed`
