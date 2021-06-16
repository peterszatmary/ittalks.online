---
layout: post
title: Java - JVM threads
date: 2014-09-21
categories: programming java
tags: programming java
page.image.thumbnail: TODO
---

The JVM runs several default system threads, each with its own purpose when running a Java application.

First, we program a simple application that lists all running threads.
I would like to warn the reader, as I do not explicitly run other threads in the application,
I'm naively expecting one running thread in which the application is running.

```java
package threads;

import java.util.Set;

public class Main {
    /**
     * returns the field of all threads
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
  
The Result

![Threads](/assets/icode/threads.png)

So instead of one thread we see 5 threads. I will explain the purpose of each thread below.
 
- **main**: The thread in which the application is running.
- **Reference Handler**: a high-priority thread that adds pending (currently unused) references to the queue. It is defined in java.lang.ref.References.java
- **Finalizer**: selects objects from the finalize queue and runs the finalize method over the selected objects.
- **Monitor Ctrl-Break**: a thread that waits most of the time. He is in charge of the correct termination of the java application.
- **Signal Dispatcher**: a thread that processes native operating system signals and resells them for JVM processing. Examples are signals that are generated after moving the mouse, pressing keys on the keyboard ...