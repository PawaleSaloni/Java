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

# 🔹 Request & Response Example

### Request (JSON)

```json
{
  "name": "Saloni",
  "email": "saloni@gmail.com"
}
