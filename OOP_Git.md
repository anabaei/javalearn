
* [Algorithm and data structure](https://github.com/trekhleb/javascript-algorithms)

### OAuth2
* OAuth is a protocol to design to solve the application-to-application security problem.
* [Resource](https://www.wikitechy.com/tutorials/oauth/oauth-1-dot-0-vs-oauth-2-dot-0)

#### JWT
* JWT (Learn JSON Web Tokens) is just a token format, it defines a compact and self-contained mechanism for transmitting data between parties in a way that can be verified and trusted because it is digitally signed. Additionally, the encoding rules of a JWT also make these tokens very easy to use within the context of HTTP

### OOP vs Procedural 
* A class is defined as a template/blueprint that describes the behavior/state that the object of its type support.
* An object is an instance of a class
* An interface is a template/blueprint of a class and is a mechanism to achieve abstraction and not be able to be instantiated like abstract class. Methods of an interface are abstract by default so we never can use static word in abstract method. Variable are implicitly in interface are public. 
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
* A `static` class is one that has only static methods, for which a better word would be "functions". The design style embodied in a static class is purely procedural
* Static class when we do not need to create an instance of the class then we will use static class. Static classes are sealed and therefore cannot be inherited. Outer classes cannot be static, but nested/inner classes can be and can use objects of outer class as params 
* Static methods can be in non static class but not opposite. Static mehtods in java belong to the class (not an instance of it). They use no instance variables and will usually take input from the parameters 
* `Singleton` on the other hand, is a pattern specific to OO design. It is an instance of an object (with all the possibilities inherent in that, such as polymorphism), with a creation procedure that ensures that there is only ever one instance of that particular role over its entire lifetime (garbage collector)
* Heap memory has garbage collectors 

### Multi Threads
* To have more than one thread when executing a main mehtod in Java, create an object of a class which extends thread class using run method. Therefore inside main method a new object on a nother class call run method for another class which is second thread as [here](https://www.javaworld.com/article/2074217/java-concurrency/java-101--understanding-java-threads--part-1--introducing-threads-and-runnables.html)
* Instances created in heap memory are available via other threads from non static methods Thus we say Heap memory is `thread safe`. dont forget static methods and static variables can not be accessible by other threads only objects can access to eah other threads. Inside `heap memory` there is one seperated area for statics and one for non static instances.
* Thread Safe means a method or class instance can be used by multiple threads at the same time without any problems occuring
* Making a thread safe mehtod is adding the word `synchronized`, this means that only one thread can execute that method at a given time. The other threads wait in line. This makes a method thread safe, but if there is a lot of work to be done in a method, then this wastes a lot of time. 
* Another technique is to `mark` only a small part of a method as synchronized by creating a `lock` or `semaphore`, and locking this small part (usually called the critical section)
* There are even some methods that are implemented as lockless thread safe, which means that they are built in such a way that multiple threads can race through them at the same time without ever causing problems, this can be the case when a method only executes one `atomic` call. Atomic calls are calls that can't be interrupted and can only be done by one thread at a time
* `race condition` in order to have a race between two threads, there must be shared state between those two threads and interaction (reading and writing) to that state must occur outside of a mutualy exclusive block (aka syncronized) [this](https://stackoverflow.com/questions/25156724/code-to-simulate-race-condition-in-java-thread)


## Interaction/Interview

### Reverse Proxy
* Is a proxy server that apprears to be an ordinary server. They forward requests to one or more ordinary servers which handle requests.There are several benefitial to installing reverse proxy server
- 1 Encryption/SSL acceleration: SSL usually is done not by server itself but by a reverse proxy server. 
- 2 Load Balancing: A reverse proxy act as a traffic coop and distribute alient requests across a group of servers to maximize speed and liablity to distribute the load to several web servers
- 3 Serve/cache static content:  A reverse proxy can offload the web servers by caching static content like pictures and other static graphical content.
- 4 Spoon feeding: reduces resource usage caused by slow clients on the web servers by caching the content the web server sent and slowly "spoon feeding" it to the client. This especially benefits dynamically generated pages.
- 5 Security: the proxy server is an additional layer of defence and can protect against some OS and Web Server specific attacks. However, it does not provide any protection from attacks against the web application or service itself
As an example [NGINX](https://www.nginx.com/resources/glossary/reverse-proxy-server/) can be used.

![ss](https://user-images.githubusercontent.com/7471619/58122185-e5720100-7bbd-11e9-8d1d-3f2fd4b0bc4d.jpg)
#### Porcess
* A process is the instance of a computer program that is being executed by one or many threads
#### Thread
* A thread is the smallest unit of processing that can be performed in an OS. Thread exists within a process - that is, a single process may contain multiple threads.
#### [REST](https://www.sitepoint.com/developers-rest-api/)
* Interview: what is REST? a software architicte style for web services. Alternatives are Soap (has more bandwith and only can use xml) and Graphql. Web services using this archicte call RESTFULL web services or RESTFULL APIs. REST use http explicitly. 
* What is http? hyper text transfer protocol is protocol used by the World Wide Web and this protocol defines how messages are formatted and transmitted
* What is Https? is the http connection that sends encrypted data toward the network

* What is curl? Curl is a tool to transfer data from or to a server, using one of the supported protocols (HTTP, HTTPS, FTP, FTPS, SCP, SFTP, TFTP, DICT, TELNET, LDAP or FILE)

* Difference TCP and UDP: both are protocols using bits to send data over ip. TCP make sure the data is transfered was recevied if not it resend it again but UDP not making sure about receiving data and is used for streaming videos [good explanation](https://support.holmsecurity.com/hc/en-us/articles/212963869-What-is-the-difference-between-TCP-and-UDP-)
* Layer of tcp/ip? TCP is the layer to assign port numbers in order to assign application to correct destination application, and IP is the layer to assign ip address of destination to connect to correct computer more [info](https://web.stanford.edu/class/msande91si/www-spr04/readings/week1/InternetWhitepaper.htm)
* What is OAuth: OAuth doesn't share password data but instead uses tokens to prove an identity between consumers and service providers.

* what is udp/ssl? Auth2? JWT? [here](https://github.com/anabaei/Blockchain/blob/master/SSL-TLS.md)
* two ordered arrays make one ordered array.
* have a string of `1234` make it an interger use Ascii code
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

## Cross Site 
### CSRF
* Cros site Request Forgery ![csrt](https://user-images.githubusercontent.com/7471619/58136295-70fd8900-7be2-11e9-99c5-8bf6048769c7.png)

### XSS
* 5 common scenarios for [xss](https://pentest-tools.com/blog/xss-attacks-practical-scenarios/)
* Cross site scripting ![xss](https://user-images.githubusercontent.com/7471619/58136376-ad30e980-7be2-11e9-866b-8e9b862d1318.png)

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

* Why this command is used?
```javascript
git rebase -i HEAD~10  // to list past 10 commits and modify them with either the squash or fixup command 
```
* What option you can use to apply git configuration accross entire git env
```javascript
git config --global user.name "John Born"
```
* 
```javascript
git add -A // what does it do 
git commit -a -m "name" // adds all modified files to staging area 
```
* To modify your previous commit 
```javascript
--amend 
```

* Git has two states you can be there `on a branch` and `not on a branch`.
If you are `on a branch` then all commits are saved into your branch, but if you are `not on a branch` then new commits are not saved and if you get out of that branch git forgets all those commits
* Best practice is to create branch from master and git add commit push to the branch, then keep working on it. 

```java
git checkout -b newbranc // Create new branch
git push origin newbranch // push it 
// then inside gitpub page you need to pull it out from repository to able to merge it with current master one 
git checkout master // to switch to a master 
git branch -d newbranc // to delete the branch
```
* Alternatively you can use merge the branch into master then push the origin master it gives same results and also from github no boby needs to approve the merge later
```javascript
git checkout newbranch
git rebase master
```
Then you would have this image ![alt text](https://user-images.githubusercontent.com/7471619/40859394-7db1fd88-6596-11e8-8112-bfa7b98be88c.png)
### Rebase
* Inorder to sync your local branch with repository you need to use `git rebase`
* To sync any branch with others we can use `git rebase otherbaranch` . Merge and Rebase have no real differences the only one is that rebase makes for a cleaner history
### Revert
* If you already commited your changes you can revert them by using 
```java
git revert commit_hash_id
```
To get which commit need to run
```java
git log
```
* If you dont want to commid your changes but save them, use 
```java
git stash 
```
Then if you come back to your branch you still can work on them 
### Status
```java
git status
```
return the status of uncommited changes to repo


#### Branches
* Generally you have your branch and use it to push to origin yourbranch name. you can delete your branch and then create a new one with the same name and push and it works. 
```
git checkout branchname
```
* By using above you have different types of your projects in different branches. So any change to one branch does not affect other branches unless you push them and pull request changes on the other branch
* For example if you change amir branch and push to git your master branch in computer and git repository still unchanged

* On git repository if you want to clone a branch and work on it 
```java
git fetch && git checkout branchName
```
* List of all branches 
```java
git branch     // branches locally
git branch -r // branches on the repository
```
* To merge from branch B into A 
```
Git checkout A
git merge B   // it merges everything from B into A(current branch)
```
* If conflict occured then it listed then it shows you the current difference by `<<<<<` and below displays changes on branch B by `>>>>>>` select one and remove other then gir add and commit. Now the branch is merged 
* To undo a push use `git revert 9F83728` 
* To undo a merge use `git reset --hard HEAD~1` it falls back one push
* To undo a merge that is already pushed `git revert -m 1 commit_hash`
* If there is a branch in repository and the same in local and you want to push the local tells you need to pull and even if you pull still has issue, you need to use `git pull --rebase ` because there is parallel work that you need to update your branch first 
* If you did not commit anything, but your working space is not clean, just `git stash`
* To see what refs do you have
```java
git show-ref
```
#### More than one repo
* we can have different origins like for one github another bitocin just need to add them as
```java
git add remote myorigin1 https://bitbucket.com/anabaei/javalearn/edit/master/OOP.md
git remote -v // it list the default origin and the one we added 
```
* To push each one just we call as
```java
git push myorigin1 master // to bitbucket  
git push origin master    // to github
```
```java
git stash 
git status 

```
#### Git pull branch
```javascript
git pull origin branch_name
```

#### Add long comment
* To have comment message 
```java
git commit --amend
```

----------------------- 

* Switch branches `git checkout anotherbranch`
* Merge br1 into master and delete it `git checkout master, git merge br1, git chekcout -d br1`
* Conflict in merge: git status shows where the conflicts came from `git status` 
* To check gitignore we have `git status --ignored`
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
#### Rebase and Merge
* Merge and Rebase from [here](https://www.atlassian.com/git/tutorials/merging-vs-rebasing) and [good one](https://git-scm.com/book/en/v2/Git-Branching-Rebasing)
```java
git checkout feature
git rebase master
```
* In order to pull a branch into your repository use 
```java
git pull --rebase origin version4
```
* When your changes dont deserve be in the branch you can add them to your master and then push 

* Rebase like above move the latest changes into a branch and keep it as the base, so any changes in feetures would write on top of it. Rebase write  from a better [example](https://hackernoon.com/git-merge-vs-rebase-whats-the-diff-76413c117333)
#### Rebasing Git 
 When we have two unrelated branches that have no common 
* `git remote add origin https://github.com/user/repo.git`
* git pull address
* git add filename, git push origin master 
* error `refusing to merge unrelated histories`
* git pull address --allow-unrelated-histories
* git push origin master 

<details>
  <summary> Git pull Branch </summary>
  
 * In order to git pull from branch `backend-restructure` we can have
 ```java
 git branch -f backend-restructure  origin/backend-restructure
 ```
 * Then it creates same branch as from origin in
  </details>

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
* Common [git](https://medium.com/@i_AnkurBiswas/common-git-mistakes-and-how-to-fix-them-10184cd5fa77) mistakes 


