package ru.itis;

public class HouseBlend extends Beverage {
    public HouseBlend(){
        description = "House blend";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
