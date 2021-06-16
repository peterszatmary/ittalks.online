---
layout: post
title: Java - Recursive and non-recursive directory structure traversal
date: 2014-08-19
categories: programming java
tags: programming java
page.image.thumbnail: TODO
---

Although traversing the directory structure of the file system is purely recursive, I will show in the article the 
problem solved in both ways - recursively and non-recursively. The program code is written in Java.

### Recursive version

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


### Non-recursive version

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