# User CRUD Application

![Java](https://img.shields.io/badge/Java-21-orange)
![Jakarta Servlet](https://img.shields.io/badge/Jakarta%20Servlet-6.1-brightgreen)
![JSP](https://img.shields.io/badge/JSP-4.0-darkgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-blue)
![Maven](https://img.shields.io/badge/Maven-3.9-red)
![Tomcat](https://img.shields.io/badge/Tomcat-10-yellow)

A web application for managing users built with Java Servlets, JSP, JDBC, and PostgreSQL.

## Overview

This project is a CRUD (Create, Read, Update, Delete) web application built using Java Servlets, JSP, JDBC, and PostgreSQL.

The application allows users to create, view, update, and delete user records while demonstrating layered architecture, validation, and centralized exception handling.

## Features

* Create new users
* View all users
* Update existing users
* Delete users
* User input validation
* Email uniqueness validation
* Global exception handling
* Responsive user interface
* Layered architecture (Servlet → Service → DAO)
* MVC Pattern (Servlet + JSP)

## Technologies

### Backend

* Java 21 
* Jakarta Servlet
* JSP
* JSTL
* JDBC
* Maven

### Database

* PostgreSQL 17

### Server

* Apache Tomcat 10 

## Key Concepts

- Layered Architecture
- DAO Pattern
- Service Layer Pattern
- Centralized Exception Handling
- Input Validation
- JDBC Database Access
- MVC Approach (Servlet + JSP)

## Request Flow

```text
Client Request
       ↓
ExceptionHandlerFilter
       ↓
Servlet
       ↓
Service
       ↓
DAO
       ↓
PostgreSQL
       ↑
DAO
       ↑
Service
       ↑
Servlet
       ↓
JSP
       ↓
HTML Response
```

### Project Structure

```text
src/main/java
├── dao
├── exception
├── filter
├── model
├── service
├── servlet
├── util
└── validation
```

## Screenshots

### Users List

<img width="2534" height="1236" alt="image" src="https://github.com/user-attachments/assets/e2be003b-49a9-4064-80ea-6643de1e6a58" />

### Create User

<img width="556" height="525" alt="Снимок экрана — 2026-06-22 в 13 12 51" src="https://github.com/user-attachments/assets/33a3af2f-d785-46d5-880e-e5ce7b1a48f4" />

### Edit User

<img width="562" height="556" alt="image" src="https://github.com/user-attachments/assets/148ae92a-5c54-4f78-8c05-f418608c53d4" />

### Error Page

<img width="555" height="313" alt="Снимок экрана — 2026-06-22 в 13 23 05" src="https://github.com/user-attachments/assets/15831b67-39ea-45f4-ac47-04b278ac0df6" />


## Database Schema

```sql
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    age INTEGER NOT NULL
);
```

## Getting Started

### Clone Repository

```bash
git clone https://github.com/Wolfanyy/jdbc-user-crud.git
```

### Create Database

```sql
CREATE DATABASE users_db;
```

### Configure Database Connection

Update database credentials in:

```text
src/main/java/util/DatabaseConnection.java
```

Example:

```java
private static final String URL =
        "jdbc:postgresql://localhost:5432/users_db";

private static final String USERNAME =
        "postgres";

private static final String PASSWORD =
        "your_password";
```

### Build Project

```bash
mvn clean package
```

### Deploy

Deploy the generated WAR file to Apache Tomcat.

## Validation Rules

### Name

* Required
* Length between 3 and 30 characters
* Letters, spaces, and hyphens only

### Last Name

* Required
* Length between 3 and 30 characters
* Letters, spaces, and hyphens only

### Email

* Required
* Must have a valid email format
* Must be unique

### Age

* Required
* Range from 1 to 100

## Error Handling

The application includes centralized exception handling using a servlet filter.

Handled exceptions include:

* ValidationException
* UserNotFoundException
* DuplicateEmailException
* Unexpected server errors

## Author

**Anna Gribanova**

GitHub: https://github.com/Wolfanyy

