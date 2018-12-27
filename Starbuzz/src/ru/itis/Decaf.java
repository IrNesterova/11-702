package ru.itis;

public class Decaf extends Beverage {
    @Override
    public double cost() {
        return 0.80;
    }
    public Decaf(){
        description = "Decaf";
    }
}
