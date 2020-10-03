---
layout: post
title: Grafická reprezentácia krivky učenia sa vyjadrená v pojmoch
date: 2020-10-01
categories: uvaha
tags: uvaha
---

Ako by ste znázornili to ako rýchlo sa učíte a zároveň ako veľa ste sa už naučili ?

Táto metrika je iba mojou skromnou úvahou, 
ale možno čosi podobné už existuje, čo nevylučujem.

Námet na článok mi napadol, keď som sa učil [umelú inteligenciu](https://peterszatmary.com/ai).

Ak si ako základnú metriku vezmeme počet pojmov v doméne, môžme sledovať proces nášho učenia sa a vyjadrovať ho aj graficky.

Budme presnejší, bude nás zaujímať schopnosť učiť sa a tú vyjadríme ako pomer naučený pojem / novoobjavený pojem, ktorý sa v budúcnosti opať treba naučiť a objavil sa v procese učenia aktuálneho pojmu.

```
naučený pojem / nový pojem 
```

Zjednodušme si situáciu a predpokladajme, že počet pojmov je konštatný. Nemení sa, čo ale
v praxi vieme, že nie je pravda.

Dôsledok tejto skutočnosti, ako neskôr uvidíte, môže byť rovnaký ak

- učenie je omnoho rýchlejšie ako vznik nových pojmov

Naučme sa pojem napríklad prečitaním článku.

TODO img

V článku nájdeme nové 4 pojmy

TODO img

Tieto pojmy sa ďalej učíme a ďalej prichádzame na nové pojmy,
 ktoré sa treba učiť a týmto učením nachádzame ďalšie pojmy.
 
TODO img

Až sa krivka nezačne obracať, čo bude znamenať, že sme približne niekde v strede učenia 
(vieme akúsi polovicu domény) , a od teraz už mebude príval nových pojmov tak veľký ale bude stále menší. 


Jedného ďňa už neobjavíme žiadny nový pojem ( doménu sme sa naučili celú ).

TODO img

Ešte sa pohrajme s interpretáciou a zakomponujme do našej úvahy čas učenia, teda rýchlosť.

TODO

- Ak by počet pojmov ubúdal veľmi pomaly obrázok by kulminoval ku čiare

TODO ukáž na pr ako od ku čiare.

- obsah obrazca vyjadruje všetko, čo sme sa naučili. 

Čo ak by bolo učenie pomalšie ako process tvorby nových pojmov ?


TODO obrázok

Ako vidno obrázok bz nezkulminoval do jedného bodu.


TODO záver
Mnohokrát je vyjadrenie istej skutočnosti priamočiarejšie, čitateľnejšie, pochopiteľnejšie formou obrázku.



 
