---
layout: post
title: Commands for work with images
date: 2015-07-20
categories: linux
tags: linux
---

The article deals with 4 basic operations with files and 3 commands using,
which can be performed under the Linux operating system. They are file splitting,
merge files, delete text from a file, and add text to a file using commands

**split**, **cat**, **sed**.

### Spliting the file

simple file splitting can be achieved with the ** split ** command.

Let's have an input.txt file that has 2000 lines. Command

`split -l 500 input.txt prefix`

divides the file into 4 files of 500 lines, namely:

- prefix
- prefixab
- prefixac
- prefixed


### Merging Files

The well-known ** cat ** is fully sufficient for merging files.
The combination of files created in the last step, prefixaa, prefixab, prefixac,
prefixad is performed as follows:

`cat prefixaa prefixab prefixac prefixad > oneFile.txt`

The output is a oneFile.txt file, which will be identical to the input.txt file from the previous example.


For more info `man cat`

### Add text to a file

Let's say we want to add the text "added bottoms ..." to line number 20 in the input.txt file.

`sed -i" .tmp "'20ipridane dna ...' input.txt`


### Delete text from a file

Let's say we want to delete the text "added bottoms ..." from line number 20 from the input.txt file.

`sed -i" .tmp "'20, 20d 'input.txt`

This entry can delete a line interval from - to. Since the data from, to is identical, namely 20, we will delete only one line, namely the 20th.

For more info `man sed`
