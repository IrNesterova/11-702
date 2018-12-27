package ru.itis;

public class King extends Character {
    @Override
    void fight() {

    }
    public King(){
        weaponBehavior = new SwordBehavior();
    }
}
