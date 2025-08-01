package com.tap.saloni.demo;

import com.tap.saloni.HR.Address;
import com.tap.saloni.HR.SalesEmployee;

public class App {
    public static void main(String[] args) {
        Address addr = new Address("Mumbai", "Maharashtra", "401209");
        SalesEmployee salesEmp = new SalesEmployee(101, "Saloni Pawale", 50000.0, addr, 10000.0);
        
        salesEmp.display(); 
    }
}
