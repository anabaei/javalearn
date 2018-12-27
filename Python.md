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
