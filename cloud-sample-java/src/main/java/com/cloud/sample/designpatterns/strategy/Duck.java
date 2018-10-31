package com.cloud.sample.designpatterns.strategy;

public abstract class Duck {
    //TODO 需要一个模拟叫声的策略
    private QuackBehavior quackBehavior;


    //TODO 需要一个模拟飞行的策略
    private FlyingBehavior flyingBehavior;


    public void performQuack(){
        quackBehavior.quack();
    }

    public void performFlying(){
        flyingBehavior.fly();
    }

    public abstract void display();

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }


    public void setFlyingBehavior(FlyingBehavior flyingBehavior) {
        this.flyingBehavior = flyingBehavior;
    }
}
