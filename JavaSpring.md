
<details>
  <summary> Maven </summary>
  
* Maven is a tool to build and manage any java project. It is a software management and comprehension tool based on Project Object Model. It allows to to publish project information and share JARs accroos several projects. The result is a tool that can be used for building any java-based-project
* POM (Project Object Model) is an XML file that contains information about project and configuration details use by Maven to build project
#### Install Maven
* Make sure JDK is installed in your system. Make sure JAVA_HOME variable is set to the path that JDK folder exist(Windows)
```java
brew install maven
mvn --version  // check maven exist!
```
* Download as binary zip file, then move it to the folder you want to run project
* Set System variables. 
```java
export M2_HOME=/Users/amirnabaei/Desktop/sites/DM_Java/apache-maven-3.5.4
export PATH=$PATH:/Users/amirnabaei/Desktop/sites/DM_Java/apache-maven-3.5.4/bin
```
* In order to save them into `.profile` we need to use `>>` or directly add to `.bash_profile` or `.profile`
* If you check `mvn --verison` you should get the reuslt to see hidden files in mac you have 
```java
defaults write com.app.finder AppleShowAllFiles TRUE
```
* Install Hellow world Maven Java with
```java
mvn archetype:generate -DgroupId=com.jcg.maven -DartifactId=MavenHelloWorldProject -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
* Then follow [this](https://examples.javacodegeeks.com/enterprise-java/maven/apache-maven-hello-world-example/) to create Maven from Eclipse
</details>
<details>
  <summary> MySQL </summary>
  
 * If you forgot mysql password when running 
 ```java
 mysql.server start
 mysql -u root -p
 
 ```
 * Then you need to remove mysql and dowload it again as [here](https://coderwall.com/p/os6woq/uninstall-all-those-broken-versions-of-mysql-and-re-install-it-with-brew-on-mac-mavericks)
 
  </details>
  
  <details>
  <summary> REST API </summary>
  
  * A good resource to have hello world [Java](https://github.com/callicoder/spring-boot-mysql-rest-api-tutorial)
  * To overcome one issue, you may change the version from `2.0.0` to `2.0.1` 
  * Just clone it and make sure your username and passwords are same as the system username and passwords and also create approperiate databse for the app in mysql. 
  * To run the app
  ```java
  mvn spring-boot:run
  ```
  </details>
  <details>
  <summary> Spring MVC </summary>
  
  * It helps to avoid boring boilerplate tasks (copy&paste) to write a java applicaiton. 
  * `JavaBean` vs `POJO`. `POJO` is an object that has both attributes and behavior and this behavior doesn't have to be getter and setter only. On the other hand, `JavaBean` is a simple type of `POJO` which behavior is only getter and setter. 
  * Now `DTO` is nothhing more than a JavaBean whose sole purpose is to transport data from one layer to another
  * Spring has embedded `Tomcat` app server(other option is `Jetty`). 
  * `dispatch serverlet` handle all URL requests. 
  * Start spring Initializer from this [spring initializer](https://start.spring.io/). We make package name to same as group name. For packaging we have `jar`and `war`. If you wanna to deploy this to existed Tomcat, or Web Login or Websphere a `WAR` is better. This example is going to use `JAR`. In advances select `web` and `Thymeleaf` and under `SQL` select `JPA` and `H2` and in Ops section select `Actator`.
  * Now if you run the application (in intelig you can run it from top corener green) then check port `8080` which you see 404 page. Then go to `resources/static` folder add new html file index.html. 
  * In `resources/application.properties` you can change the port. Also we can use yaml and profile in more advances  
  ```java
  server.port = 8000
  ```
  ### Scheam.sql
  * It is data defination language for embeded database. we can put it into resources foleder. It would be like
  ```sql 
  CREATE TABLE ROOM(
  ROOM_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  NAME VARCHAR(16) NOT NULL,
  ROOM_NUMBER CHAR(2) NOT NULL UNIQUE,
  BED_INFO CHAR(2) NOT NULL
);

CREATE TABLE GUEST(
  GUEST_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  FIRST_NAME VARCHAR(64),
  LAST_NAME VARCHAR(64),
  EMAIL_ADDRESS VARCHAR(64),
  ADDRESS VARCHAR(64),
  COUNTRY VARCHAR(32),
  STATE VARCHAR(12),
  PHONE_NUMBER VARCHAR(24)
);

CREATE TABLE RESERVATION(
  RESERVATION_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  ROOM_ID BIGINT NOT NULL,
  GUEST_ID BIGINT NOT NULL,
  RES_DATE DATE
);

ALTER TABLE RESERVATION ADD FOREIGN KEY (ROOM_ID) REFERENCES ROOM(ROOM_ID);
ALTER TABLE RESERVATION ADD FOREIGN KEY (GUEST_ID) REFERENCES GUEST(GUEST_ID);
CREATE INDEX IDX_RES_DATE_ ON RESERVATION(RES_DATE);
  ```
  * In order to have DML for us then we can have `data.sql` in resources folder as 
  ```sql
  INSERT INTO ROOM (NAME, ROOM_NUMBER, BED_INFO) VALUES ('Piccadilly', 'P1', '1Q');
  INSERT INTO ROOM (NAME, ROOM_NUMBER, BED_INFO) VALUES ('Westminster', 'W1', '1K');
  INSERT INTO GUEST (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, COUNTRY, ADDRESS, STATE, PHONE_NUMBER) VALUES('Wright', 'Kimberly', 'kwrightf@tinyurl.com', 'Brazil', '9893 Summit Plaza', '', '3-(288)433-6668');
  ```
  ### Add Property
  
  * This add a property to application property file. It requires `hibernate` when we pre populating schema. This stop hibernate from generating schema on its own whhich can remove all data and create a new one. That is why we set it to none. 
  ```java
  spring.jpa.hibdernate.ddl-auto = none
  ```
  ### Sprng Data vs JDBC
  * In `JDBC` you have to deal with connection, create the connection, build statement, execute query against that statement to get result set, then iterate thhrough our result to get objects. This process has to be done for each database call it would be like
  ```java
  connection= DriverManager.getConnectoin("jdbc:h2:~/test","sa","");
  String sql = "SELECT Room_ID, ROOM_NAME from ROOM where ROOM_NUMBER= 'p1'");
  statement = connection.CreateStatement();
  ResultSet resultSet = statement.executeQuery(sql);
  while(resultSet.Next()){
   Room room = new Room();
   room.setId(resultSet.getLong("ROOM_ID"));
   room.setId(resultSet.getLong("ROOM_NAME"));
   ...
   return room 
  }
  .....
  ```
  But in spring data we have almost 20 lines of code with this but still needs a little setup as well. 
  ```java
  public Room getRoomSpringData(){
       return this.roomRepository.findByNumber("p1")
  }
  ```
  
  ### Application Class
  * In `src/Java/com.example` subfolders you find applicaiton packages as `nameofyourproject.java` which this annotation `@SpringBootApplication` controls it.  
  
  
  ### Create A Package
  * Navigate to `src/main/java` and create package like `london.data.entity` and then create a new class(same name as a table) inside the package
 * create several attributes like what we have in our tables
  ```java
  package come.frnkmoly.landon.data.entity;
  
  import javax.persistence.Entity;
  import javax.persistence.Column;
  import javax.persistence.GenerateValue;
  import javax.persistence.GenerationType;
  import javax.persistence.Id;
  import javax.persistence.Table;
  
  @Entity
  @Table(name="ROOM")
  public class Room {
  private long id;
  @Column(name="NAME")
  private String name;
  @Column(name="ROOM_NUMBER")
  private String number;
  }
  ```
  * Since we use hybernet we neet to use some annotaion in this class. Then define for each one a setter and getter funcitons.
  * Next we need to `get out` these from ROOM.JAVA. For this reason we create another package like (london.data.repository) And create a class (interface) and initate this class with add repository and we extend it with CRUD repository as
  ```java
 package com.frankmoley.landon.data.repository;

import com.frankmoley.landon.data.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long>{
    Room findByNumber(String number);  
}
  ```
  * This is going to make query from ROOM table where the Number is equal to `number`! you can have all booleans and filters as this
  * It means we have an object Room from the class we already created and also a long for id of room. This allows us to have basic crud opertions. 
  </details>
<details>
   <summary> Create a Spring Web Service </summary>
  
 * After creating one from spring initializer, then you need to import it to Eclipse, as maven folder. 
 * To start it write click on javaname in com.name and run as java application
 * 
 
</details>
<details>
  <summary> Start & Connect to MySQL</summary>
  
  * JPA helps to Java developers to access database without writing queries. 
  * Object Relational Mapping helps to connect Java to relational database. This is known JPA and Hibernet is an instance provider for JPA. Annotations defines metadata to map Java Objects in database. JPA lives in JAVAX persitance package. 
  * Spring scan for entities. Entities have unique name, attributes, setters and getters. JPQL is java object relational language looks like SQL and returns collection of entities instead of rows like in sql. JPA doesnt support schemaless or NoSQL. It just support relational databases. 
  * Downlod it from spring initalizer io, with selecting web and mysql 
  ```java
  mysql -u root 
  create database greeting;
  create user 'greetuser'@'localhost' identified by 'greetpwd';
  grant all on greeting.* to 'greetuser'@'localhost';
  flush privileges;
  ```
Application.properties:
```java
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost/greeting
spring.datasource.username=greetuser 
spring.datasource.password=greetpwd 
spring.datasource.name=greeting
```
Add this to pom.xml
```java
<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<scope>runtime</scope>
</dependency>
```
Then
```java
mvn spring-boot:run
```
Now it should work on 
```
http://localhost:8080/
```
 </details>
 <details>
	<summary> CREAT REST </summary>	

* Followed [this](https://www.youtube.com/watch?v=kbisNUfqVLM&t=16s)
* Remember name controller and models based on applications 
* Create Model package into `src/main/java` Then create a class `greeting` inside that. Create 
```java
private BigInteger id;
private String text;
public greeting {
}
```
* Then go to source select create getter and setter. 
* Then create another package name controller and a class name greetingController. Inside that add `@RestController` to let it know the resond is json or xml
* This is a restful controller service 
```java
package com.sfutlc.sfutlc.controller;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sfutlc.sfutlc.model.Greeting;
@RestController
public class GreetingController {
    private static BigInteger nextId;
    private static Map<BigInteger, Greeting> greetingMap;
    private static Greeting save(Greeting greeting) {
        if (greetingMap == null) {
            greetingMap = new HashMap<BigInteger, Greeting>();
            nextId = BigInteger.ONE;
        }
        greeting.setId(nextId);
        nextId = nextId.add(BigInteger.ONE);
        greetingMap.put(greeting.getId(), greeting);
        return greeting;
    }
    static {
        Greeting g1 = new Greeting();
        g1.setText("Hello World!");
        ;
        save(g1);

        Greeting g2 = new Greeting();
        g2.setText("Hola Mundo!");
        save(g2);
    }
    @RequestMapping(value = "/api/greetings")
    public ResponseEntity<Collection<Greeting>> getGreetings() {
        Collection<Greeting> greetings = greetingMap.values();
        return new ResponseEntity<Collection<Greeting>>(greetings,
                HttpStatus.OK);
    }
}
```
* Then check `/api/greetings`
</details>
 <details>
	<summary> Get Show  </summary>

* In order to define a show for an item we can define it as
```java
@RequestMapping(
    		value = "/api/greetings/{id}",
    		method = RequestMethod.GET,
    		produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Greeting> getGreeting(@PathVariable("id") BigInteger id)
    {
    	Greeting greeting = greetingMap.get(id);
    	if (greeting == null)
    	  {
    	   return new ResponseEntity<Greeting>(HttpStatus.NOT_FOUND);	
    	  }
    return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);	
    }
```
 </details>
<details>
	<summary> POST </summary>
	
* To add a post 	
```java
    @RequestMapping(
    		value = "/api/greetings",
    		method = RequestMethod.POST,
    		produces = MediaType.APPLICATION_JSON_VALUE,
    		consumes = MediaType.APPLICATION_JSON_VALUE
    		)
     public ResponseEntity<Greeting> createGreeting(@RequestBody Greeting greeting) {
    	  Greeting savedGreeting = save(greeting);
    			  return new ResponseEntity<Greeting>(savedGreeting, HttpStatus.CREATED);
    }
```
* And in post map use post with this json raw
```java
{"text": "this is test"}
```
</details>


