package ru.itis;

import java.util.LinkedList;

public class Token {
    public static final int EPSILON = 0;
    public static final int plusminus = 1;
    public static final int multdiv = 2;
    public static final int raised = 3;
    public static final int function = 4;
    public static final int openbracket = 5;
    public static final int closebraket = 6;
    public static final int number = 7;
    public static final int variable = 8;
    public final int token;
    public final String sequence;
    public final int pos;

    public Token(int token, String sequence, int pos){
        super();
        this.token = token;
        this.sequence = sequence;
        this.pos = pos;
    }
}
