---
layout: post
title: Python - Generátor sql dotazov
date: 2015-08-16
categories: programming python
tags: programming python
page.image.thumbnail: TODO
---

Python je veľmi vhodý pre prácu s textom a súbormi. Veľmi rýchlo si človek dokáže
 napísať šikovné skripty.

Nedávno som potreboval nejaké dummy inserty do SQL databázy. Napísal som teda 
skript **generateSQL.py**, 
ktorý vygeneruje tieto dummy inserty a uloží ich do súboru **sqlQueries.sql**.

 
### Skript generateSQL.py


Skript obsahuje premenné, ktoré možno vhodne meniť podľa záujmu:

**dirVar** : cesta, kde sa má vygenerovaný súbor uložiť
**tableVar** : názov tabuľky
**loops** : počet vygenerovaných sql dotazov
**sqlQuery** : nemeniaca sa časť sql dotazu

```python
#!/usr/bin/env python

#!/usr/bin/env python
 
# generate file with inserts.
 
import string
import random
 
def generatorStr(size):
	return ''.join(random.choice(string.ascii_uppercase + string.digits) for x in range(size))
 
print 'Generate sql queries starts'
 
# configurable ------
# path to file that will be created
dirVar = '/home/nue' 
# table name
tableVar = 'user' 
# count of generate random queries
loops = 1000 
# part of one query
sqlQuery = "INSERT INTO " + tableVar + " (mail,info,name) VALUES " # change it for another sql query
# -------------------
 
f = open(dirVar + '/' + 'sqlQueries.sql','wb')
print "File " + f.name + " was created" 
for x in range(0, loops):
	wholeSql = sqlQuery + "('" + generatorStr(60) + "','" + generatorStr(10) + "','" + generatorStr(30) + "');\n" # change it for another sql query
	f.write(wholeSql)
f.close()
 
print str(loops) + ' sql queries was generated.'
print 'Generate sql queries ends'
```


### Spustenie skriptu generateSQL.py

![script run](/assets/icode/run.png)
 

### Ukážka výstupu skriptu generateSQL.py

Výstupom je súbor **sqlQueries.sql**. V tomto prípade sa vygenerovali dummy INSERT  sql dotazy 
pre tabuľku **user**, ktorá má stĺpce **mail**, **info** a **name**.

```mysql-sql
INSERT INTO user (mail,info,name) VALUES ('FSWPGEYQRP2EORIOJPAC62GT5KY2YA508EDGWYUJC629Q82XKRE038P59GW2','W1BVI8V0Y2','JBK7KKNUR7W1SYMKTOCQ3EJUK3IQUJ');
INSERT INTO user (mail,info,name) VALUES ('945HO95EF5XZPP15CE044KM62YPMJUQO8Y8FZE9NN876X1U1XMPVKVV89W0F','RP00RD5RNQ','CD0D3X02BLYTMGGXBG9CU8A0HZ065S');
INSERT INTO user (mail,info,name) VALUES ('WY5ASV4G6428QD12Y0P7YZO9WIKEO1Y9TEEW71PA9O4G6E3PSCYAB6V79SUZ','I51JTMCMJW','7PI83CHUC139SCF16TKLVWPAAMZOZ0');
INSERT INTO user (mail,info,name) VALUES ('FUIVYQOSR9Z1JRPOSQ25BNX1DDWMB5GTN6G0QWTSTL983CO0Q2049WRQ4AQ2','102D1H9QN0','F5I637C5YJOK2H6KDIXBR1DIRLB78Z');
INSERT INTO user (mail,info,name) VALUES ('DUZ6HAWPMNUG9A4DWM472JTWX2LZYQP966ZLC59P0G0YSAWXT3JFI40R20KW','RL1W5ENF8L','X7HPG4QDYOE9PFBNQJ649UDIGZBOG1');
INSERT INTO user (mail,info,name) VALUES ('F20RABGVZHV0MVDGQPYKWS44BCU689KVINH7OWZIATGX1ABW4CMSJCGUPB5Q','YCL0L46PXQ','RX17X1XDC7HGGT69ISYALKDGSIBKBS');
INSERT INTO user (mail,info,name) VALUES ('WYV1AQ856BEIK10Z1PFUZEHC5PWRB1964XBZF53PQ0K1NC653MBLHE7392PW','RE3JKK0KC3','E9BISJV0OQAPWLL57UE06F06EJRB6Z');
INSERT INTO user (mail,info,name) VALUES ('0E5NEOBSMIJ6QYHI2ROJW00WN3ILV3105NP8BQIE48JFOZXF1X5NR0VUDJ5G','IIZZR4EZ3P','NLZSGGC2OACPM0VO07KI28H9EKOTY1');
INSERT INTO user (mail,info,name) VALUES ('WMCZ3P7IG6O4IB50UKIYM54H3JK0VVRPIQRUP94GSQN4SQTPBIS2ULZDK43N','P1WU7BXLGM','TQVX73K9AXH5IDEYXVK6AKPA0YFGX0');
INSERT INTO user (mail,info,name) VALUES ('KNZ15QAQQSVS45CYV4ZGM342I8Q30Y91QXJOXYOTK7N9OTEMESXLC7HTTCNK','B9I9WDTDLN','N9FHWUXMWL9HKSSHIMFRGCH3UUWRNN');
INSERT INTO user (mail,info,name) VALUES ('UZ41HP2XVH7LGSWAA5ZY70ALESFGOSEIJ0LHM9Z4TYTR9M6UZNO8T77ZE36W','EBZQ11UHDN','AK4G2UJFQCQRVAJ20GF25DMMCNKBUE');
INSERT INTO user (mail,info,name) VALUES ('BBLKPBCX50IUAPJ75ZKYSM7RY5E0OK90QQERZR4WNIHP8FLF9GOJAZYBQ42Z','EQE6XSKW2B','X33F3B5WX535UNZH1DTXT0CVUOQIT0');
INSERT INTO user (mail,info,name) VALUES ('GE24Q1STAJP7G2G9BXIAD99DA5ZGJ4B6MXHMILOM8H4UAFJAVD8JHJ1O5D2K','VI91E9K0KW','PK9BK68NMT0OHOZ3DOLXU9WKTQO32A');
INSERT INTO user (mail,info,name) VALUES ('1OBA6W7FKPEOUJE4WC9BPLSBUB2P0DUH25J447TNFIAQ3TXU27AM6SE9T7B1','A2SYMA5MUE','9EDASP0U6ADJJYFEXXANZZ0PERDP1T');
INSERT INTO user (mail,info,name) VALUES ('H6UO0WYGDLDIPB7HD0U636J32C65BYZMUFPKYNLPMMYOQ80CX2RNZKIIPW9V','UPDGKERL2W','FWH4R771TJQER7YKQGKM6EFMK6HBO5');
INSERT INTO user (mail,info,name) VALUES ('R17SFYL0SU87F8NFCMNR5499W5YQYZ64RY5TG9186S8JIY7ITK2LQEKS2YLA','65KLAU2KID','TAYRU29W4MSB04Y7SJ3SUX5V2OLKB0');</pre> 
```