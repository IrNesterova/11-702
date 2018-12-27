package ru.itis;

public class Decorator implements SnakeInt {
    SnakeInt snakeInt;
    @Override
    public String move() {
        return snakeInt.move();
    }
    public Decorator(SnakeInt snake){
        snakeInt = snake;
    }

}
