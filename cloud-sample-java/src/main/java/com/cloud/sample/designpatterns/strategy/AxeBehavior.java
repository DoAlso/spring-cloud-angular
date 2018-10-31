package com.cloud.sample.designpatterns.strategy;

public class AxeBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("我用斧子战斗...");
    }
}
