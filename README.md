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

<img width="1247" height="636" alt="Снимок экрана — 2026-07-23 в 19 13 11" src="https://github.com/user-attachments/assets/8a137298-cca1-4c0d-ad7d-b968432c2a79" />


### Create User

<img width="575" height="536" alt="Снимок экрана — 2026-07-23 в 19 14 06" src="https://github.com/user-attachments/assets/212d0e24-87d5-4faf-9c11-ffb9702e1a03" />


### Edit User

<img width="582" height="568" alt="Снимок экрана — 2026-07-23 в 19 17 39" src="https://github.com/user-attachments/assets/87891e39-d597-44dd-96d3-9a8b55abfd5b" />


### Error Page

<img width="575" height="329" alt="Снимок экрана — 2026-07-23 в 19 14 31" src="https://github.com/user-attachments/assets/2547f139-ac91-4d27-be89-6a1d57d72da3" />


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

