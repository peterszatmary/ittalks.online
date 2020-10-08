---
layout: post
title: Maven - Ako pri builde vygenerovať test jar osobitne
date: 2015-05-03
categories: programming maven
tags: programming maven
page.image.thumbnail: TODO
---

Ak je potrebné Maven naučiť generovať jeden test jar archív so všetkými testovacími triedami slúži na to
plugin [maven-jar-plugin](https://maven.apache.org/plugins/maven-jar-plugin/) s prepínačom **test-jar**.

Po spustení 

```
mvn:install
```

sa vygeneruje aj jar archív *szatmary.peter.rest.dopatra-1.0-SNAPSHOT-tests.jar*.

```xml
<pre class="lang:default decode:true " ><project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>szatmary.peter.rest.dopatra</groupId>
  <artifactId>szatmary.peter.rest.dopatra</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>jar</packaging>

  <name>szatmary.peter.rest.dopatra</name>
  <url>http://maven.apache.org</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>

  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-jar-plugin</artifactId>
        <executions>
          <execution>
            <goals>
              <goal>test-jar</goal>
            </goals>
          </execution>
        </executions>
      </plugin>      
    </plugins>
  </build>

  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
</project>
```