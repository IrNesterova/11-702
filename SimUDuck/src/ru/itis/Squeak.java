package ru.itis;

public class Squeak implements Quacking_Behavior {
    @Override
    public void quack() {
        System.out.println("Squeak!");
    }
}
