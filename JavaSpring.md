## Maven
* Maven is a tool to build and manage any java project. It is a software management and comprehension tool based on Project Object Model. It allows to to publish project information and share JARs accroos several projects. The result is a tool that can be used for building any java-based-project
* POM (Project Object Model) is an XML file that contains information about project and configuration details use by Maven to build project
#### Install Maven
* Make sure JDK is installed in your system. Make sure JAVA_HOME variable is set to the path that JDK folder exist(Windows)
```java
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

<details>
  <summary> MySQL </summary>
  
 * If you forgot mysql password when running 
 ```java
 mysql -u root -p
 ```
 * Then you need to remove mysql and dowload it again as [here](https://coderwall.com/p/os6woq/uninstall-all-those-broken-versions-of-mysql-and-re-install-it-with-brew-on-mac-mavericks)
 
  </details>
