package ru.itis;

public class MallardDuck extends Duck {
    public MallardDuck(){
        quacking_behavior = new Quack();
        flying_behavior = new FlyWithWings();
    }
    public void display(){
        System.out.print("I am real Mallard duck!");
    }
}
