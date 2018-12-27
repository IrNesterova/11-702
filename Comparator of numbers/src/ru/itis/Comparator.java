package ru.itis;

public class Comparator implements java.util.Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        int value1 = 0;
        int value2 = 0;
        int first = o1.intValue();
        int second = o2.intValue();
        return getValue(first)-getValue(second);
    }


    public int getValue(int a) {
        int value = 0;
        if(a==0)
            return 1;
        while (a != 0) {
            if (value % 2 == 1) {
                value++;
            } else
                value--;
            a = a / 10;
        }
        return Math.abs(value);
    }
}
