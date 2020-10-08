---
layout: post
title: Optimalizácia UNION dotazov
date: 2014-09-21
categories: programming sql
tags: programming sql
page.image.thumbnail: TODO
---

Dotaz UNION slúži v sql na spájanie dvoch a viacerých tabuliek. 
Článok bude pojednávať o vlastnostiach a optimalizácii UNION dotazov voči databázam.

V prvom rade existujú dva rôzne dotazy a to UNION a UNION ALL. 
Na otázku, ktorý z týchto dvoch je rýchlejší, aké sú ich vlastnosti odpoviem na nasledujúcich riadkoch.

### UNION

UNION spája dve tabuľky bez duplicít.

```mysql-sql
select a,b from tableA UNION select a,b from tableB
```

To znamená, že v pozadí tohto dotazu sa najprv spoja dve tabuľky potom sa zoradia
 a nakoniec sa odstránia duplicity. Výsledkom v tomto bode je to, čo dostáva používateľ.
  UNION je pomalší ako UNION ALL vzhľadom na tieto pridané operácie, ktoré vykonáva na pozadí.  

### UNION ALL

UNION spája dve tabuľky s duplicitami.
 
```mysql-sql
select a,b from tableA UNION ALL select a,b from tableB
```


Prvou úrovňou optimalizácie je uvedomenie si, či je nutné použiť UNION alebo, či stačí rýchlejší UNION ALL.

V druhej úrovni je odmezenie velkosti množín, ktoré sa spoja predtým než sa spoja.

### Optimálny dotaz

```mysql-sql
select a,b from tableA where a = 'TODAY' UNION select a,b from tableB where a = 'TODAY'
```


AKokoľvek je možné množiny pred spojením zmenšiť vo where klauzule urobte to.


Pár UNION základov:

- počet stĺpcov tabuliek, ktoré spájame musí byť totožný.
- typy stĺpcov tabuliek, ktoré spájame musia byť totožné v poradí.
