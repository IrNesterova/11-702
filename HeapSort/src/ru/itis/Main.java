package ru.itis;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main extends HeapSort {

    public static void sortMass() throws IOException {
        HeapSort hs = new HeapSort();
        int array[] = new int[2];
        hs.heapSort(array);
    }
}
