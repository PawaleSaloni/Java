package com.demo.softwaregurukul.vehicles;

import com.demo.softwaregurukul.interfaces.vehicle;

public class car implements vehicle {
    public void start(){
        System.out.println("Car started with key ignition");
    }
    
    public void stop(){
        System.out.println("Car stopped using brakes");
    }
}
