package ru.itis;

public class DarkRoast extends Beverage {
    @Override
    public double cost() {
        return 0.50;
    }
    public DarkRoast(){
        description = "Dark roast";
    }

}
