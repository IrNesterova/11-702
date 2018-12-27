package ru.itis;

public class Pistol implements Weapon {
    @Override
    public void attack() {
        System.out.println("I never miss my target");
    }
}
