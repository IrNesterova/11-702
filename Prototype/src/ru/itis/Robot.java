package ru.itis;

public class Robot extends Character {
    public Robot(){

    }
    public Robot(Robot target){
        super(target);
    }

    @Override
    public Character clone() {
        return new Robot(this);
    }
}
