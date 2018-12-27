package ru.itis;

public class Character implements Proxy{
    String run;
    String attack;
    String talk;
    @Override
    public String run() {
        return "I am running";
    }

    @Override
    public String attack() {
        return "I am attacking";
    }

    @Override
    public String talk() {
        return "I am talking";
    }

    public Character(){
        this.run = run();
        this.attack = attack();
        this.talk = talk();
    }
}
