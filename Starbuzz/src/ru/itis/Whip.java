package ru.itis;

public class Whip extends CondimentDecorator {
    Beverage beverage;
    public Whip(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", whipped";
    }

    @Override
    public double cost() {
        return 0.30 + beverage.cost();
    }
}
