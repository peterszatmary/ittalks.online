---
layout: post
title: Play! framework - i18n
date: 2015-08-02
categories: programming java
tags: programming java
page.image.thumbnail: TODO
---

The article will discuss how to easily create different language translations for a programmed application
v Play! framework. The user can thus choose the language mutation that suits him best.

We are talking about [i18n](https://en.wikipedia.org/wiki/Internationalization_and_localization), 
what is abbreviation [Internationalization and localization](https://en.wikipedia.org/wiki/Internationalization_and_localization).

You need to create **messages.xxx** files in an existing project. xxx is information about
[language codes](https://www.loc.gov/standards/iso639-2/php/code_list.php) (ISO 639-2 language code) plus nepovinne o 
[country codes](http://data.okfn.org/data/core/country-list) (ISO 3166-1 alpha-2 country code). 
Save the message files in the **conf/** directory.


Example: en, en-US, fr čiže messages.en, messages.en-US, messages.fr. 


### Example of i18n v Play!


We will create 2 language mutations. English and Slovak.

It is necessary to let them know about them in the file **conf/application.conf**.

```
play.i18n.langs = [ "sk","en" ]
```


### Slovak translation file messages.sk

 
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


### English translation file messages.en

 
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

On the presentation page (View) we will refer to the texts using their keys in the messages.xxx files.
 
```
<h1>@Messages("index.text.input.password")</h1>
```

### Change to English translation:

```
Application.changeLang("en")
``` 

Change to Slovak translation:

```
Application.changeLang("sk")
```

For more info [play i18n](https://www.playframework.com/documentation/2.3.x/ScalaI18N)

Kind of starting project you can [check here](https://bitbucket.org/peterszatmary/playstartproject)

Illustration images

![sk](/assets/icode/sk.png)

![en](/assets/icode/en.png)