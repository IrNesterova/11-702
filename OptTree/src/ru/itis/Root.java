package ru.itis;

public class Root {
    private int parent;
    private int child;

    public Root(int parent){
        this.parent = parent;
        this.child = 0;
    }

    public void addChild(){
        child ++;
    }

    public int getChild(){
        return child;
    }


}
