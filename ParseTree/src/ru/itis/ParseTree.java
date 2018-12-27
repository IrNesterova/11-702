package ru.itis;

public class ParseTree {
    private String s;
    private ParseTree left, right;

    public ParseTree(){
        s = StdIn.readString();
        if (s.equals("+") || s.equals("*") || s.equals("-") || s.equals("/")){
            left = new ParseTree();
            right = new ParseTree();
        }
    }

    public int eval() {
        if      (s.equals("+")) return left.eval() + right.eval();
        else if (s.equals("*")) return left.eval() * right.eval();
        else                    return Integer.parseInt(s);
    }


    public String toString(){
        if (s.equals("+") || s.equals("*")){
            return s + " " + left + " " + right;
        } else {
            return s;
        }
    }
}
