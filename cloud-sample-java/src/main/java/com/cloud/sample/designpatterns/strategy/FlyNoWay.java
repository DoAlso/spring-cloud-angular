package com.cloud.sample.designpatterns.strategy;

public class FlyNoWay implements FlyingBehavior{
    @Override
    public void fly() {
        System.out.println("I cant not fly");
    }
}
