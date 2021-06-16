---
layout: post
title: Python - Analysis of csv files
date: 2014-09-14
categories: programming python
tags: programming python
page.image.thumbnail: TODO
---

I use my favorite python, for example, when I need to work with text and text files. When is necessary to
create utilities for a specific one or more smaller text activities. The following script
  checks csv files (comma-separated values) in the specified directory in such a way that it prints each line,
which does not fit the number of delimiters per line. This will list the path to the file, the line number, as expected
number and actual number of separators.

```python
__author__ = 'nue'
#!/usr/bin/env python

# Ing. Peter Szatmary
# 18.6.2014
# can be improved by printing, using variables, not sequential printing
# will go through dir directory and find all csv files in it that and check if the number of delimiters on each line is same
# if not, it will display the expected number, the actual number and line number

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
				print '\t\trow ' + str(i) + '. (' + str(count) + '|' + str(len(row)) + ')'
print 'number of analysed files: ' + str(fileCount)
print 'end'
``` 
 
I used the utility when it was necessary to quickly check for errors in csv files,
  where erroneous lines with a large number of separators could be created by entering a value,
  which equaled the separator.

### Output example:

![control csv](/assets/icode/controlcsv.png)

In the output you can see that a total of 3 files were scanned. 
Only two of them contain erroneous ones namely  lines d2.csv and d3.csv. According to the program,
 the d2.csv file must contain 4 columns  and the d3.csv file must contain exactly 3 columns.