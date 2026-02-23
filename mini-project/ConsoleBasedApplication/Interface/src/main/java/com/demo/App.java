package com.demo;

import com.demo.softwaregurukul.interfaces.remoteControl;
import com.demo.softwaregurukul.interfaces.vehicle;
import com.demo.softwaregurukul.tv.lgtv;
import com.demo.softwaregurukul.tv.samsungTv;
import com.demo.softwaregurukul.vehicles.car;
import com.demo.softwaregurukul.vehicles.electricScooter;


public class App 
{
    public static void main( String[] args ){
        System.out.println("Welcome to Software Gurukul");
    
    // Vehicles
    vehicle v1 = new car();
    v1.start();
    v1.stop();

    vehicle v2 = new electricScooter();
    v2.start();
    v2.stop();


    // Remote Control
    remoteControl remote = new lgtv();
    remote.turnOn();
    remote.changeChannel(5);

    remote = new samsungTv();
    remote.turnOn();
    remote.changeChannel(7);
}
}