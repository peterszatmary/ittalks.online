---
layout: post
title: Grafická reprezentácia krivky učenia sa vyjadrená v pojmoch
date: 2020-10-01
categories: in-slovak
tags: in-slovak uvaha
---

Ako by ste znázornili to ako rýchlo sa učíte a zároveň ako veľa ste sa už naučili ?

Táto metrika je iba mojou úvahou, 
ale možno čosi podobné už existuje, čo nevylučujem.

Námet na článok mi napadol, keď som sa učil [umelú inteligenciu](https://peterszatmary.com/ai).

Ak si ako základnú metriku vezmeme počet pojmov v doméne, môžme sledovať proces nášho učenia sa a vyjadrovať ho aj graficky.

Budme presnejší, bude nás zaujímať schopnosť učiť sa a tú vyjadríme ako pomer **naučený pojem / novoobjavený pojem**, ktorý sa v budúcnosti opať treba naučiť a objavil sa v procese učenia aktuálneho pojmu.

```
naučený pojem / nový pojem 
```

Zjednodušme si situáciu a predpokladajme, že počet pojmov je konštatný. Nemení sa, čo ale
v praxi vieme, že nie je pravda.


## Učenie sa

Naučme sa pojem napríklad prečitaním článku.

![](/assets/imgs/learn/learn1.png)

V článku nájdeme nové 3 pojmy

![](/assets/imgs/learn/learn2.png)

Tieto pojmy sa ďalej učíme a ďalej prichádzame na nové pojmy,
 ktoré sa treba učiť a týmto učením nachádzame ďalšie pojmy. Až sa obrazec začne podobať na strom.
 
![](/assets/imgs/learn/learn3.png)

Krivka sa v jeden moment začne **obracať**, čo bude znamenať, že sme približne niekde **v strede učenia** sa
(vieme akúsi polovicu domény), a od teraz už nebude príval nových pojmov tak veľký, bude naopak stále menší. 

Jedného ďňa už neobjavíme **žiadny nový pojem** ( doménu sme sa naučili celú ).
Obrazec sa môže podobať na nasledujúci útvar, kde začiatok učenia je dole a smer učenia je rovný smeru hore.

![](/assets/imgs/learn/learn4.png)


## Pomalé učenie (rýchlo sa vyvíjajúca doména)

Doteraz sme uvažovali o doméne, ktorá je konštatná, čo znamená, že počet pojmov domény sa v čase nemení.

Uvažujme, ale o reálnom prípade a to o doméne, kde vznikajú nové a nové pojmy rôznou rýchlosťou.


- Ak by počet pojmov ubúdal veľmi pomaly obrázok by kulminoval ku čiare
- znamená to, že 
   - naše učenie je rýchlejšie ako vznik nových pojmov, ale nie dostatočne
   - jedného dňa obrazec zkulminuje do jedného bodu a my dokončime učenie sa
   - učenie je pomalé
   - vývoj domény v čase je rýchlý

![](/assets/imgs/learn/learn6.png)

### Rýchle učenie (pomaly vyvíjajúca sa doména)

Ak by sme učenie zrýchľovali alebo vývoj domény sa spomaľovaľ viac a viac dostávali by sme nasledovné.

![](/assets/imgs/learn/learn5.png)

Ak by bolo učenie ešte rýchlejšie

![](/assets/imgs/learn/learn4.png)

obrazec by bol čím viac placatejší, pretože Y osa predstavuje čas učenia sa.

To koľko sme sa naučili zase vyjadruje obsah obrazca. 

### Učenie pomalšie ako vývoj domény

Čo ak by bolo učenie pomalšie ako process tvorby nových pojmov ?

![](/assets/imgs/learn/learn7.png)

A učenie by bolo ešte pomalšie.

![](/assets/imgs/learn/learn8.png)

Ako vidno obrázok by nezkulminoval do jedného bodu. Nikdy by sme sa nenaučili všetky pojmy, to znamená celú doménu.

### Záver

Mnohokrát je vyjadrenie istej skutočnosti priamočiarejšie, čitateľnejšie, pochopiteľnejšie
 formou obrázku. Pri štúdiu úplne novej oblasti pre mňa som si všimol, že prvé, čo sa v skutočnosti učím sú pojmy domény.
 A tak mi vlastne napadla táto úvaha. 



 
