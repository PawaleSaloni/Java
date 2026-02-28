package com.demo.softwaregurukul.vehicles;

import com.demo.softwaregurukul.interfaces.vehicle;

public class electricScooter implements vehicle {
    public void start(){
        System.out.println("Scooter started silently with button");
    }

    public void stop(){
        System.out.println("Scooter stopped with regenerative braking");
    }   
}
