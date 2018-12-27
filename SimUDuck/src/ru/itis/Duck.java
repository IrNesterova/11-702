package ru.itis;

public abstract class Duck {
    Flying_Behavior flying_behavior;
    Quacking_Behavior quacking_behavior;
    public void PerformQuack(){
        quacking_behavior.quack();
    }
    public void PerformFly(){
        flying_behavior.fly();
    }
    public abstract void display();
    public void swim(){
        System.out.println("All ducks float, even decoys!");
    }
    public void setFlying_behavior(Flying_Behavior fb){
        flying_behavior = fb;
    }
    public void setQuacking_behavior(Quacking_Behavior qb){
        quacking_behavior = qb;
    }
}
