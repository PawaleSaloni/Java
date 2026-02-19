package com.saloni.oops.classobject;

public class Car {

    int id;
    String name;

    void display(){
        System.out.println("ID: " + id + ", Name: " + name );
    }
    public static void main(String[] args) {
        Car c1 = new Car();
        c1.id = 10;
        c1.name = "Audi";
        c1.display();

    }
}
