package ru.itis;

import java.util.LinkedList;
import java.util.List;

public class Parser {
    LinkedList<Token> tokens;
    Token lookahead;

    public void parse(LinkedList<Token> tokens)
    {
        this.tokens = (LinkedList<Token>) tokens.clone();
        lookahead = this.tokens.getFirst();

        expression();

        if (lookahead.token != Token.EPSILON)
            throw new ParserException("Unexpected symbol %s found", lookahead);
    }

    private void nextToken()
    {
        tokens.pop();
        if (tokens.isEmpty())
            lookahead = new Token(Token.EPSILON, "", -1);
        else
            lookahead = tokens.getFirst();
    }

    private void expression(){
        signedTerm();
        sumOp();
    }

    private void sumOp(){
        if (lookahead.token == Token.plusminus){
            nextToken();
            term();
            sumOp();
        } else {
            // sum_Op ->EPSILON
        }
    }

    private void signedTerm(){
        if (lookahead.token == Token.plusminus){
            nextToken();
            term();
        } else {
            term();
        }
    }

    private void term(){
        factor();
        termOp();
    }

    private void termOp(){
        if (lookahead.token == Token.multdiv){
            nextToken();
            signedFactor();
            termOp();
        } else {

        }
    }

    private void signedFactor(){
        if (lookahead.token == Token.plusminus){
            nextToken();
            factor();
        } else {
            factor();
        }
    }

    private void factor(){
        argument();
        factorOp();
    }

    private void factorOp(){
        if (lookahead.token == Token.raised){
            nextToken();
            signedFactor();
        } else{
            //nextToken();
        }
    }

    private void argument(){
        if (lookahead.token == Token.function){
            nextToken();
            argument();
        } else if (lookahead.token == Token.openbracket){
            nextToken();
            expression();
            if (lookahead.token != Token.closebraket){
                throw new ParserException("OPEN AND CLOSING BRACKETS NOT FOUND TOGETHER");
            }
            nextToken();
        } else {
            value();
        }
    }
    private void value(){
        if (lookahead.token == Token.number){
            nextToken();
        } else if (lookahead.token == Token.variable){
            nextToken();
        } else {
            throw new ParserException("Unexpected symbol in value");
        }
    }

}

public Node(int first, int second){
    this.first = first;
    this.second = second;
}