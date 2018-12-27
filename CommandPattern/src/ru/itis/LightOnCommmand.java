package ru.itis;


public class LightOnCommmand implements Command {
    Light light;
    public LightOnCommmand(Light light){
        this.light = light;
    }
    @Override
    public void execute() {
        light.on();
    }
}
