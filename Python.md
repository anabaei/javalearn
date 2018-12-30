#### Python

<details>
      <summary> Install </summary>

* Use this [link](https://www.slothparadise.com/how-to-install-django-on-mac/)
```java
brew install python3
```
* If error happen
```java
sudo chown -R $(whoami) $(brew --prefix)/*
sudo install -d -o $(whoami) -g admin /usr/local/Frameworks
```

```java
python3
sudo easy_install pip
sudo pip install virtualenv
virtualenv thanos
```
* Then track to it
```java
cd thanos
sudo pip install Django
```
* If error happen
```java
curl https://bootstrap.pypa.io/get-pip.py | python
pip install --upgrade setuptools
```
* Create Project Blog use [this](https://www.youtube.com/watch?v=pjkZCQTfneQ) 
```java
django-admin.py startproject blog
cd blog 
python manage.py runserver
```
Then check the port 8000 as `http://127.0.0.1:8000`

</details>

<details>
      <summary> Create a file </summary>
      
```python      
import os
def create_project_dir(directory):
    if not os.path.exists(directory):
       print('Creating Project'+ directory)
       os.makedirs(directory)
       
create_project_dir('thenewboston2')       
```
</details>

<details>
      <summary> HTML Parser </summary>
     
* Html parser allows to read pages as here 
* Remember it is python 3
```python
from html.parser import HTMLParser
from urllib import parse 
class LinkFinder(HTMLParser):

    def __init__(self):
         super().__init__() 
 
    def error(self, message):
        pass
   

    def handle_starttag(self, tag, attrs):
        print(tag)


finder = LinkFinder()
finder.feed(
    '<html><head> aaaaa </head><body>bbbb <h1>hhh 111</h1></body></html>'
)
```
</details>      
<details>
      <summary> Address which page to Crawl </summary>
      
* Queue keeps all hyper links inside page 
```python
def create_data_files(project_name, base_url):
    queue = project_name + '/queue.txt'
    crawled = project_name + '/crawled.txt'
    if not os.path.isfile(queue): 
           write_file(queue, base_url)
    if not os.path.isfile(crawled): 
           write_file(crawled, '')

## Create a new file
def write_file(path, data):
    f = open(path, 'w')
    f.write(data)
    f.close()
 
Then to call it we have 
create_data_files(
  'thenewboston', 'https://eli17.herokuapp.com/'     
)
```
</details>

<details>
      <summary> Memorius </summary>
      
* A [link](https://github.com/alephdata/memorious)
* Changed settings.py at as 
```python
# Datastore: operational data store (ODS) database connection
#DATASTORE_FILE = os.path.join(BASE_PATH, 'datastore.sqlite3')

# DATASTORE_URI = env('DATASTORE_URI', 'sqlite:///%s' % DATASTORE_FILE)
DATASTORE_URI = env('DATASTORE_URI', 'mysql://root:password@localhost:3006/aml')
OR 
#DATASTORE_FILE = os.path.join(BASE_PATH, 'datastore.mysql')
DATASTORE_URI = env('DATASTORE_URI', 'mysql+mysqldb://root:password@localhost:3006/aml')

```
* Run memorious as 
```java
memorious run eu_mepspwd
```
</details>

<details>
      <summary> Versions </summary>
      
  * To find a file in command line
  ```java
  sudo find . -name "SQLALCHEMY_DATABASE_URI"
  ```
  * Change version got to ~/.bash_profile and edit it as 
  ```java
    alias python='python2'
  ```
  </details>  
  
  <details>
      <summary> Run Sanction </summary>
   
```java   
  python setup.py --help-commands
  python setup.py build
  
```  
   </details>  
  
  * [SQLAlchemy](https://github.com/zzzeek/sqlalchemy)
  * [MySQL DBAPI](https://docs.sqlalchemy.org/en/latest/dialects/mysql.html#module-sqlalchemy.dialects.mysql.mysqldb)
  * [build crawler](https://memorious.readthedocs.io/en/latest/buildingcrawler.html)
