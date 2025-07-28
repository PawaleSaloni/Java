package com.tap.saloni.HR;

public class Employee {
    protected int id;
    protected String name;
    protected double salary;
    protected Address address; // Containment: HAS-A relationship

    public Employee(int id, String name, double salary, Address address) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.address = address;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
        if (address != null) {
            address.display();
        }
    }
}