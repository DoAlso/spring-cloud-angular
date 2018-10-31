package com.cloud.sample.designpatterns.strategy;

public class FlyWithWings implements FlyingBehavior{
    @Override
    public void fly() {
        System.out.println("I am flying with wings");
    }
}
