package ru.itis;

public class Main {

    public static void main(String[] args) {
        int array[] = {5, 2, 7, 9};

        TreeBstImpl<Integer> tree = new TreeBstImpl<>();

        for (int i = 0; i < array.length; i++) {
            tree.insert(array[i]);
        }
      //  tree.print();
        tree.remove(1);
        tree.printByLevels();
        tree.contains(5);
        System.out.println(tree.isBst());

    }
}
