package ru.itis;

public class Main {

    public static void main(String[] args) {
	boolean b1 = false;
	boolean b2 = false;
        System.out.println(!(b1 || b2));
        System.out.println(!b1 && !b2);
        System.out.println(!b1 || b2);
        System.out.println(b1 || !!b2);
        System.out.println(!b1 && b2);
    }
}
