---
layout: post
title: Maven - How to create an executable jar file
date: 2015-05-03
categories: programming maven
tags: programming maven
page.image.thumbnail: TODO
---

By default, Maven creates a non-executable jar archive after building. After running the build

`` `
mvn: install
`` `

then try to run the generated jar

 
```
java -jar xxxx.jar
```

we receive the message **no main manifest attribute, in xxxx.jar**


Maven need to learn that the generated spring archive should be executable
([executable jar](http://en.wikipedia.org/wiki/JAR_%28file_format%29#Executable_JAR_files)).
Maven will generate [MANIFEST.MF](https://docs.oracle.com/javase/tutorial/deployment/jar/manifestindex.html).

My solution that I like is:

- creating a dependency directory ([maven-dependency-plugin](https://maven.apache.org/plugins/maven-dependency-plugin/))
- creation of MANIFEST.MF for a spring archive showing the dependencies mentioned in the first point ([maven-jar-plugin](https://maven.apache.org/plugins/maven-jar-plugin/))

 
The result of such a build is an executable jar archive containing the MANIFEST.MF file and the lib directory with all the necessary dependencies.

Finally, I remind you that it is necessary to modify the parameter **mainClass** in this pom.xml when configuring *maven-jar-plugin*.
This parameter tells which class will start the application.
  
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