package ru.itis;

public class Main {

    public static void main(String[] args) {
	MallardDuck mduck = new MallardDuck();
	mduck.display();
	mduck.PerformQuack();
	mduck.PerformFly();
	Duck modelDuck = new ModelDuck();
	modelDuck.PerformFly();
	modelDuck.setFlying_behavior(new FlyRocketPowered());
	modelDuck.PerformFly();
    }
}
