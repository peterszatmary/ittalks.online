---
layout: post
title: Maven - How to generate a jar archive with Javadoc during build
date: 2015-05-03
categories: programming maven
tags: programming maven
page.image.thumbnail: TODO
---

If you need to learn Maven to generate a javadoc to the jar archive, use plugin
[maven-javadoc-plugin](https://maven.apache.org/plugins/maven-javadoc-plugin/).

**After run** 

`mvn:install` 

a jar archive *szatmary.peter.rest.dopatra-1.0-SNAPSHOT-javadoc.jar* containing javadoc project documentation is also generated.
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
      <!-- creates javadoc jar -->
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-javadoc-plugin</artifactId>
        <version>2.10.3</version>
        <executions>
          <execution>
            <id>attach-javadocs</id>
            <goals>
              <goal>jar</goal>
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