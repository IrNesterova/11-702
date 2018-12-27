package ru.itis;

public class TalkingSnake extends Decorator {
    public TalkingSnake(SnakeInt snake) {
        super(snake);
    }
    public String talking(){
        return "Sssss-shaasssss";
    }

    @Override
    public String move() {
        return super.move() + talking();
    }
}
