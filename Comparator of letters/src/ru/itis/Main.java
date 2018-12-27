package ru.itis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        ArrayList list = new ArrayList<String>();
        list.add("ababababa");
        list.add("abababababa");
        list.add("aa");
        list.sort(new Comparator());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
