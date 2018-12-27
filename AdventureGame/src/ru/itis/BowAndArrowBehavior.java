package ru.itis;

public class BowAndArrowBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("I am shooting arrows!");
    }
}
