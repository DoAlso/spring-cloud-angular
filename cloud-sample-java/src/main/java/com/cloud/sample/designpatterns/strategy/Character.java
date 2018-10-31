package com.cloud.sample.designpatterns.strategy;

public abstract class Character {

    private WeaponBehavior weaponBehavior;

    public void fight(){
        weaponBehavior.useWeapon();
    }

    public void setWeaponBehavior(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }
}
