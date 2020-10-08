---
layout: post
title: Python - Analýza csv súborov
date: 2014-09-14
categories: programming python
tags: programming python
page.image.thumbnail: TODO
---

Môj obľúbený python využívam napríklad v prípadoch, keď je potrebné pracovať s textom a textovými súbormi. Keď je potrebné
vytvoriť utilitky pre konkrétnu jednu alebo pár menších činností s textom. Nasledujúci skript
 kontroluje csv súbory (comma-separated values) v zadanom adresári spôsobom, že vypíše každý riadok,
ktorému nesedí počet oddeľovačov na riadku. Takýmto vypíše cestu k súboru, číslo riadku, očakávaný
počet a skutočný počet separátorov.

```python
__author__ = 'nue'
#!/usr/bin/env python

# Ing. Peter Szatmary
# 18.6.2014
# da sa vylepsit print , pomocou premennych, nie sekvencnym vypisovanim

# prejde dir adresar najde v nom vsetky csv subory ktore prejde, a zkontroluje ci sedi pocet delimiterov na kazdom riadku
# ak nesedi tak vypise ocakavany pocet , skutocny pocet a cislo riadku

import os
import csv

print 'start'

# params
dirVar = '/home/nue/PycharmProjects/fileUtilities/forCsvControl'
pathDelim = '/'
csvDelim = ';'

results = {}
fileCount = 0
for file in os.listdir(dirVar):
	if file.endswith('.csv'):
		fileCount = fileCount + 1
		print dirVar + pathDelim + file
		f = open(dirVar + pathDelim + file)
		reader = csv.reader(f, delimiter=csvDelim)
		i = 0
		count = 0
		for row in reader:
			i = i + 1
			if i == 1:
				count = len(row)
			if count != len(row):
				print '\t\triadok ' + str(i) + '. (' + str(count) + '|' + str(len(row)) + ')'
print 'pocet skumanych suborov: ' + str(fileCount)
print 'end'
``` 

Utilitku som využíval, keď bolo potrebné kontrolovať rýchlo chyby v csv súboroch,
 kde mohli vznikať chybné riadky s väčším množstvom separátorov zadaním hodnoty,
 ktorá sa rovnala separátoru.

Príklad výstupu:

![control csv](/assets/icode/controlcsv.png)

Vo výstupe vidieť, že boli kontrolované dokopy 3 súbory. Z toho iba dva obsahujú chybné
 riadky a to d2.csv a d3.csv. Pričom podľa programu súbor d2.csv musí obsahovať 4 stĺpce
  a súbor d3.csv musí obsahovať práve 3 stĺpce.