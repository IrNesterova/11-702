package ru.itis;

public class Main {

    public static void main(String[] args) {
	PizzaStore NY = new NYStylePizzaStore();
	PizzaStore chicago = new ChicagoStylePizzaStore();

	Pizza pizza = NY.orderPizza("cheese");
	System.out.println("Ethan ordered a " + pizza.getName() + "\n");
    }
}
