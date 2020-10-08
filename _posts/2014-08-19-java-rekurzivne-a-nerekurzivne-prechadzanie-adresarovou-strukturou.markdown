---
layout: post
title: Java - Rekurzívne a nerekurzívne prechádzanie adresárovou štruktúrou
date: 2014-08-19
categories: programming java
tags: programming java
page.image.thumbnail: TODO
---

Napriek tomu, že prechádzanie adresárovej štruktúry file systému má čisto rekurzívnu povahu, v článku ukážem ten
 istý problém riešený aj rekurzívne aj nerekurzívne. Programový kód je písaný v jazyku Java.


### Rekurzívna verzia

```java
public class Walker {
    public static void walk(File file) {
        System.out.println(file.getAbsolutePath());
        File[] children = file.listFiles();
        if (null != children) {
            for (File child : children) {
                walker(child);
            }
        }
    }
}
```


### Nerekurzívna verzia

```java
public class Walker {
    public static walk(String path, int d) {
        File root = new File(path);
        List<File> ex = new LinkedList<File>();
        ex.add(root);

        for (int depth = 0; depth < d; depth++) {
            File[] fs = ex.toArray(new File[ex.size()]);
            ex.clear();
            for (File file: fs) {
                System.out.println("depth = " + depth + ", file = " + file);
                if (file.isDirectory()) {
                    ex.addAll(Arrays.asList(file.listFiles()));
                }
            }
        }
    }
}
```