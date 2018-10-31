package com.cloud.sample.designpatterns.strategy;

public class KnifeBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("我用刀战斗...");
    }
}
