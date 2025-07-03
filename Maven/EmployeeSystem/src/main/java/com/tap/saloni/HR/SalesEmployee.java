package com.tap.saloni.HR;

public class SalesEmployee extends Employee {
    private double commission;

    public SalesEmployee(int id, String name, double salary, Address address, double commission) {
        super(id, name, salary, address); // now matches Employee constructor
        this.commission = commission;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Commission: " + commission);
    }
}
