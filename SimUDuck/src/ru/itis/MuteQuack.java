package ru.itis;

public class MuteQuack implements Quacking_Behavior {
    @Override
    public void quack() {
        System.out.println("...");
    }
}
