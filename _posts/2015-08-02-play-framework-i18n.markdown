---
layout: post
title: Play! framework - i18n
date: 2015-08-02
categories: programming java
tags: programming java
page.image.thumbnail: TODO
---

Článok bude pojednávať o tom ako jednoducho vytvoriť rôzne jazykové preklady pre aplikáciu programovanú
v Play! frameworku. Používateľ si vie tak navoliť jazykovú mutáciu, ktorá mu najviac vyhovuje.

Hovoríme o [i18n](https://en.wikipedia.org/wiki/Internationalization_and_localization), 
čo je skratka pre [Internationalization and localization](https://en.wikipedia.org/wiki/Internationalization_and_localization).


V existujúcom projekte je potrebné vytvoriť **messages.xxx**  súbory. xxx je informácia o 
[kóde jazyka](https://www.loc.gov/standards/iso639-2/php/code_list.php) (ISO 639-2 language code) plus nepovinne o 
[kóde krajiny](http://data.okfn.org/data/core/country-list) (ISO 3166-1 alpha-2 country code). 
Messages súbory uložte do adresára **conf/**.


Príklad: en, en-US, fr čiže messages.en, messages.en-US, messages.fr. 


### Príklad i18n v Play!


Vytvoríme 2 jazykové mutácie. Anglicky a slovensky. 

Je potrebné o nich dať vedieť a to v súbore **conf/application.conf**.

```
play.i18n.langs = [ "sk","en" ]
```


### Slovenský preklad súbor messages.sk

 
```
index.title=: Vitajte !
index.text.welcome=Vitajte !
index.text.email=Email
index.text.password=Heslo
index.text.input.email=Zadaj Email
index.text.input.password=Zadaj Heslo
index.text.login.ok=Prihlas
index.text.registration=Registracia
index.text.password_forgotten=Zabudol som heslo
``` 


### Anglický preklad súbor messages.en

 
```
index.title=\: Welcome \!
index.text.welcome=Welcome !
index.text.email=Email
index.text.password=Password
index.text.input.email=Type Email
index.text.input.password=Type Password
index.text.login.ok=Log In
index.text.registration=Registration
index.text.password_forgotten=I forgot password
```

### View

Na strane prezentácie (View) budeme odkazovať na texty pomocou ich kľúčov v súboroch messages.xxx.

 
```
<h1>@Messages("index.text.input.password")</h1>
```


### Zmena jazyka

Zmena na anglický preklad:
```
Application.changeLang("en")
``` 

Zmena na slovenský preklad:
```
Application.changeLang("sk")
```


Pre viac info [play i18n](https://www.playframework.com/documentation/2.3.x/ScalaI18N)

Cvičný Play projekt na bitbuckete si môžte [prezrieť tu](https://bitbucket.org/peterszatmary/playstartproject) 

Ilustračné obrázky

![sk](/assets/icode/sk.png)

![en](/assets/icode/en.png)