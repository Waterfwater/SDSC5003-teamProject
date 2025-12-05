# SDSC5003 Team Project - Backend

## 1. Project Overview
This is the backend part of the SDSC5003 team project, implemented in **Java**.  
It handles data management, business logic, and provides APIs for the frontend.

---

## 2. Project Structure
```
src/
├─ entity/ # Data entity classes
├─ servlet/ # API controllers
├─ service/ # service logic
├─ utils/ # c3p0 connector
resource/
├─ c3p0-config.xml # set database config(password, location)
```
## 3. Dependencies

- Java 8+
- Maven 3+
- MySQL 8+
- fastjson-1.2.jar

## 4. Database Setup

using MySQL:

run 5003.sql in mysql workbench to initialize the database.


Update database configuration in c3p0-config.xml file:

<property name="user">root</property>
        <property name="password">your password</property>
        <property name="checkoutTimeout">30000</property>
        <property name="initialPoolSize">10</property>
## 5. Running the Project
use tomcat 9 to run the project(in Intellij IDEA)
