package ru.itis;

public class Character {
    Backpack backpack;
    Weapon weapon = new Fists();
    public Character(){
        backpack = new Backpack();
    }
    public void changeWeapon(int a){
        switch (a){
            case 1:
                weapon = new Fists();
            case 2:
                if (backpack.hasKnife){
                    weapon = new Knife();
                } else {
                    System.out.println("I don't have a knife");
                }
            case 3:
                if (backpack.hasPistol){
                    weapon = new Pistol();
                } else {
                    System.out.println("I don't have a pistol");
                }
        }
    }
}
