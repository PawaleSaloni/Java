REST API – Complete Guide
📌 What is REST API?

REST API (Representational State Transfer Application Programming Interface) is a way for systems to communicate over HTTP using standard methods like:

GET

POST

PUT

DELETE

REST is an architectural style introduced by
👤 Roy Fielding

REST APIs usually exchange data in JSON format.

🏗️ REST Architecture Flow
Client (Frontend / Mobile App)
        ↓ HTTP Request
REST Controller (Backend)
        ↓
Service Layer
        ↓
Repository Layer
        ↓
Database
        ↓
HTTP Response (JSON)
🔹 HTTP Methods (CRUD Operations)
Method	Operation	Description
GET	Read	Fetch data
POST	Create	Insert new data
PUT	Update	Modify existing data
DELETE	Delete	Remove data
🔹 Example REST Endpoints
GET     /users
GET     /users/1
POST    /users
PUT     /users/1
DELETE  /users/1
🔹 Sample REST API (Spring Boot)

Built using Spring Boot

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
🔹 REST Principles (Very Important)
1️⃣ Stateless

Server does NOT store client session.

Every request must contain complete information.

2️⃣ Client-Server Architecture

Frontend and backend are independent.

3️⃣ Cacheable

Responses can be cached.

4️⃣ Uniform Interface

Standard HTTP methods must be used.

5️⃣ Layered System

Security, load balancer, API gateway can exist between client and server.

🔹 What is a Resource?

A resource is any data object:

User

Product

Student

Order

Example:

/users        → collection
/users/10     → single resource
🔹 Request & Response Format
Request Body (JSON)
{
  "name": "Saloni",
  "email": "saloni@gmail.com"
}
Response Body (JSON)
{
  "id": 1,
  "name": "Saloni",
  "email": "saloni@gmail.com"
}
🔹 HTTP Status Codes
Code	Meaning
200	OK
201	Created
400	Bad Request
401	Unauthorized
404	Not Found
500	Internal Server Error
🔹 REST vs SOAP
Feature	REST	SOAP
Data Format	JSON	XML
Performance	Fast	Slower
Complexity	Simple	Complex
Popularity	Very High	Low
🔹 Tools for Testing REST API

Postman

Swagger

cURL

🔹 Project Structure (Spring Boot REST API)
project-name
│
├── controller
│     └── UserController.java
│
├── service
│     └── UserService.java
│
├── repository
│     └── UserRepository.java
│
├── model
│     └── User.java
│
├── application.properties
└── pom.xml
🔹 Advantages of REST API

Platform Independent

Lightweight

Scalable

Easy to integrate

Widely used in modern web & mobile apps

🔹 Real-World Usage

Modern applications use:

Backend → Spring Boot

Frontend → React / Angular

Database → MySQL / PostgreSQL

API Testing → Postman
