# 📚 Digital Library System

A Spring Boot–based web application that manages a **Digital Library** — including books, authors, users, and transactions (borrowing/returning books).  
It provides RESTful APIs for library management and supports filtering, validation, and exception handling.

---

## Features

- **Book Management** – Add, update, delete, and fetch book details.
- **Author Management** – Manage authors and their associated books.
- **User Management** – Register users, update profiles, and manage user types (Student, Admin, etc.).
- **Transaction Management** – Borrow and return books with proper transaction records.
- **Filtering Support** – Search and filter based on book type, user type, or transaction status.
- **Custom Exception Handling** – Centralized exception management for clean API responses.

---

## Project Structure
```
Digital-Library-main/
│
├── pom.xml # Maven dependencies
├── src/main/java/com/example/Digital_Library/
│ ├── DigitalLibraryApplication.java # Main Spring Boot entry point
│ ├── controller/ # REST controllers
│ ├── dto/ # Data Transfer Objects
│ ├── exception/ # Custom exceptions and handlers
│ ├── model/ # Entity models and enums
│ ├── repository/ # Spring Data JPA repositories
│ └── service/ # Business logic layer
└── src/main/resources/
├── application.properties # Configuration file
```


---

## Prerequisites

Make sure you have the following installed:

- **Java 17+**
- **Maven 3.8+**
- **MySQL Server**
- **IDE** like IntelliJ IDEA / Eclipse / VS Code

---

## Setup and Run

### 1 Clone the Repository
```bash
git clone https://github.com/<your-username>/Digital-Library.git
cd Digital-Library-main
```
### 2 Configure Database

Edit src/main/resources/application.properties:
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/digital_library
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update
```
### 3 Build the Project
```
mvn clean install
```

### 4 Run the Application
```
mvn spring-boot:run
```

## API Endpoints
The application will start at: http://localhost:8080

| Category         | Method | Endpoint         | Description            |
| ---------------- | ------ | ---------------- | ---------------------- |
| **Books**        | GET    | `/book/all`      | Get all books          |
|                  | POST   | `/book/add`      | Add new book           |
| **Authors**      | GET    | `/author/all`    | Get all authors        |
|                  | POST   | `/author/add`    | Add new author         |
| **Users**        | GET    | `/user/all`      | Get all users          |
|                  | POST   | `/user/register` | Register new user      |
| **Transactions** | POST   | `/txn/borrow`    | Borrow a book          |
|                  | POST   | `/txn/return`    | Return a borrowed book |

## Dependencies

Major dependencies used in pom.xml:

Spring Boot Starter Web

Spring Boot Starter Data JPA

MySQL Connector

Lombok

Validation API


## Technologies Used

Java 17

Spring Boot 3

MySQL

Hibernate / JPA

Maven

RESTful APIs

## License
This Digital Library System is open source and released under the MIT License. Feel free to use, modify, and distribute it as per the terms of the license.