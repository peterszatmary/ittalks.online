---
layout: post
title: Java - Čo je nové v Java 7
date: 2014-10-05
categories: programming java
tags: programming java
page.image.thumbnail: TODO
---

Java 7 uzrela svetlo sveta 7.7.2011. Oproti predošlej verzii 6 priniesla zopár noviniek, ktoré ovplyvnia aj písaný kód.

Sú to:

- **Switch so stringom**
- **Binárne číselné literály**
- **Multicatch**
- **Implicitný resource manažment v try bloku (try-with-resources)**
- **Diamond operátor**
- **Podčiarkovník v čiselných literátoch**
- **java.nio (new io)**
- **@SafeVarargs**

<br /><br />

### Switch so Stringom

Do verzie 6 Java zvládala switch iba s typmi: int, byte, short, long, enumeration.
Od verzie 7 je možné switch použiť aj s typom String.

*Java 7:*
```java
    String input = "1";
    switch(input) {
        case "1" : {System.out.println("1");break;}
        case "2" : {System.out.println("2");break;}
        case "3" : {System.out.println("3");break;}
        default: {System.out.println("ine cislo");break;}
    }
```

<br /><br />


### Binárne číselné literály

Hodnotu primitívnych typov byte, short, int, long možno od verzie 7 vyjadriť ako binárne číslo.
Viac si môžte prečítať v [Oracle dokumentácii](http://docs.oracle.com/javase/8/docs/technotes/guides/language/binary-literals.html).
 
```java
// 8 bitovy byte
byte aByte = (byte)0b00100001; // hodnota: 33

// 16 bitovy short
short aShort = (short)0b0010100101000101; // hodnota: 10565

// 32 bitove  int hodnoty
int anInt1 = 0b00100001010101011010000101000101; // hodnota: 559259973
int anInt2 = 0b101; // hodnota: 5
int anInt3 = 0B101; // hodnota: 5

// 64 bitovy long
long aLong = 0b0010000101010101101000010100010110100001010001011010000101000101L; // hodnota: 2402003296702538053
```

<br /><br />


### Multicatch

Často by sa hodilo spojiť viac dôvodov pádu aplikácie do jednej chybovej hlášky, logu a podobne.
 Verzia 7 túto možnosť má a tým skracuje kód, robí ho čitateľnejším.   

*Java 7:*

```java
try {
    // ....
} catch (UnsupportedOperationException | NullPointerException | ArrayIndexOutOfBoundsException e) {
       e.printStackTrace();
       System.out.println("informacia na standardny vystup");
}
```

*Java 6:*

```java
try {
    // ....
} catch (NullPointerException e) {
        e.printStackTrace();
        System.out.println("informacia na standardny vystup");
} catch (ArrayIndexOutOfBoundsException e) {
        e.printStackTrace();
        System.out.println("informacia na standardny vystup");
} catch (UnsupportedOperationException e) {
        e.printStackTrace();
        System.out.println("informacia na standardny vystup");
}
```


<br /><br />


### Implicitný resource manažment v try bloku (try-with-resources)

Vo verzii 6 pri prístupe ku externým zdrojov (súbory, databáza ...) bolo potrebné explicitne
 tieto zdroje uvoľňovať vo final bloku. Opäť bol prístup častokrát menej prehľadný a 
 pridával počty riadkov kódu navyše.

Vo verzii 7 nie je potrebné uvoľnovať zdroje explicitne, uvolnia sa ihneď po skončení 
try bloku. Try blok pridáva zátvorky (), do ktorých možno napísať kód pristupujúci
 k zdrojom a podľa toho bude vedieť java, ktoré zdroje má implicitne uvolniť.


*Java 7:*
```java
try (FileReader reader = new FileReader("path to file")) {
    int ch;
    while ((ch = reader.read()) != -1) {
          System.out.print(ch);
          reader.read();
    }
} catch (IOException ex) {
        ex.printStackTrace();
}
```


*Java 6:*
 
```java
FileReader reader = null;
try {
    try {
        reader = new FileReader("path to file");
        int ch;
        while ((ch = reader.read()) != -1) {
              System.out.print(ch);
              reader.read();
        }
   } finally {
       reader.close();
   }
} catch (IOException ex) {
     ex.printStackTrace();
}
```

<br /><br />

### Diamond operátor

Skrátenie typových zápisov na pravej strane výrazu v podobe diamond operátora <> 
jednak ušetrí programátora od zbytočného prepisovania typov z ľavej strany na pravú, 
skráti zápis, zníži možnú chybovosť kódu.

*Java 7:*

```java
List<String> list7 = new ArrayList<>();
Map<String, List<String>> l7 = new HashMap<>();
```

*Java 6:*

```java
List<String> list6 = new ArrayList<String>();
Map<String, List<String>> l6 = new HashMap<String, List<String>>();</pre> 
```

<br /><br />


### Podčiarkovník v čiselných literátoch

Používam ho ak je čiselný literál veľmi dlhý a zle by sa čítal. 
Teda podčiarkovník zvyšuje čitateľnosť dlhých číselných literálov. 
Viac si môžte prečítať v 
[Oracle dokumentácii](http://docs.oracle.com/javase/8/docs/technotes/guides/language/underscores-literals.html). 
  
*Java 7:*

```java
long creditCardNumber = 1234_5678_9012_3456L; // 1234567890123456</pre> 
```

*Java 6:*

```java
long creditCardNumber = 1234567890123456L;</pre> 
```

### java.nio (new io)

Predstavuje alternatívu ku java.io. Prináša potrebné utilitné metódy
 (pre prácu so súbormi, cestami, adresármi),
  čistejší exception handling, pridáva podporu symbolických odkazov a metadát a ďalšie.
Je bufrovo orientovaný zatiaľčo starý java.io je streamovo orientovaný. 

Pre záujemcov: [porovnanie io a nio](http://tutorials.jenkov.com/java-nio/nio-vs-io.html).

 
```java
Path path = Paths.get("sources.txt");
Files.copy(Paths.get("sources.txt"), Paths.get("sources2.txt"));
boolean isDir = Files.isDirectory(path);
Files.delete(path);
```
 

### @SafeVarargs

[Príklad kódu nižšie](http://www.angelikalanger.com/GenericsFAQ/FAQSections/ProgrammingIdioms.html#Why%20does%20the%20compiler%20sometimes%20issue%20an%20unchecked%20warning%20when%20I%20invoke%20a)
 vyhodí vo verzii javy 6 suppress warning ( riadky 9-12 ), ktorý možno potlačiť anotáciou **@SuppressWarnings("unchecked")** pre každé volanie nebezpečnej metódy ( riadky 1-3 ).


```java
public  static <E>; void addAll(List<E> list, E... array) { 
   for (E element : array) list.add(element); 
}
```

```java
@SuppressWarnings("unchecked")
public static void main(String[] args) { 
   addAll(new ArrayList<String>(),           // fine 
          "Leonardo da Vinci", 
          "Vasco de Gama" 
   ); 
   addAll(new ArrayList<Pair<String,String>>(), // unchecked warning 
          new Pair<String,String>("Leonardo","da Vinci"), 
          new Pair<String,String>("Vasco","de Gama") 
   ); 
}
```

 
Verzia 7 ponúka anotáciu **@SafeVarargs**, ktorú stačí aplikovať na podobne nebezpečnú 
implementáciu iba raz a nie na všetkých volajúcich.

Prečo tento problém vzniká si môžte prečítať 
[tu](http://www.angelikalanger.com/GenericsFAQ/FAQSections/ProgrammingIdioms.html#Why%20does%20the%20compiler%20sometimes%20issue%20an%20unchecked%20warning%20when%20I%20invoke%20a). 
V skratke možno povedať, že problémovým sa pre Javu stávajú polia s generickými typmi. Varargs sa prekladá na pozadí na pole.


```java
@SafeVarargs
public  static &lt;E&gt; void addAll(List&lt;E&gt; list, E... array) { 
   for (E element : array) list.add(element); 
}

public static void main(String[] args) { 
   addAll(new ArrayList&lt;String&gt;(),           // fine 
          "Leonardo da Vinci", 
          "Vasco de Gama" 
   ); 
   addAll(new ArrayList&lt;Pair&lt;String,String&gt;&gt;(), // not fine
          new Pair&lt;String,String&gt;("Leonardo","da Vinci"), 
          new Pair&lt;String,String&gt;("Vasco","de Gama") 
   ); 
}
```
