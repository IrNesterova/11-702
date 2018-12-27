package ru.itis;

public class Division {
    Soldier[]soldiers;
    public Division(Soldier[] soldiers){
        this.soldiers = soldiers;
    }
    public void attack(){
        for (int i = 0; i < soldiers.length; i ++){
            soldiers[i].attack();
        }
    }
}
