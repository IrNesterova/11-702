package ru.itis;

public class Queen extends Character{
    @Override
    void fight() {
        System.out.println("I am figting!");
    }
    public Queen(){
        weaponBehavior = new KnifeBehavior();
    }
}
