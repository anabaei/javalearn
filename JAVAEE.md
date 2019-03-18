

<details>
 <summary> Start Web </summary>

*  `Eclipse` -> `New` -> `Dynamic Web project` -> `ProjectName` -> Check web.xml deployment
* `Web content` is the folder to hold all html/css/js/xml files. META-INF is mehtodology application that Eclipse generate and `WEB-INF` has web information that inside that `lib` contains all `JAR` files to integrate with this app.
* It is safe to create `html` and `css` folders in `webContent` folder 


#### Set up Tomcat in Eclpise IDE
* To host the application inside a server. After downloading tomcat.
* Eclipse -> window -> show view -> servers. Click on the link to create a server, choose tomcat version and brows it to where tomcat installed and then finish. 

#### Set build path
 * This is a java enterprise edition project. We have to integrate `Servelt` and `jsp` specification apis into our project. So we need to download them. Fortunatelly tomcat has all the jar files inside `lib` folder in tomcat folder. So we take all these `jars` through the server. 
 * To do that `right click on project` -> `properties` -> on left `Java Build Path` -> `libraries` -> `Add Library` -> `Server Runtime` becuase we want to add jar files from server -> select server already installed 

#### JDBC driver MySQL
* download mysql jar from [here](https://dev.mysql.com/downloads/connector/j/5.1.html)
* copy and paste `mysql-connection-java-bin.jar` file into `lib` folder. Also need to add it to project path. `project` -> `properties` -> `java Build Path` ->`libraries` -> `Add JARs..` -> travers to lib folder and pick .jar file 
* Now it is ready to call JDBC because dirver jar is connected 
* To run click right project -> `Run as` -> `Run on Server` -> then you see it in configured now it should run


#### WAR Deploy
* WAR (Web Archive) is a package that Tomcat understand. Eclipse automatically create WAR and deploy its instance to server. Only Dev environemtn access to eclpise otherwise. 
* Export project as `war` file from Eclipse or run `mvn package` then put this `war` file inside `tomcat-9.2./webapps` in Tomcat, now when server starts this tomcat automatically runs.
* To run tomcat go to `tomcat->bin-> startup.bat`

* Alternatively you can use `Maven` or `Gradle` to set up project. 
</details>

<details>
 <summary> MVC  </summary>
 
 * Views- can be JSP or HTML files
 * Controllers- servlet classes get requests and prepare response
 * Model- classes that talk to database
</details>

<details>
     <summary> GET  </summary>
 
 * Http is communication protocol between client and server and has different types 
 ```
 Get gets info from server
 Post processes/post info on server
 Put upload/update a resource 
 HEAD same as get but checks only headers
 OPTIONS helps to know what are possible options to run on target server
 ```
 * In `src` -> create a package `anyname` -> create a java class as
 ```java
 package servicetest;
public class GetTest {

}
 ```
 * `cnt`+ `space` `extends HttpServlet`. Why? It starts with `servlet` interface, downthere we have an abstract class with `GenericServlet`. This interface has all the class to implement our application. `GenericServlet` helps to design protocol(protocl-independent-application class). Also it helps to design `HTTPServlet` by htto-based-application class. 
 * [`Abstract class`](https://www.tutorialspoint.com/java/java_abstraction.htm) it cannot be instantiated, to use an abstract class we need to inherit it from another class. 
 * Now write `doget` and `ctr+space` to produce first get. So everytime it is going to written back into page as
 ```java
 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String htmlResponse = "<html><h3> hi </h3></html>";
		PrintWriter writer = resp.getWriter();
		writer.write(htmlResponse);
	}
 ```
 
 </details>
 
## TOMCAT
 
* Inside `apache-tomcat-9.1...` you can find `webapps` folder where 
```java
cp /Back_End/target/dm.war /Users/amirnabaei/apache-tomcat-9.0.14/webapps
cd apache-tomcat-9.0.14/bin
./startup.sh
./shutdown.sh
```

### Hello World Web 
* Follow this [link](https://www.javahelps.com/2015/04/java-web-application-hello-world.html) 
* If error happen to not knowing libraryies you need to import them. In Ecpipse click right on the project then select `properties` -> `Targeted Runtimes` -> `Add Apache version` -> `Select path /Users/amirnabaei/apache-tomcat-9.0.14`


