package ru.itis;

public class Main {

    public static void main(String[] args) {
	Character queen = new Queen();
	queen.setWeaponBehavior(new KnifeBehavior());
	queen.fight();
    }
}
