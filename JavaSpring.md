
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
Then start the embeded apache tomcat server on port 8080
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
	
* List of [videos](https://www.youtube.com/channel/UChCCDds_KM-w02yVn7cQI_Q)
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
	
* To add a post we have below. We add `@RequestBody Greeting greeting` to tell spring convert json into Greeting object. Then we save it which it returns a primary key identifier from web service and httpstatus code use create status code 201.  	
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
<details>
	<summary> Update </summary>
	
* To update we need to modify save helper method. Check if primary key is going to be saved has already primary key assigned. If it does we try to update it rather than create new one. 
* So if exist we update it like below
```java
//// inside save function
    if(greeting.getId() != null)
        {
        	Greeting oldGreeting = greetingMap.get(greeting.getId());
           if(oldGreeting == null)
           {
        	   return null;
           }
           greetingMap.remove(greeting.getId());
           greetingMap.put(greeting.getId(), greeting);
           return greeting;
        }
////	
```
* Then you need to define an update function 
```java
    @RequestMapping( 
    		value = "/api/greetings/{id}",
    		method = RequestMethod.PUT,
    		produces = MediaType.APPLICATION_JSON_VALUE,
    		consumes = MediaType.APPLICATION_JSON_VALUE
    		)
    public ResponseEntity<Greeting> upfateGreeting(@RequestBody Greeting greeting){
    	Greeting updateGreeting = save(greeting);
    	if(updateGreeting == null) {
    	   return new ResponseEntity<Greeting>(HttpStatus.INTERNAL_SERVER_ERROR);
    	   }
    	 
    	  return new ResponseEntity<Greeting>(updateGreeting, HttpStatus.OK);
    }
```
Then inside the postman you need to hit with `put` action including with this url `/api/greetings/1`
```java
{"id": 1, "text": "not vsssssg "}
```
</details>

<details>
	<summary> Delete </summary>

* We create a helper method first then in future it would be replaced by repository. First has to find it if not find return false else 
return true
```java
private static boolean delete(BigInteger id) {
    	   Greeting deletedGreeting = greetingMap.remove(id);
    	   if(deletedGreeting == null)
    	   {
    		   return false;
    	   }
    	return true;
    }
```
* Now create a mthod name deleteGreeting and annotate it with @RequestMapping
```java
  @RequestMapping(
    		value="/api/greeting/{id}",
    		method = RequestMethod.DELETE,
    		produces = MediaType.APPLICATION_JSON_VALUE,
    		consumes = MediaType.APPLICATION_JSON_VALUE
    		
    		)
    public ResponseEntity<Greeting> deleteGreeting(
    		@PathVariable("id") BigInteger id, 
    		@RequestBody Greeting greeting){
    	 boolean deleted = delete(id);
    	 if(!deleted)
    	 {
    		 return new ResponseEntity<Greeting>(
    		 HttpStatus.INTERNAL_SERVER_ERROR		 
    				 );
    	 }	 
    		 return new ResponseEntity<Greeting>(
    				 HttpStatus.NO_CONTENT 
    				 );			 
    	 
    }
```
Then you can send to `http://localhost:8080/api/greeting/1` address with this attributes and delete action
```java
{"id": 1, "text": "Hello World!"}
```
* So far you can find the code [here](https://github.com/anabaei/DialecticalMap.v1/tree/controller1)
</details>

<details>
	<summary> Web Service Layer </summary>
	
* So far controllers has annotated by `@RequestMampping` to create each method a RESTfull endpoint. At top of controller class we had fre temporary methods like save to serve us a placeholder until we integrate with spring data repository. 
* Create a package ending with `ws.service`. Within this package create new interface name `GreetingService`. In this interface we define public bussiness service which we want to expose to client of the service. 
* So we define mehtods to update, find, create and delete Greeting entities would be like this 
```java
public interface GreetingService {
	Collection<Greeting> findAll();
	Greeting findOne(Long id);
	Greeting create(Greeting greeting);
	Greeting update(Greeting greeting);
    void delete(Long id);
}
```
* Now in the same package creaet a class to implement this interface call it(when you create a class in eclipse click on `add` to have interface in your class.
* Then annotate class wiht `@Service` when application starts it automatically manages classes with `@service` annotation.
* Then copy paste all helper methods from controller to service with attributes then wire service into controller. Change delete method name to remove because we define a publice delete on greeting service!
```java
// in controller add interface as 
@Autowired
	private GreetingService greetingService;
```
*Then all the services are available, like
```java
//old 
greetingMap.values();
greetingMap.get(id);
save(greeting);
// new
greetingService.findAll();
greetingService.findOne(id);
greetingService.create(greeting);
greetingService.delete(id);
```
</details> 	
<details> 
	<summary> Construct Data JPA Repository </summary>
	
* First add JPA dependency to dependencies and mysql as well(if you wanted sql go with `hsql`
```java
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<scope>runtime</scope>
</dependency>
```
and hesql is like 
```java
<dependency>
	<groupId>org.hsqldb</groupId>
	<artifactId>hsqldb</artifactId>
	<scope>runtime</scope>
</dependency>
```
* Next open a Model class and add annotation `@Entity` to tell JPA this class is persistance JPA entity class.
* Add these two to id as `@Id` shows the id is a primary key and `@GeneratedValue` shows the value is created by database
* Then create `spring-data-repository`. So create a package ending with `repository`. Then create an interface which is extended of `jpaRepository-org.springframework...`. This is a generic interface and it requires the types of entity class and primary key identifier of that class in this case it would be like
```java
@Repository
public interface GreetingRepository extends JpaRepository<Greeting, Long> {
}
```
* Next go to service bean class and remove temporary classes we used for before.
* Then instead wire the `GreetingRepository` into greetingservicebean. 
```java
 @Autowired
    private GreetingRepository greetingRepository;
```
Now manage each of the greetingMap to greetingRepository
```java
///old 
greetingMap.values();
greetingMap.get(id);
save(greeting);
remove(id);
/// new
greetingRepository.findAll();
greetingRepository.findOne(id);

```
For saving first check if the greeting exist so return null 
```java
if(greeting.getId() != null)
		{
			return null;
		}
```
* For update same if exist return null
### Database 
*  When Maven packages the application all the files in `src/main/resources` directory would be replaced at root directory of application class path 
* Now in `src/main/resources/data/hsqldb` create shcema.sql as 
```sql
DROP TABLE Greeting IF EXISTS;
CREATE TABLE Greeting(
 id BIGINT GENERATED BY DEFAULT AS IDENTITY (
  START WITH 1, INCREMENT BY 1) NOT NULL, text VARCHAR(100) NOT NULL,
  PRIMARY KEY(id)
);
```
Then create file name `data.sql` in same directory to initalize database
```sql
INSERT INTO Greeting (text) values ('hello world');
INSERT INTO Greeting (text) values ('hello Mona');
```
Spring looking for configuaration file as `application.properties` we can have it inside a `resources/config` folder as 
```java

```

</details> 















