package ru.itis;

public class SyntaxException extends RuntimeException{
    public SyntaxException(){
        super();
    }
    public SyntaxException(String message){
        super(message);
    }
}
