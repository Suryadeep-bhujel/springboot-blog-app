### Install Java
```https://docs.oracle.com/en/java/javase/24/install/installation-jdk-macos.html#GUID-2FE451B0-9572-4E38-A1A5-568B77B146DE```
## Setup Envirnment Variable 
```export JAVA_HOME=$(/usr/libexec/java_home -v 24.0.1)``` <br>
```export PATH=$JAVA_HOME/bin:$PATH```
### Install Maven
Install Maven using below command <br>
``` brew install maven ``` <br>
```export MAVEN_OPTS="--enable-native-access=ALL-UNNAMED"```
Check Maven Version <br>
```mvn --version```
To Install maven <br>
```./mvnw clean install```
### Install Springboot
### Setup Spring

### Springboot Authentication reference 
- https://www.geeksforgeeks.org/how-to-implement-simple-authentication-in-spring-boot/
## Spring Starter security setup 
- https://central.sonatype.com/artifact/org.springframework.boot/spring-boot-starter-security
## Connect postgresSql DB 
- https://www.youtube.com/watch?v=pR5-lO5hgUA
### Hybernate connection setup 
- https://chatgpt.com/share/681eb5b4-a378-8006-a524-db375bf23557

## Reference Tutorial to learn Springboot 
- https://www.youtube.com/watch?v=gJrjgg1KVL4

## Command to run the application
```./mvnw spring-boot:run ```
## Creating Seeder 
```https://chatgpt.com/share/681eb6f9-d968-8006-877f-4fb078b44c66```

### Extra resource 
- https://chatgpt.com/share/681eb7da-f598-8006-b8c4-7285c4d958e7
- https://www.cdata.com/kb/tech/postgresql-jdbc-spring-boot.rst#:~:text=To%20connect%20to%20PostgreSQL%2C%20set,to%20the%20user's%20default%20database.
- https://chatgpt.com/share/681eb821-57a4-8006-9c65-1cc2db8773bd
- https://chatgpt.com/share/681eb83e-46a4-8006-a86c-cd5fc22502dd
