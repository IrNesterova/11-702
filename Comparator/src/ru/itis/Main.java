package ru.itis;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(123);
        list.add(51);
        list.add(70);
        list.add(25);
        list.add(19);
        Collections.sort(list, new Comparator());
    }
}
