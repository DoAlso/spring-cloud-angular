package com.cloud.sample.designpatterns.strategy;

public class Squack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("吱吱叫...9");
    }
}
