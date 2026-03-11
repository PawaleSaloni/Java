# ☕ Java OOP — Complete Mastery Guide
> For interviews, Spring Boot, and real-world development

---

## 📋 Table of Contents

1. [Encapsulation](#1️⃣-encapsulation)
2. [Inheritance](#2️⃣-inheritance)
3. [Polymorphism](#3️⃣-polymorphism)
4. [Abstraction](#4️⃣-abstraction)
5. [Interfaces (Deep Dive)](#5️⃣-interfaces-deep-dive)
6. [SOLID Principles](#6️⃣-solid-principles)
7. [Design Patterns (OOP in Action)](#7️⃣-design-patterns-oop-in-action)
8. [OOP in Spring Boot](#8️⃣-oop-in-spring-boot)
9. [Interview Cheat Sheet](#9️⃣-interview-cheat-sheet)

---

## 1️⃣ Encapsulation

> **Definition:** Binding data (variables) and methods together and restricting direct access to data.

### ✅ Basic Key Points

- Wrap data + methods into a single unit (class)
- Use `private` variables
- Access via **getters** and **setters**

```java
class Student {
    private int id;
    private String name;

    public void setId(int id) { this.id = id; }
    public int getId() { return id; }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }
}
```

### 📌 Important Rules

| Rule | Description |
|------|-------------|
| Data members | Should be `private` |
| Methods | Should be `public` |
| Validation | Add logic in setters to validate input |

### 🎯 Advantages

- ✔ Data hiding
- ✔ Better security
- ✔ Controlled access
- ✔ Code maintainability

---

### 🚀 Advanced Points

#### Immutable Classes
```java
final class User {
    private final String name;
    private final int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    // No setters — immutable!
}
```

**Rules for Immutable Classes:**
1. Declare class as `final`
2. All fields `private final`
3. No setters
4. Initialize all fields via constructor
5. Return copies of mutable objects (e.g., `Date`, `List`)

#### Encapsulation with Validation
```java
class BankAccount {
    private double balance;

    public void setBalance(double balance) {
        if (balance < 0) throw new IllegalArgumentException("Balance cannot be negative");
        this.balance = balance;
    }

    public double getBalance() { return balance; }
}
```

#### Usage in Frameworks
| Framework | Encapsulation Usage |
|-----------|---------------------|
| **Hibernate** | Entity fields private, accessed via getters/setters |
| **Spring Boot** | DTOs, Entities, Request/Response models |
| **Lombok** | `@Getter`, `@Setter`, `@Data` auto-generate boilerplate |

```java
// Spring Boot DTO Example
@Data  // Lombok auto-generates getters, setters, equals, hashCode
public class UserDTO {
    private Long id;
    private String name;
    private String email;
}
```

---

## 2️⃣ Inheritance

> **Definition:** Allows one class to acquire properties and behaviors of another class.

### Syntax

```java
class Parent {
    void display() {
        System.out.println("Parent class");
    }
}

class Child extends Parent {
    // Inherits display() from Parent
}
```

### 📊 Types of Inheritance in Java

```
Single:        A → B
Multilevel:    A → B → C
Hierarchical:  A → B
               A → C
Multiple:      ❌ Not supported with classes (✅ via interfaces)
```

```java
// Single Inheritance
class Animal {
    void eat() { System.out.println("Eating"); }
}

class Dog extends Animal {
    void bark() { System.out.println("Barking"); }
}

// Multilevel Inheritance
class Animal {
    void breathe() { System.out.println("Breathing"); }
}

class Mammal extends Animal {
    void nurse() { System.out.println("Nursing young"); }
}

class Dog extends Mammal {
    void bark() { System.out.println("Barking"); }
}
```

### 🔑 Keywords

| Keyword | Usage |
|---------|-------|
| `extends` | Class inherits from another class |
| `super` | Refers to parent class |
| `super()` | Calls parent constructor |
| `@Override` | Marks method as overridden |
| `final` | Prevents further inheritance |

---

### 🚀 Advanced Points

#### Constructor Chaining with `super()`
```java
class Animal {
    String name;

    Animal(String name) {
        this.name = name;
        System.out.println("Animal created: " + name);
    }
}

class Dog extends Animal {
    String breed;

    Dog(String name, String breed) {
        super(name);           // MUST be first line
        this.breed = breed;
        System.out.println("Dog breed: " + breed);
    }
}
// Output:
// Animal created: Rex
// Dog breed: Labrador
```

#### Abstract Class Inheritance
```java
abstract class Shape {
    String color;

    Shape(String color) { this.color = color; }

    abstract double area();       // Must be overridden

    void display() {              // Concrete method — inherited
        System.out.println("Color: " + color + ", Area: " + area());
    }
}

class Circle extends Shape {
    double radius;

    Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}
```

#### Preventing Inheritance
```java
final class Singleton {
    // Cannot be extended
}
```

---

## 3️⃣ Polymorphism

> **Definition:** One object behaving in multiple ways.

### Types

```
Polymorphism
├── Compile-time (Static)  → Method Overloading
└── Runtime (Dynamic)      → Method Overriding
```

---

### 🔁 Compile-Time Polymorphism — Method Overloading

```java
class MathOperation {

    int add(int a, int b) { return a + b; }
    int add(int a, int b, int c) { return a + b + c; }
    double add(double a, double b) { return a + b; }
    String add(String a, String b) { return a + b; }
}
```

**Rules:**
- ✅ Same method name
- ✅ Different number/type of parameters
- ❌ Return type alone CANNOT differentiate overloaded methods
- Resolved at **compile time**

---

### 🔄 Runtime Polymorphism — Method Overriding

```java
class Animal {
    void sound() { System.out.println("Some sound"); }
}

class Dog extends Animal {
    @Override
    void sound() { System.out.println("Dog barks"); }
}

class Cat extends Animal {
    @Override
    void sound() { System.out.println("Cat meows"); }
}
```

**Rules:**
- ✅ Same method name and parameters
- ✅ Must use inheritance
- ✅ Use `@Override` annotation
- ❌ `static`, `private`, `final` methods cannot be overridden
- Resolved at **runtime**

---

### 🚀 Advanced Points

#### Dynamic Method Dispatch (Upcasting)
```java
Animal a1 = new Dog();   // Upcasting
Animal a2 = new Cat();

a1.sound();  // Output: Dog barks
a2.sound();  // Output: Cat meows
// Method called depends on ACTUAL object type, not reference type
```

#### Downcasting
```java
Animal a = new Dog();       // Upcasting (implicit)
Dog d = (Dog) a;            // Downcasting (explicit cast)
d.bark();

// Safe downcasting with instanceof
if (a instanceof Dog) {
    Dog dog = (Dog) a;
    dog.bark();
}

// Java 16+ Pattern Matching
if (a instanceof Dog dog) {
    dog.bark();             // No explicit cast needed
}
```

#### Polymorphism with Collections
```java
List<Animal> animals = new ArrayList<>();
animals.add(new Dog());
animals.add(new Cat());

for (Animal animal : animals) {
    animal.sound();  // Calls correct overridden method each time
}
```

---

## 4️⃣ Abstraction

> **Definition:** Hiding implementation details and showing only functionality.

> 💡 **Real-world analogy:** You drive a car (use the interface) without knowing how the engine works (implementation hidden).

### Two Ways to Achieve Abstraction

```
Abstraction
├── Abstract Class  → Partial abstraction (0–100%)
└── Interface       → Full abstraction (100%) [before Java 8]
```

---

### 🏛️ Using Abstract Class

```java
abstract class Vehicle {
    String brand;

    Vehicle(String brand) { this.brand = brand; }

    abstract void start();      // No body — must be overridden
    abstract void stop();

    void refuel() {             // Concrete — inherited as-is
        System.out.println(brand + " is refueling");
    }
}

class Car extends Vehicle {

    Car(String brand) { super(brand); }

    @Override
    void start() { System.out.println(brand + " car started with key"); }

    @Override
    void stop() { System.out.println(brand + " car stopped with brakes"); }
}

class ElectricCar extends Vehicle {

    ElectricCar(String brand) { super(brand); }

    @Override
    void start() { System.out.println(brand + " EV started with button"); }

    @Override
    void stop() { System.out.println(brand + " EV stopped via regen braking"); }
}
```

**Abstract Class Rules:**
- Cannot instantiate directly (`new Vehicle()` ❌)
- Can have constructors
- Can have both abstract and concrete methods
- Can have instance variables

---

### 🔌 Using Interface

```java
interface Payment {
    double MAX_LIMIT = 100000;   // public static final (implicitly)
    void pay(double amount);     // public abstract (implicitly)
}

class CreditCard implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " via Credit Card");
    }
}

class UPI implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " via UPI");
    }
}
```

---

## 5️⃣ Interfaces (Deep Dive)

> Interfaces are the backbone of clean, flexible Java design.

### Abstract Class vs Interface

| Feature | Abstract Class | Interface |
|---------|---------------|-----------|
| Instantiation | ❌ | ❌ |
| Constructor | ✅ | ❌ |
| Instance variables | ✅ | ❌ (only `static final`) |
| Method types | Abstract + Concrete | Abstract + `default` + `static` |
| Multiple inheritance | ❌ | ✅ |
| `extends` / `implements` | `extends` | `implements` |

---

### Java 8+ Interface Features

```java
interface Greeting {

    // Abstract method (must implement)
    void greet(String name);

    // Default method (can override or use as-is)
    default void greetAll(String[] names) {
        for (String name : names) greet(name);
    }

    // Static method (called on interface directly)
    static String defaultLanguage() {
        return "English";
    }
}

// Java 9+: Private methods in interfaces
interface Logger {
    default void logInfo(String msg)  { log("INFO", msg); }
    default void logError(String msg) { log("ERROR", msg); }

    private void log(String level, String msg) {
        System.out.println("[" + level + "] " + msg);
    }
}
```

### Multiple Interface Implementation

```java
interface Flyable  { void fly(); }
interface Swimmable { void swim(); }

class Duck implements Flyable, Swimmable {
    @Override public void fly()  { System.out.println("Duck flying"); }
    @Override public void swim() { System.out.println("Duck swimming"); }
}
```

### Functional Interfaces & Lambdas

```java
@FunctionalInterface
interface Calculator {
    int operate(int a, int b);
}

// Traditional
Calculator add = new Calculator() {
    public int operate(int a, int b) { return a + b; }
};

// Lambda (Java 8+)
Calculator add      = (a, b) -> a + b;
Calculator multiply = (a, b) -> a * b;

System.out.println(add.operate(5, 3));       // 8
System.out.println(multiply.operate(5, 3));  // 15
```

---

## 6️⃣ SOLID Principles

> The 5 principles that make OOP code clean, scalable, and maintainable.

### S — Single Responsibility Principle

> A class should have **only one reason to change**.

```java
// ❌ BAD — one class doing too much
class UserService {
    void saveUser(User u) { /* DB logic */ }
    void sendEmail(User u) { /* email logic */ }
    void generateReport() { /* report logic */ }
}

// ✅ GOOD — one responsibility per class
class UserRepository { void save(User u) { /* DB logic */ } }
class EmailService    { void send(User u) { /* email */ } }
class ReportService   { void generate()  { /* report */ } }
```

### O — Open/Closed Principle

> **Open** for extension, **Closed** for modification.

```java
interface Discount {
    double apply(double price);
}

class SeasonalDiscount implements Discount {
    public double apply(double price) { return price * 0.90; }
}

class LoyaltyDiscount implements Discount {
    public double apply(double price) { return price * 0.85; }
}

// Add new discount types without modifying existing code ✅
```

### L — Liskov Substitution Principle

> Subtypes must be substitutable for their base types.

```java
class Rectangle {
    int width, height;
    int area() { return width * height; }
}

// ✅ Square CAN extend Rectangle if behavior stays consistent
class Square extends Rectangle {
    void setSize(int side) { width = height = side; }
}
```

### I — Interface Segregation Principle

> Don't force classes to implement interfaces they don't use.

```java
// ❌ BAD — fat interface
interface Worker {
    void work();
    void eat();
    void sleep();
}

// ✅ GOOD — segregated interfaces
interface Workable  { void work(); }
interface Eatable   { void eat(); }
interface Sleepable { void sleep(); }

class HumanWorker implements Workable, Eatable, Sleepable { /*...*/ }
class RobotWorker  implements Workable { /*...*/ }  // Robots don't eat/sleep
```

### D — Dependency Inversion Principle

> Depend on **abstractions**, not concretions.

```java
// ❌ BAD — tightly coupled
class OrderService {
    MySQLDatabase db = new MySQLDatabase();   // Hardcoded dependency
}

// ✅ GOOD — loosely coupled via interface
interface Database { void save(Order o); }
class MySQLDatabase   implements Database { public void save(Order o) {/**/} }
class MongoDatabase   implements Database { public void save(Order o) {/**/} }

class OrderService {
    private final Database db;
    OrderService(Database db) { this.db = db; }  // Injected (DI)
}
```

---

## 7️⃣ Design Patterns (OOP in Action)

### Creational: Singleton Pattern

```java
public class DatabaseConnection {
    private static DatabaseConnection instance;

    private DatabaseConnection() {}   // Private constructor

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}
```

### Creational: Builder Pattern

```java
public class Pizza {
    private String size, crust, sauce;
    private List<String> toppings;

    private Pizza(Builder b) {
        this.size = b.size;
        this.crust = b.crust;
        this.sauce = b.sauce;
        this.toppings = b.toppings;
    }

    public static class Builder {
        private String size, crust = "thin", sauce = "tomato";
        private List<String> toppings = new ArrayList<>();

        public Builder size(String s)          { this.size = s; return this; }
        public Builder crust(String c)         { this.crust = c; return this; }
        public Builder addTopping(String t)    { this.toppings.add(t); return this; }
        public Pizza build()                   { return new Pizza(this); }
    }
}

// Usage:
Pizza pizza = new Pizza.Builder()
    .size("large")
    .crust("thick")
    .addTopping("cheese")
    .addTopping("mushrooms")
    .build();
```

### Structural: Decorator Pattern

```java
interface Coffee { double getCost(); String getDescription(); }

class SimpleCoffee implements Coffee {
    public double getCost() { return 30; }
    public String getDescription() { return "Coffee"; }
}

class MilkDecorator implements Coffee {
    private Coffee coffee;
    MilkDecorator(Coffee c) { this.coffee = c; }
    public double getCost() { return coffee.getCost() + 10; }
    public String getDescription() { return coffee.getDescription() + ", Milk"; }
}

// Usage: Coffee c = new MilkDecorator(new SimpleCoffee());
```

### Behavioral: Strategy Pattern

```java
interface SortStrategy { void sort(int[] arr); }

class BubbleSort implements SortStrategy {
    public void sort(int[] arr) { /* bubble sort logic */ }
}

class QuickSort implements SortStrategy {
    public void sort(int[] arr) { /* quicksort logic */ }
}

class Sorter {
    private SortStrategy strategy;
    Sorter(SortStrategy s) { this.strategy = s; }
    void sort(int[] arr) { strategy.sort(arr); }
}
```

---

## 8️⃣ OOP in Spring Boot

### How All 4 Principles Appear in Spring Boot

| OOP Principle | Spring Boot Usage |
|---------------|-------------------|
| **Encapsulation** | `@Entity`, `@Data`, DTOs, private fields |
| **Inheritance** | `JpaRepository` extends `CrudRepository` |
| **Polymorphism** | Multiple `@Service` implementations of one interface |
| **Abstraction** | `Repository`, `Service` interfaces |

### Typical Layered Architecture

```
Controller Layer     ← Handles HTTP requests
      ↓
Service Interface    ← Abstraction (contract)
      ↓
Service Impl         ← Polymorphism (different impls)
      ↓
Repository           ← Inheritance (extends JpaRepository)
      ↓
Entity/DTO           ← Encapsulation
```

### Example

```java
// Abstraction — Interface
public interface UserService {
    UserDTO getUserById(Long id);
    UserDTO createUser(UserDTO dto);
}

// Polymorphism — Implementation
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;   // Dependency Inversion (DI)

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
        return mapToDTO(user);
    }

    @Override
    public UserDTO createUser(UserDTO dto) {
        User user = mapToEntity(dto);
        return mapToDTO(userRepository.save(user));
    }
}

// Encapsulation — Entity
@Entity
@Data  // Lombok
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
}

// Inheritance — Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
```

---

## 9️⃣ Interview Cheat Sheet

### Quick Comparisons

| Topic | Key Difference |
|-------|----------------|
| Overloading vs Overriding | Overloading = same class, diff params. Overriding = parent-child, same signature |
| Abstract class vs Interface | Abstract = partial abstraction + state. Interface = full abstraction + multiple inheritance |
| `extends` vs `implements` | `extends` = class/class or interface/interface. `implements` = class/interface |
| `this` vs `super` | `this` = current class. `super` = parent class |
| Early vs Late Binding | Overloading = early (compile-time). Overriding = late (runtime) |

### Top Interview Questions

1. **Can we override `static` methods?** → No, they are hidden, not overridden.
2. **Can a constructor be inherited?** → No, but `super()` calls the parent constructor.
3. **What is covariant return type?** → Overriding method can return a subtype.
4. **Can an interface extend multiple interfaces?** → Yes!
5. **Difference between `final`, `finally`, `finalize`?**
   - `final` → variable/method/class restriction
   - `finally` → block always executes after try-catch
   - `finalize()` → called by GC before object is destroyed
6. **What is marker interface?** → Empty interface (e.g., `Serializable`, `Cloneable`)
7. **Can abstract class have a constructor?** → Yes! Called via `super()`.
8. **What is diamond problem?** → Ambiguity in multiple inheritance — solved in Java via interface `default` method conflict resolution.

```java
// Diamond problem resolution
interface A { default void greet() { System.out.println("A"); } }
interface B extends A { default void greet() { System.out.println("B"); } }
interface C extends A { default void greet() { System.out.println("C"); } }

class D implements B, C {
    @Override
    public void greet() {
        B.super.greet();  // Explicitly choose B's implementation
    }
}
```

---

## 🗺️ Learning Roadmap

```
Week 1: Encapsulation + Inheritance basics
Week 2: Polymorphism + Abstraction
Week 3: Interfaces deep dive + Java 8 features
Week 4: SOLID Principles
Week 5: Design Patterns (Singleton, Factory, Builder, Strategy)
Week 6: Apply everything in Spring Boot project
```

---

*Happy Coding! ☕ Master OOP → Master Java → Master Spring Boot*
