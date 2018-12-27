package ru.itis;

public class Main {

    public static void main(String[] args) {
        int array[] = {5, 1, 4, 2, 3, 4, 4, 2, 1, 4, 5, 3, 2, 1, 3, 4, 5, 4, 3};
        OptTree opt = new OptTree();
        opt.createTree(array, 6);
        System.out.println(opt.findOptTree(2));
    }
}
