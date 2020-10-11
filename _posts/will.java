By default, Maven creates a non-executable spring archive after building. That is, after running the build

`` `
mvn: install
`` `

and then try to run the generated spring

 
`` `java -jar xxxx.jar```

we receive the message ** no main manifest attribute, in xxxx.jar **


Maven need to learn that the generated spring archive should be executable
([executable jar] (http://en.wikipedia.org/wiki/JAR_%28file_format%29#Executable_JAR_files)).
Maven will generate [MANIFEST.MF] (https://docs.oracle.com/javase/tutorial/deployment/jar/manifestindex.html).

My solution that I like is:

- creating a dependency directory ([maven-dependency-plugin] (https://maven.apache.org/plugins/maven-dependency-plugin/))
- creation of MANIFEST.MF for a spring archive showing the dependencies mentioned in the first point ([maven-jar-plugin] (https://maven.apache.org/plugins/maven-jar-plugin/))


 
The result of such a build is an executable jar archive containing the MANIFEST.MF file and the lib directory with all the necessary dependencies.

Finally, I remind you that it is necessary to modify the parameter ** mainClass ** in this pom.xml when configuring * maven-jar-plugin *.
This parameter tells which class will start the application.