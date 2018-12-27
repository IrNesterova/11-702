package ru.itis;

import java.util.LinkedHashMap;

public class Main {

    public static void main(String[] args) {
	    Analyzer analyzer = new Analyzer();
	    analyzer.analyze("X1:=200;X2:=2;X3:=X1/X2;");
	    LinkedHashMap linkedHashMap = analyzer.process("X1:=200;X2:=2;X3:=X1/X2;");
        System.out.println(linkedHashMap.toString());
    }
}
