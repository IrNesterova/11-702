package ru.itis;

public class AxeBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("I am using axe!");
    }
}
