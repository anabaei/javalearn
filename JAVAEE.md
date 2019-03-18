

<details>
 <summary> Start Web </summary>
	
### Hello World Web 
* Follow this [link](https://www.javahelps.com/2015/04/java-web-application-hello-world.html) 
* If error happen to not knowing libraryies you need to import them. In Ecpipse click right on the project then select `properties` -> `Targeted Runtimes` -> `Add Apache version` -> `Select path /Users/amirnabaei/apache-tomcat-9.0.14`
*  `Eclipse` -> `New` -> `Dynamic Web project` -> `ProjectName` -> Check web.xml deployment
#### Set Mysql

* download mysql jar from [here](https://dev.mysql.com/downloads/connector/j/5.1.html)
* copy and paste `mysql-connection-java-bin.jar` file into `lib` folder
* Right click on your `project` and `java Build Path` -> `module path` -> `Add Library` Select JRE System Library click Next Then select JRE from options as per your requirement. Click Finish

* `Web content` is the folder to hold all html/css/js/xml files. META-INF is mehtodology application that Eclipse generate and `WEB-INF` has web information that inside that `lib` contains all `JAR` files to integrate with this app.
* It is safe to create `html` and `css` folders in `webContent` folder 

#### WAR info and setup info
* WAR (Web Archive) is a package that Tomcat understand. Eclipse automatically create WAR and deploy its instance to server. Only Dev environemtn access to eclpise otherwise. 
* Export project as `war` file from Eclipse or run `mvn package` then put this `war` file inside `tomcat-9.2./webapps` in Tomcat, now when server starts this tomcat automatically runs.
* To run tomcat go to `tomcat->bin-> startup.bat`
* from window -> console server -> click on the link to `select tomcat version` -> `select its path` 
* At src -> crate package -> create class // should not produce error otherwise the importing JRE has not complteted
* To run click right project -> `Run as` -> `Run on Server` -> then you see it in configured now it should run

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




