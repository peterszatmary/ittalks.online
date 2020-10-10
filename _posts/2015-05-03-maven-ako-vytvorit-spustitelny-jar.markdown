---
layout: post
title: Maven - Ako vytvoriť spustiteľný jar
date: 2015-05-03
categories: programming maven
tags: programming maven
page.image.thumbnail: TODO
---

Maven defaultne vytvára nespustiteľný jar archív po builde. To znamená, že po spustení buildu


```
mvn:install
```

a následnom pokuse spustiť vygenerované jar

 
```java -jar xxxx.jar```

obdržíme hlášku **no main manifest attribute, in xxxx.jar**


Maven musíme naučiť, že generovaný jar archív má byť spustiteľný 
([executable jar](http://en.wikipedia.org/wiki/JAR_%28file_format%29#Executable_JAR_files)). 
Maven vygeneruje [MANIFEST.MF](https://docs.oracle.com/javase/tutorial/deployment/jar/manifestindex.html).

Mojím riešením, ktoré obľubujem je:

- vytvorenie adresára so závislosťami ([maven-dependency-plugin](https://maven.apache.org/plugins/maven-dependency-plugin/))
- vytvorenie MANIFEST.MF pre jar archív ukazujúci na závislosti spomenuté v prvom bode ( [maven-jar-plugin](https://maven.apache.org/plugins/maven-jar-plugin/) )


 
Výsledkom takého buildu je spustiteľný jar archív obsahujúci súbor MANIFEST.MF a adresár lib so všetkými potrebnými závislosťami.

Na záver pripomínam, že je potrebné upraviť v tomto pom.xml ešte parameter **mainClass** , keď konfigurujeme *maven-jar-plugin*. 
Tento parameter hovorí o tom, ktorá trieda spustí aplikáciu.
  
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
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
        <artifactId>maven-dependency-plugin</artifactId>
        <executions>
          <execution>
            <id>copy-dependencies</id>
            <phase>prepare-package</phase>
            <goals>
              <goal>copy-dependencies</goal>
            </goals>
            <configuration>
              <outputDirectory>${project.build.directory}/lib</outputDirectory>
              <overWriteReleases>false</overWriteReleases>
              <overWriteSnapshots>false</overWriteSnapshots>
              <overWriteIfNewer>true</overWriteIfNewer>
            </configuration>
          </execution>
        </executions>
      </plugin>

      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-jar-plugin</artifactId>
        <!-- create executable jar -->
        <configuration>
          <archive>
            <manifest>
              <addClasspath>true</addClasspath>
              <classpathPrefix>lib/</classpathPrefix>
              <mainClass>szatmary.peter.rest.dopatra.App</mainClass>
            </manifest>
          </archive>
        </configuration>
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