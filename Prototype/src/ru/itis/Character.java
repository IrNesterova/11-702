package ru.itis;

public abstract class Character {
    public String walk;
    public String talk;
    public String fight;
    public Character(){

    }
    public Character(Character target){
        this.walk = target.walk;
        this.talk = target.talk;
        this.fight = target.fight;
    }
    public abstract Character clone();
}
