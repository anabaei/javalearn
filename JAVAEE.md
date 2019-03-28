

<details>
 <summary> Start Web </summary>
	
### Hello World Web 
* JAR [resource](https://jar-download.com/artifacts/com.google.code.gson/gson)
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
 // This is depricated 
 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String htmlResponse = "<html><h3> hi </h3></html>";
		PrintWriter writer = resp.getWriter();
		writer.write(htmlResponse);
	}
// it is prefered controller dispatch views 
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	        RequestDispatcher view = request.getRequestDispatcher("html/welcome.html"); // it can be json as well 
    	        view.forward(request, response);
    }
 ```
 * `PrintWriter` is an `api` to help you write into api
 * 
 
 </details>
 <details>
     <summary> Config Servlet web.xml  </summary>

*  In order to simply add `web.xml` you need to add below to file as 
```java
<servlet>
     <servlet-name>GetServlet</servlet-name>
     <servlet-class>testService4.PassJson</servlet-class>
  </servlet>
  <servlet-mapping>
     <servlet-name>GetServlet</servlet-name>
     <url-pattern>/test</url-pattern>
  </servlet-mapping>
```
* Above package just define one `route` to a `controller class`. To have another address you need to have same package below it
* Remember: `servlet-class` is the address of `package.funcionName` and in `servlet-mapping` at url address the url you want. 
* Also we can assign configuration via annotaions. On top of a class add
```java
@WebServlet("/getServlet")
public class PassJson extends HttpServlet{
```
</details>
 <details>
     <summary> pass and get params </summary>

* To read a params with name `name` just need `req.getParameter("name");` 
* so at a url like `http://localhost:8080/testService4/test?name=amir` and a class like
```java
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	  String value = req.getParameter("name");
	  String htmlResponse = "<html><h3> hi </h3></html>";
	   	PrintWriter writer = resp.getWriter();
	   	writer.write(htmlResponse+ " "+ value);
}
```
 </details>
 
 <details>
	<summary> JSON </summary>
 
 * Google resource is [here](https://google.github.io/gson/apidocs/index.html?com/google/gson/stream/JsonWriter.html)
 
</details>
 <details>
	<summary> Multithreading </summary>
	

* `process` is running an application or program, it has self contained execution environemnt and needs space and memory. It starts with a single thread and can produce many threads. Every process has unique process id. Adding new process is expensive because you want to add all self-container executions environments again. Switch between processes has be inter process communication which can cause overhead. 
* `thread` is a lightweight process an entity and a part of process exeuction environment so when you create new thread it requires less resources and we call it `multithreading`. 
* Every thread has id, exception handlers, priority, registers, uses stacks to save local vars and set of structurs to save state of the thread until it is picked up for execution 
* `Scheduling` is order of threads executing in application. In java `JVM` dont have any algorithm to schedule threads and it relies to OS to do that. Just `JVM` has priority deterministic it means if any thread has `priority` it runs first other than that it picks randomly. During executing if a thread comes with priority then jvm suspends the rest and run new one. Also `JVM` has `time slicing` for each thread if executing elapsed, JVM save it into thread and go over next one until all threads run it back and resume.
* You can assign `priority` to threads but it is not guarantee since JVM when running time slicing it can skip a high prior thread and move to low prior one in order to avoid starvation
* Java Standard Edition has basic and high level apis. basic apis have thread and runnable from package java.langpackage and high level api have executor framework from java.util.concurrent package.

#### Thread class
* Create a class that extends `Threat`. 
* is in java.lang package, need to create an instance of this class to run an asynchronous task. This class has a run mthod that defines the job of the thread spawned. 

#### more
* `concurrency` machine execute multiple tasks
* `parallelism` running tasks exactly at the same time
* `Synchronous` means only one task can execute at a time , after the completion of that task the other task will execute, it blocks the tasks to only one at a time. `Asynchronous` means more than one tasks can execute simultaneously, it unblock the tasks to execute simultaneously. OR an easy way `Asynchronous` tasks are the ones that can run in the background while users are doing something else 
</details>
<details>
	<summary> Memory Leak </summary>
</details>
<details>
	<summary> Testing jUnit </summary>
</details>
## TOMCAT
 
* Inside `apache-tomcat-9.1...` you can find `webapps` folder where 
```java
cp /Back_End/target/dm.war /Users/amirnabaei/apache-tomcat-9.0.14/webapps
cd apache-tomcat-9.0.14/bin
./startup.sh
./shutdown.sh
```




