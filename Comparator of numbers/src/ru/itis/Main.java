package ru.itis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    list.add(121212);
	    list.add(131456);
	    list.add(1111111);
	    list.add(512315);
        Collections.sort(list, new Comparator());
        System.out.print(list.toString());
    }
}
