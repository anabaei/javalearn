# Dialectical Maps

## Local Environment Dependencies 
- TBD

## Running the Application (Locally)

- In terminal, navigate to the `client` folder
- With Python installed, run:
```
python -m SimpleHTTPServer 8000
```
- Local application is now served at:
```
http://localhost:8000/
```

## Running the Backend (Locally)
```java
mvn jetty:run
```
* URL : `http://localhost:8080/spring3`

## Running the Database (Locally)

**1. Create Mysql database**
```bash
create database notes_app
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Build and run the app using maven**

```bash
mvn package
java -jar target/easy-notes-1.0.0.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

