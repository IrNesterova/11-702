package ru.itis;

public class SwordBehavior implements WeaponBehavior{

    @Override
    public void useWeapon() {
        System.out.println("I am using sword!");
    }
}
