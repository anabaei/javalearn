
### OOP vs Procedural 
* A class is defined as a template/blueprint that describes the behavior/state that the object of its type support.
* An object is an instance of a class
* An interface is a blueprint of a class and is a mechanism to achieve abstraction and not be able to be instantiated like abstract class. Methods of an interface are abstract by default so we never can use static word in abstract method. Variable are implicitly in interface are public. 
* Static keyword is used for memory management and it belongs to a class and not instance. Static variables can refer to a common property of all objects to save memory and is 
[difference between heap and stack](https://www.journaldev.com/4098/java-heap-space-vs-stack-memory)
 * Stack : When a function is called, a block is reserved on the top of the stack for local variables and some bookkeeping data and stack is LIFO order [stack](https://stackoverflow.com/questions/79923/what-and-where-are-the-stack-and-heap)
 * Static Methods are stored in Permanent Generation space of heap as they are associated to the class and not to the object of that class. ( so they save in heap but not on the object area) 

* procedural uses a list of instrcuctions to tell computer what to do. it uses procedures which contains a series of computation steps to be carried out.
procedural programming also called `imperative` programming or top-down language. It is intutitive since it works as we expect how a computer should work.
Most of first languages are procedural like Cobol RPG II C Fortran. Procedural language expose data to external entities  
* OOP is made of a number of entities referred to as objects. Program is divided into objects and data is hidden from extenal entities and focus
is all about building blocks and objects. 
### Static vs Singleton Classes 
* A `static` class is one that has only static methods, for which a better word would be "functions". The design style embodied in a static class is purely procedural. 
* `Singleton` on the other hand, is a pattern specific to OO design. It is an instance of an object (with all the possibilities inherent in that, such as polymorphism), with a creation procedure that ensures that there is only ever one instance of that particular role over its entire lifetime (garbage collector)
* Heap memory has garbage collectors 

### Multi Threads
* To have more than one thread when executing a main mehtod in Java, create an object of a class which extends thread class using run method. Therefore inside main method a new object on a nother class call run method for another class which is second thread as [here](https://www.javaworld.com/article/2074217/java-concurrency/java-101--understanding-java-threads--part-1--introducing-threads-and-runnables.html)
* Instances created in heap memory are available via other threads but static methods can not be accessible by other threads. Thus we say Heap memory is `thread safe`.
* Thread Safe means a method or class instance can be used by multiple threads at the same time without any problems occuring
* Making a thread safe mehtod is adding the word `synchronized`, this means that only one thread can execute that method at a given time. The other threads wait in line. This makes a method thread safe, but if there is a lot of work to be done in a method, then this wastes a lot of time. 
* Another technique is to `mark` only a small part of a method as synchronized by creating a `lock` or `semaphore`, and locking this small part (usually called the critical section)
* There are even some methods that are implemented as lockless thread safe, which means that they are built in such a way that multiple threads can race through them at the same time without ever causing problems, this can be the case when a method only executes one `atomic` call. Atomic calls are calls that can't be interrupted and can only be done by one thread at a time
* `race condition` in order to have a race between two threads, there must be shared state between those two threads and interaction (reading and writing) to that state must occur outside of a mutualy exclusive block (aka syncronized) [this](https://stackoverflow.com/questions/25156724/code-to-simulate-race-condition-in-java-thread)

### Design Pattern
##### 4 authors wrote a book with a name of `Design Patterns - Elements of Reusable Object-Oriented Software` which is known as Gang of four (GOF). According to them design is based on two principles
- [ ] Program to an interface not an implementation
- [ ] Favor object composition over inheritance 
##### There are 23 desgin patterns which can be classified into three categories plus one
- [ ] [Creational patterns](https://sourcemaking.com/design_patterns/creational_patterns): trying to create objects in a manner suitable to the situation.
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

* Waterfall model -> Requirements -> Design -> Implementation -> Test -> Maintainance
* V model -> Requirement -> Design -> Implement -> Unit test case executation -> Integration test -> Accetance test 
,Agile model
,Spiral model
,RUP
,RAD
* Test-driven development. TDD is a development technique where you must first write a test that fails before you write new functional code

### Binary Data (String) 
* A binary string is a sequence of octets, or bytes. Binary strings store raw-byte data, while character strings store text.

### [Git](https://github.com/git/git/blob/master/Documentation/RelNotes/2.9.0.txt#L58-L68)
* Git has two states you can be there `on a branch` and `not on a branch`.
If you are `on a branch` then all commits are saved into your branch, but if you are `not on a branch` then new commits are not saved and if you get out of that branch git forgets all those commits
 
```java
git checkout -b newbranc // Create new branch
git push origin newbranch // push it 
// then inside gitpub page you need to pull it out from repository to able to merge it with current master one 
git checkout master // to switch to a master 
git branch -d newbranc // to delete the branch
```
Then you would have this image ![alt text]()

* Switch branches `git checkout anotherbranch`
* Merge br1 into master and delete it `git checkout master, git merge br1, git chekcout -d br1`
* Conflict in merge: git status shows where the conflicts came from `git status` 
```java
# Starting a project

1. Generate app, add .gitignore and commit "Create project"
2. Push it to Github
3. Add all team members as a collaborator
4. Create a "integration" from master and push it up
5. Set "integration" branch as the default
6. Every team member clones the project
7. (optional) Protect the master branch from destructive operations

# Branches

- "master" branch is only for releases. Code that is 100% reader for the public.
- "integration" branch which will be the branch share work between team members.
- feature branches (to be named after feature name) will be created by developer to implement the features they're tasked to do. No dev. should directly work on "integration". features should always be created from the latest commit on "integration"

# Starting a feature

1. `git fetch` (Get latest data from your remotes such as Github)
2. `git checkout -b <feature_name> origin/integration` (Creates and switches to new branch named <feature_name> from the latest version of "integration" from your "origin" remote)
3. Do some work. Do a bunch of commits until your feature is finished.
4. `git push -u origin <feature_name>`
5. Go to Github and do a pull request of your branch to "integration".
6. If merge conflict shown, do:
  1. `git checkout <feature_name>`
  2. `git fetch`
  3. `git merge origin/integration`
  4. Solve conflicts.
  5. `git push origin <feature_name>`
  6. Go back to PR URL.
7. Send PR URL to a team member for review.
8. Team member approves.
9. Click "Squash and Merge" button.
10. Click "Delete" button.
11. (optional) To delete branch locally, `git branch -D <feature_name>`
```
#### Rebasing Git 
 When we have two unrelated branches that have no common 
* `git remote add origin https://github.com/user/repo.git`
* git pull address
* git add filename, git push origin master 
* error `refusing to merge unrelated histories`
* git pull address --allow-unrelated-histories
* git push origin master 

### UML Diagrams 
UML Unified Modeling Language has two main types : 
* Structural UML diagrams like Class diagram, Package diagram, Object diagram
* Behavioral UML diagrams like Activity diagram, Use case diagram, State diagram
[this](https://www.smartdraw.com/uml-diagram/)
two common uses:
###### Activity diagram 
* Activity diagrams illustrate the dynamic nature of a system by modeling the flow of control from action to action. 
###### State diagram
* A diagram from one state to another which connected with an actions, this one is more difficult than activity diagrams

### Interview
* source for cloud [position](http://blog.alto9.com/critical-interview-questions-for-hiring-a-cloud-computing-expert)
### Ethical Developer
* Selflessness: has a great muteability. Humality say I dont know. As yourself it is good for me or team. 
* Ask a person I dont know dont shut down me or harvest me and accept your are wrong. dont criticize them or be mean. 
* Consensus: what activity you do to bring the other team along to reach the technology. Concept of collaboration and encouragement.
* Happy ppl make happy code



