package ru.itis;

public class FlyNoWay implements Flying_Behavior {
    @Override
    public void fly() {
        System.out.println("I can't fly!");
    }
}
