---
layout: post
title: Java - Hanojské veže
date: 2014-08-20
categories: programming java
tags: programming java
page.image.thumbnail: TODO
---

Hanojské veže je známa matematická hra. Pozostáva z troch stĺpov a istého počtu diskov rôznej veľkosti. 
Hra sa začína s počtom diskov na ľavej strane, ktoré sú poukladané od najväčšieho disku po najmenší. 
Hra sa končí, keď sa podarí hráčovi premiestniť v rovnakom poradí všetky disky na posledný stĺp. 
Je však nutné dodržať dve pravidlá:

- v jednom ťahu je možné hýbať iba jedným diskom
- disk možno položiť iba na väčší disk alebo na prázdny stĺp. 

![hanojské veže](/assets/icode/impl01.gif)

Problematika má rekurzívny charakter a v Jave by implementácia mohla vyzerať nasledovne.

```java
public class Main {

    /**
     * @param n pocet diskov
     * @param begin startovaci stlp
     * @param end koncovy stlp
     * @param tah ku stlpcu cislo
     * @return pocet vsetkych tahov, musi byt upraveny o hodnotu - 1
     */
    public static long hanoi(int n, int begin,int end,int toPutt) {
        long x = 1;
        long y = 1;
        if(n &gt; 1) {
            x = hanoi(n - 1, begin, toPutt, end);
        }
        System.out.println("Move " + n + " from tower " + begin + " to tower " + end);
        if(n &gt; 1) {
            y = hanoi(n - 1, toPutt, end, begin);
        }
        return x + y;
    }

    public static void main(String[] args) {
        int n = 4;
        long start = System.currentTimeMillis();
        long moves = hanoi(n, 1, 3, 2);
        System.out.println("count of moves: " + (moves - 1));
        double time = (System.currentTimeMillis() - start) / 1000.0;
        System.out.println("Computation with " + n + " towers" +
                " took " + time + " seconds");
    }
}
```

Metóda okrem toho, že vypíše každý jeden pohyb, vráti aj optimálny počet ťahov. 
Optimálny počet ťahov je rovný: 2n - 1 , kde n je počet diskov v hre.

Príklady:

- 3 disky: 7 ťahov
- 4 disky: 15 ťahov
- 5 diskov: 31 ťahov
- 6 diskov: 63 ťahov
- 7 diskov: 127 ťahov 
...

Výstupom pre uvedené volanie, kde rátame 4 disky na 3 stĺpoch je:


![Hanoi](/assets/icode/hanoi-300x226.png)
