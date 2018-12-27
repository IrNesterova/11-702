package ru.itis;

import java.util.ArrayList;

public abstract class Pizza{
    String name;
    String dough;
    String sauce;
    ArrayList toppings = new ArrayList();
    void prepare(){
        System.out.println("Preparing " + name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sause...");
        System.out.println("About toppings: ");
        for (int i = 0; i < toppings.size(); i++){
            System.out.println(" " + toppings.get(i));
        }
    }
    void bake(){
        System.out.println("Baking 15 minutes at 400 degrees");
    }
    void cut(){
        System.out.println("Cutting pizza into diagonal slices");
    }
    void box(){
        System.out.println("Placing pizza in a box");
    }
    public String getName(){
        return name;
    }
}
