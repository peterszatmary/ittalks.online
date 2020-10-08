---
layout: post
title: Java - Vlákna JVM
date: 2014-09-21
categories: programming java
tags: programming java
page.image.thumbnail: TODO
---

Pre JVM beží niekoľo implicitných systémových vlákien, z ktorých každé má svoj účel pri behu Java aplikácie.

Najprv naprogramujeme jednoduchú aplikáciu, ktorá vypíše všetky bežiace vlákna. 
Upozorňujem čitateľa, keďže v aplikácii explicitne nespúštam ďalšie vlákna, 
očákavam naivne jedno bežiace vlákno, v ktorom beží aplikácia.

```java
package threads;

import java.util.Set;

public class Main {
    /**
     * vrati pole vsetkych vlakien
     * @return
     */
    public static Thread[] getThreads() {
        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
        Thread[] threadArray = threadSet.toArray(new Thread[threadSet.size()]);
        return threadArray;
    }

    public static void main(String[] args) {
        Thread[] threads = getThreads();
        for (Thread thread: threads) {
            System.out.println(thread);
        }
    }
}
```
  
Výsledkom je výpis.

![Threads](/assets/icode/threads.png)

Takže miesto jedného vlákna vidíme 5 vlákien. Vysvetlím ďalej účel každého vlákna ďalej.
 
- **main**: Vlákno, v ktorom beží aplikácia.
- **Reference Handler**: vysoko prioritné vlákno, ktoré pridáva do fronty čakajúce (momentálne nepoužívané) referencie. Je definovaný v java.lang.ref.References.java
- **Finalizer**: vyberá objekty z finalize fronty a spúšťa nad vybranými objektami metódu finalize.
- **Monitor Ctrl-Break**: vlákno, ktoré väčšinu času čaká. Má na starosti korektné ukončenie java aplikácie.
- **Signal Dispatcher**: vlákno, ktoré spracúvava natívne signály operačného systému a predáva ich ďalej na spracovanie JVM. Príkladom môžu byť signály, ktoré sa vytvoria po pohybe myšky, stlačení kláves na klávesnici ... 

