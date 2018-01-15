
### OOP vs Procedural 
* A class is defined as a template/blueprint that describes the behavior/state that the object of its type support.
* An object is an instance of a class
* An interface is a blueprint of a class and is a mechanism to achieve abstraction and not be able to be instantiated like abstract class. Methods of an interface are abstract by default so we never can use static word in abstract method. Variable are implicitly in interface are public. 
* Static keyword is used for memory management and it belongs to a class and not instance. Static variables can refer to a common property of all objects to save memory and is 
[difference between heap and stack](https://www.journaldev.com/4098/java-heap-space-vs-stack-memory)


* procedural uses a list of instrcuctions to tell computer what to do. it uses procedures which contains a series of computation steps to be carried out.
procedural programming also called `imperative` programming or top-down language. It is intutitive since it works as we expect how a computer should work.
Most of first languages are procedural like Cobol RPG II C Fortran. Procedural language expose data to external entities  
* OOP is made of a number of entities referred to as objects. Program is divided into objects and data is hidden from extenal entities and focus
is all about building blocks and objects. 

### Design Pattern
##### 4 authors wrote a book with a name of `Design Patterns - Elements of Reusable Object-Oriented Software` which is known as Gang of four (GOF). According to them design is based on two principles
- [ ] Program to an interface not an implementation
- [ ] Favor object composition over inheritance 
##### There are 23 desgin patterns which can be classified into three categories plus one
- [ ] Creational patterns: it provides a way to create objects while hiding the creation login rather than instantiation objects directly using new operator by using common interface.
- [ ] Structural pattern: Conecpt of inheritance is used to compose interfaces 
- [ ] Behavioral pattern: It design based on communication among objects
- [ ] J2EE pattern: It specifies concerned with the presentation tier.
[source](https://www.tutorialspoint.com/design_pattern/design_pattern_overview.htm)
#### Factory pattern Design
* Is common most used design under creational pattern. 
* You suppose to draw a java based design on the fly based on below image [link](https://www.tutorialspoint.com/design_pattern/factory_pattern.htm)
![image](https://user-images.githubusercontent.com/7471619/34269117-096006c4-e638-11e7-83a7-4b71cdb0d3c5.jpg)
* Also to make it independent than a class type, we define an Abstract class in middle to make it abstract calling the getshape method which is another type of design `Abstract factory pattern`

### Reverse Proxy
* Is a proxy server that apprears to be an ordinary server. They forward requests to one or more ordinary servers which handle requests.There are several benefitial to installing reverse proxy server
- 1 Encryption/SSL acceleration: SSL usually is done not by server itself but by a reverse proxy server. 
- 2 Load Balancing: A reverse proxy act as a traffic coop and distribute alient requests acroos a group of servers to maximize speed and liablity to distribute the load to several web servers
- 3 Serve/cache static content:  A reverse proxy can offload the web servers by caching static content like pictures and other static graphical content.
- 4 Spoon feeding: reduces resource usage caused by slow clients on the web servers by caching the content the web server sent and slowly "spoon feeding" it to the client. This especially benefits dynamically generated pages.
- 5 Security: the proxy server is an additional layer of defence and can protect against some OS and Web Server specific attacks. However, it does not provide any protection from attacks against the web application or service itself
As an example [NGINX](https://www.nginx.com/resources/glossary/reverse-proxy-server/) can be used.
#### [REST](https://www.sitepoint.com/developers-rest-api/)
### Software Developer Testing Methodologies
* In today’s Software Testing Class, we will see what all Software Testing Methodologies & software testing technique is used in the day today software testing life cycle [link2](https://www.inflectra.com/ideas/topic/testing-methodologies.aspx)
Here are the few commonly used Software Development Life Cycle used in actual testing:

Waterfall model -> Requirements -> Design -> Implementation -> Test -> Maintainance
V model -> Requirement -> Design -> Implement -> Unit test case executation -> Integration test -> Accetance test 
,Agile model
,Spiral model
,RUP
,RAD
* Test-driven development. TDD is a development technique where you must first write a test that fails before you write new functional code

### Binary Data (String) 
* A binary string is a sequence of octets, or bytes. Binary strings store raw-byte data, while character strings store text.

### Git
* Git has two states you can be there `on a branch` and `not on a branch`.
If you are `on a branch` then all commits are saved into your branch, but if you are `not on a branch` then new commits are not saved and if you get out of that branch git forgets all those commits


