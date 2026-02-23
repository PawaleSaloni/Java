package com.saloni.oops.classobject;

public class Student {

    int id;
    String name;

    void display(){
        System.out.println("ID: " + id + ", Name: " + name);
    }
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.id = 1;
        s1.name = "Saloni";
        s1.display();   
    }
}
