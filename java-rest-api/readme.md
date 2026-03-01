# 🌐 REST API – Complete Notes

## 📌 Introduction

REST API (Representational State Transfer – Application Programming Interface) is a web service architecture that allows communication between client and server using the HTTP protocol.

REST was introduced by Roy Fielding.

REST APIs usually exchange data in **JSON format**.

---

# 🏗️ REST Architecture Overview

Client (Web / Mobile App)  
↓  
HTTP Request (GET, POST, PUT, DELETE)  
↓  
REST Controller  
↓  
Service Layer  
↓  
Repository Layer  
↓  
Database  
↓  
HTTP Response (JSON)

---

# 🔹 HTTP Methods (CRUD Operations)

| Method  | Operation | Description |
|----------|------------|-------------|
| GET      | READ       | Retrieve data |
| POST     | CREATE     | Add new data |
| PUT      | UPDATE     | Modify existing data |
| DELETE   | DELETE     | Remove data |

---

## 🔹 Example REST Endpoints

GET     /users  
GET     /users/{id}  
POST    /users  
PUT     /users/{id}  
DELETE  /users/{id}  

---

# 🔹 What is a Resource?

A resource represents data in the system.

Examples:
- User
- Product
- Order
- Student

Example URLs:

/users        → All users  
/users/5      → User with ID 5  

---

# 🔹 REST Principles (Important for Interview)

### 1️⃣ Stateless
- Server does not store client session.
- Each request must contain complete information.

### 2️⃣ Client-Server Architecture
- Frontend and backend are separate systems.

### 3️⃣ Cacheable
- Responses can be cached for performance.

### 4️⃣ Uniform Interface
- Standard HTTP methods must be used.

### 5️⃣ Layered System
- System may include security layers, API gateways, load balancers.

---

# 🔹 JSON Example

## Request (JSON)

```json
{
  "name": "Saloni",
  "email": "saloni@gmail.com"
}
```

## Response (JSON)

```json
{
  "id": 1,
  "name": "Saloni",
  "email": "saloni@gmail.com"
}
```
---

# 🔹 HTTP Status Codes

HTTP status codes indicate the result of an API request.

| Status Code | Meaning | Description |
|-------------|----------|-------------|
| 200 | OK | Request was successful |
| 201 | Created | Resource successfully created |
| 400 | Bad Request | Invalid request data |
| 401 | Unauthorized | Authentication required |
| 404 | Not Found | Resource not found |
| 500 | Internal Server Error | Server-side error occurred |

---

## 🔹 Sample REST API (Spring Boot)

Below is a simple example of a REST Controller built using Spring Boot:

```java
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
```

---

# 🔹 REST vs SOAP

REST and SOAP are two different approaches for building web services.

| Feature        | REST                      | SOAP                      |
|---------------|---------------------------|---------------------------|
| Data Format   | JSON (mainly)             | XML only                  |
| Performance   | Faster and lightweight    | Slower and heavier        |
| Complexity    | Simple and easy to use    | Complex and strict rules  |
| Usage Today   | Very Popular              | Limited usage             |

### 📌 Key Differences

- **REST** is an architectural style.
- **SOAP** is a protocol.
- REST is widely used in modern web and mobile applications.
- SOAP is mostly used in enterprise systems requiring high security and strict standards.

---

# 🔹 Tools for Testing REST API

The following tools are commonly used to test and document REST APIs:

### 1️⃣ Postman
- API testing tool
- Allows sending HTTP requests (GET, POST, PUT, DELETE)
- Helps test request body, headers, parameters, and authentication

### 2️⃣ Swagger
- API documentation tool
- Provides interactive API UI
- Helps developers understand and test endpoints directly from the browser

### 3️⃣ cURL
- Command-line HTTP client
- Used to send HTTP requests from terminal
- Helpful for quick API testing and automation scripts

---

# 🔹 Project Structure (Spring Boot REST API)

Below is a typical folder structure of a Spring Boot REST API project:

```
project-name
│
├── src/main/java/com/example/project
│   ├── controller
│   │     └── UserController.java
│   │
│   ├── service
│   │     ├── UserService.java
│   │     └── UserServiceImpl.java
│   │
│   ├── repository
│   │     └── UserRepository.java
│   │
│   ├── model
│   │     └── User.java
│   │
│   └── ProjectApplication.java
│
├── src/main/resources
│   └── application.properties
│
├── pom.xml
│
└── README.md
```
---

# 📁 Folder Description

### 📂 controller
- Handles HTTP requests
- Contains REST endpoints
- Communicates with service layer

### 📂 service
- Contains business logic
- Processes data before saving or returning

### 📂 repository
- Handles database operations
- Interacts with database using JPA or JDBC

### 📂 model
- Contains entity classes
- Represents database tables

### 📄 application.properties
- Configuration file
- Contains database connection details, server port, etc.

### 📄 pom.xml
- Maven dependency file
- Manages project dependencies and plugins

---

# 🔹 Advantages of REST API

- Platform independent  
- Lightweight and fast  
- Scalable for large applications  
- Easy integration with frontend and mobile apps  
- Supports multiple data formats (JSON, XML)  
- Widely used in modern web development  

---

# 📌 Conclusion

REST API is a powerful and flexible architecture widely used in modern web applications. Combined with Spring Boot, it enables developers to build scalable, maintainable, and production-ready backend systems efficiently.


