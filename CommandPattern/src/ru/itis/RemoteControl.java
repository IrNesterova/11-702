package ru.itis;

public class RemoteControl {
    Command[] onCommands;
    Command[] offComands;
    public RemoteControl(){
        onCommands = new Command[7];
        offComands = new Command[7];
        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++){
            onCommands[i] = noCommand;
            offComands[i] = noCommand;
        }
    }
    public void setCommand(int slot, )
}
