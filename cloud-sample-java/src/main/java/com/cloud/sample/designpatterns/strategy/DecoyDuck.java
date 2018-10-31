package com.cloud.sample.designpatterns.strategy;

public class DecoyDuck extends Duck{

    @Override
    public void display() {
        System.out.println("I am a decoy duck");
    }
}
