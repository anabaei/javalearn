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
* Create Project Blog
```java
django-admin.py startproject blog
cd blog 
python manage.py runserver
```
Then check the port 8000 as `http://127.0.0.1:8000`

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
  
