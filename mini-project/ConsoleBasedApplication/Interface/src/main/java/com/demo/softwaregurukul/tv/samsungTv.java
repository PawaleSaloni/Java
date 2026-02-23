package com.demo.softwaregurukul.tv;

import com.demo.softwaregurukul.interfaces.remoteControl;

public class samsungTv implements remoteControl {

    public void turnOn(){
        System.out.println("Samsung TV ON");
    }
    
    public void changeChannel(int c){
        System.out.println("Samsung channel: "+c);
    }
}
