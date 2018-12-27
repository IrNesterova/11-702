package ru.itis;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Soldier[] soldiers = new Soldier[50];
        for (int i = 0; i < soldiers.length; i ++){
            soldiers[i] = new Soldier();
        }
        Division division = new Division(soldiers);
        division.attack();
    }
}
