package ru.itis;

public class Main {

    public static void main(String[] args) {
	    SnakeInt snake = new TalkingSnake(new FlyingSnake(new Snake()));
	    System.out.println(snake.move());
    }
}
