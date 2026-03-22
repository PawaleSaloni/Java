# JDBC CRUD Application

A Java-based application demonstrating CRUD (Create, Read, Update, Delete) operations using JDBC with Maven for dependency management.

## Features

* Create User
* Retrieve Users
* Update User
* Delete User

## Tech Stack

* Java
* JDBC
* MySQL
* Maven

## Project Architecture

The project is designed using a clean and maintainable structure:

* **config** → Handles database configuration and connection setup
* **model** → Represents entity classes
* **dao** → Contains data access logic (CRUD operations)
* **app** → Entry point of the application

## Design Approach

* Implemented **DAO (Data Access Object) pattern** to separate business logic from database operations
* Externalized database configuration using `application.properties`
* Ensured modular and maintainable code structure

## Setup Instructions

1. Create database using `schema.sql`
2. Update database credentials in `application.properties`
3. Run `Main.java` to execute the application

## Key Highlights

* Used Maven for efficient dependency management
* Followed industry-standard project structure
* Focused on clean code and separation of concerns
