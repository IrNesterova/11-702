package ru.itis;

public class CaliforniaStylePizzaStore extends PizzaStore {
    Pizza pizza = null;

    @Override
    public Pizza createPizza(String type) {
        if (type.equals("cheese")){
      //     pizza = new CaliforniaStyleCheesePizza();
        } else if (type.equals("pepperoni")){
      //      pizza = new CaliforniaStylePepperoniPizza();
        } else if (type.equals("clam")){
       //     pizza = new CaliforniaStyleClamPizza();
        } else if (type.equals("veggie")){
      //      pizza = new CaliforniaStyleVeggiePizza();
        }
       return pizza;
    }
}
