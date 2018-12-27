package ru.itis;

public class Quack implements Quacking_Behavior {
    @Override
    public void quack() {
        System.out.println("Quack!");
    }
}
