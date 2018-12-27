package ru.itis;

public class GarageDoorOpenCommand implements Command{
    Light light;
    GaradeDoor garadeDoor;
    public GarageDoorOpenCommand(Light light, GaradeDoor garadeDoor){
        this.light = light;
        this.garadeDoor = garadeDoor;
    }

    @Override
    public void execute() {
        light.on();
        garadeDoor.up();
        garadeDoor.down();
        garadeDoor.stop();
        light.off();
    }
}
