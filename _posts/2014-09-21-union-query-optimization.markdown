---
layout: post
title: UNION query optimization
date: 2014-09-21
categories: programming sql
tags: programming sql
page.image.thumbnail: TODO
---

The UNION query is used in sql to join two or more tables.
The article will discuss the properties and optimization of UNION queries against databases.

First of all, there are two different questions, namely UNION and UNION ALL.
When asked which of the two is faster, what are their properties I will answer on the following lines.

### UNION

UNION joins two tables without duplicates.

```mysql-sql
select a,b from tableA UNION select a,b from tableB
```

This means that in the background of this query, the two tables are merged first, then sorted
  and finally duplicates are removed. The result at this point is what the user gets.
   UNION is slower than UNION ALL due to these added operations it performs in the background.
   
### UNION ALL

UNION joins two tables with duplicates.
 
```mysql-sql
select a,b from tableA UNION ALL select a,b from tableB
```


The first level of optimization is to realize whether it is necessary to use UNION or whether a faster UNION ALL is enough.

In the second level, there is a limit on the size of the sets that join before they join.

### Optimal query

```mysql-sql
select a,b from tableA where a = 'TODAY' UNION select a,b from tableB where a = 'TODAY'
```


If it is possible to shrink sets before joining in the where clause do so.


A few UNION basics:

- The number of columns in the tables we are joining must be the same.
- The types of table columns we join must be the same in order.
