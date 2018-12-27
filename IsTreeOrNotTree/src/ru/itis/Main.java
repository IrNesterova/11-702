package ru.itis;

public class Main {
    boolean isTree(int [][]arr){
        int edges = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = 1; j < arr.length; j++){
               edges++;
        }
        if (edges != arr.length - 1){
            return false;
        }

    }

    public static void main(String[] args) {
	// write your code here
    }
}
