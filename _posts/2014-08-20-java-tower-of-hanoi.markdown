---
layout: post
title: Java - Tower of Hanoi
date: 2014-08-20
categories: programming java
tags: programming java
page.image.thumbnail: TODO
---

Tower of Hanoi is a famous mathematical game. It consists of three columns and a number of disks of different sizes.
The game starts with the number of discs on the left, which are stacked from the largest disc to the smallest.
The game ends when the player manages to move all the discs to the last column in the same order.
However, two rules must be followed:

- Only one disc can be moved in one turn
- A disc can only be placed on a larger disc or on an empty column.

![Tower of Hanoi](/assets/icode/impl01.gif)

The problem is recursive and in Java the implementation could look like this.

```java
public class Main {

    /**
      * @param n number of disks
      * @param begin start column
      * @param end end column
      * @return number of all moves, must be adjusted by the value - 1
     */
    public static long hanoi(int n, int begin, int end, int toPutt) {
        long x = 1;
        long y = 1;
        if(n > 1) {
            x = hanoi(n - 1, begin, toPutt, end);
        }
        System.out.println("Move " + n + " from tower " + begin + " to tower " + end);
        if(n > 1) {
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

In addition to listing every single move, the method also returns the optimal number of moves.
The optimal number of moves is equal to: 2n - 1, where n is the number of discs in the game.

Examples:

- 3 discs: 7 moves
- 4 discs: 15 moves
- 5 discs: 31 moves
- 6 discs: 63 moves
- 7 discs: 127 moves
...

The output for this call, where we count 4 disks on 3 columns, is:


![Hanoi](/assets/icode/hanoi-300x226.png)
