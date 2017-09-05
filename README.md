# Training JEE
This repository holds the different contents for each step through the training program.


## Environment
Before you start, you need to:
 * Download & install The latest JDK
 * Download & install The latest Eclipse IDE
 * Download & extract The latest MySQL JDBC Connector
 * Download & extract The latest Wildfly Application Server

A MySQL server is also required.
If you have heard about Docker, we recommend that you install it on your machine, and deploy a testing MySQL server by running the following command:  
```sh
docker run --name training-jee -e MYSQL_ROOT_PASSWORD=toor -e MYSQL_DATABASE=training -d -p "3306:3306" mysql
```
The server will then be accessible under:  
user: root  
pass: toor  
address: localhost:3306  
database: training  

### IDE Setup
TODO

### Application Server Setup
TODO: show how to setup Wildfly within the IDE, add an admin for management, send the driver and create a datasource.


## Content

### Step 1: Hello World

### Step 2: Servlet

### Step 3: JSP

### Step 4: Servlet + JSP

### Step 5: First Login

### Step 6: First Database



