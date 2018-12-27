package ru.itis;

public class FlyRocketPowered implements Flying_Behavior {
    @Override
    public void fly() {
        System.out.println("I am flying with a rocket!");
    }
}
