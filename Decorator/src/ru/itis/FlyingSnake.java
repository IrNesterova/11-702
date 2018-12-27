package ru.itis;

public class FlyingSnake extends Decorator {
    public FlyingSnake(SnakeInt snake) {
        super(snake);
    }
    public String flying(){
        return "I am flying!";
    }
    public String move(){
        return super.move() + flying();
    }
}
