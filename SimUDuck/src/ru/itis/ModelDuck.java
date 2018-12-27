package ru.itis;

public class ModelDuck extends Duck {
    @Override
    public void display() {
        System.out.println("I am model duck!");
    }
    public ModelDuck(){
        flying_behavior = new FlyNoWay();
        quacking_behavior = new Quack();
    }


}
