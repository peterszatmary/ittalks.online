---
layout: post
title: Linux cheatsheet
date: 2015-08-24
categories: linux
tags: linux
permalink: /linux-cheatsheet
---

You can find here Linux commands that could possibly help anyone. Also some of them I described
in this blog. in [category linux](/categories/linux). If you have something usefull what is missing here
please [let me know](/about).

### for information
```
sudo lshw                       # hardware informations to standard output
sudo lshw -html > hw.html       # hardware informations to html file
sudo lshw -xml > hw.xml         # hardware informations to xml file
lsb_release -a                  # information about your linux distribution
cat /proc/cpuinfo               # informations about your CPU
lscpu                           # informations about your CPU
```

### for fun
```
apt-get moo                     # just big moooo
```

### pdf
```
pdftk largepdfile.pdf burst               # splitting large pdf file into smaller ones
pdftk *.pdf cat output big.pdf            # merging many pdf files into one
```

### converting
```
convert input.jpg output.png                      # converts image to image (jpg to png)
convert input.png -resize 85% output.png          # makes output.png smaller (85% of input.png) then input.png 
convert img.png wasimg.pdf                        # converting image to pdf file
convert wasimg.pdf img.png                        # converting pdf file to image
convert -density 300 -quality 100 in.pdf out.png  # be sure that output has good quality use atributes (density, quality)
```

### download videos from youtube
```
youtube-dl <video_url>          # download video at specific video url
youtube-dl -F <video_url>       # list all video qualities for downloading
youtube-dl -f 22 <video_url>    # donwload video at url with quality 22 what means best
```

### converting html to pdf
```
wkhtmltopdf https://www.google.com google.pdf # converting web page to pdf
wkhtmltopdf file://google.html google.pdf     #  converting local html to pdf
```

### Strings / files
```
egrep -l "search_for" *file_pattern_to_search_in # search in files in one directory that match pattern *file_pattern_to_search_in for string search_for
sed -i".bak" '$a\something' <file_name>          # add string something to file filen_name at the end
find . -name \* -print                           # print recursively all files in directory . 
cat file1 file2 > big-one                        # file1 + file2 == big-one
grep -c "<search_string>" file_pattern           # count lines that match search_string in files that match file_pattern
grep -e "<search_string>" pattern1 pattern2      # search search_string in files that match pattern1 or pattern2
grep -n "<search_string>" pattern                # search search_string in files that match pattern and results output have line numbers

du -sh -c <dir>               # count total size of directory (human readable)
find <dir> -type f | wc -l    # count all files in directory

netstat -vulntp               # list all open ports
nc -vz <host> <port>          # is host:port open ?
```