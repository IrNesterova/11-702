package ru.itis;

public class Robot implements Proxy {
    Character character;
    public String attack;
    public String run;
    public String talk;
    public Robot(){
        this.run = run();
        this.talk = talk();
        this.attack = attack();
    }
    @Override
    public String run() {
        return character.run();
    }

    @Override
    public String attack() {
        return character.attack();
    }

    @Override
    public String talk() {
        return character.talk();
    }

}
