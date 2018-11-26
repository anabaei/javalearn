# Dialectical Maps

## Local Environment Dependencies 
1. Java - 1.8.x

2. Maven - 3.x.x

3. Mysql - 5.x.x

## Running the Client (Locally)

- In terminal, navigate to the `client` folder
- With Python installed, run:
```
python -m SimpleHTTPServer 8000
```
- Local application is now served at:
```
http://localhost:8000/
```

## Bringing up the Backend (Locally)
 - ```cd Back_End```
 - ```sudo mysql``` to bring up the mysql interactive prompt
 - ```create database notes_app;``` to create the local database
 - ```exit``` to leave the mysql interactive prompt
 - ```mysql.server start``` to bring up the local database
 - ```mvn spring-boot:run``` to bring up the backend without packaging
 - ```mvn package; java -jar target/easy-notes-1.0.0.jar``` to package and run
 - The app will start running at <http://localhost:8080>

