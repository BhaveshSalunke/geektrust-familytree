# geektrust-familytree

###Prerequisites -
```
 - Java8  
 - maven
```

###Set Up -

You can see following files in this directory
``` 
 - pom.xml    
 - README.md  
 - /src
 - mvnw
 - mvnw.cmd
 - /.mvn
```
Run following mvn command to download dependencies and generating build.
```
mvn clean install
```
Or you can run below command if maven is not installed
```
./mvnw clean install
```
This will download all the dependencies and will generate the executable jar in ```target``` directory.
Jar with name ```geektrust.jar``` will be present in ```target``` directory.

###Excecution -
Once the primary setup completes, you can start the execution of the application with this command -
```    
java -jar target/geektrust.jar <input file path>
```
This will execute the application taking provided input file and print all of the 
