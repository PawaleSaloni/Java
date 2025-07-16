package com.demo.softwaregurukul.tv;

import com.demo.softwaregurukul.interfaces.remoteControl;

public class lgtv implements remoteControl {

        public void turnOn(){
            System.out.println("LG TV ON");
        }

        public void changeChannel(int c){
            System.out.println("LG channel: "+ c);
        }
    }    

