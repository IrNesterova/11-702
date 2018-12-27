package ru.itis;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


public class Main {

    public static void main(String[] args) {

        final int THREADS = 4;
        Random rnd = new Random();
        final int[] myArr = new int[1000];
        for (int i = 0; i < myArr.length; i++) {
            myArr[i] = (rnd.nextInt(10) + 1);
        }

        int pLength = myArr.length / THREADS;
        int begin = 0;

        if (myArr.length % THREADS > 0) {
            pLength++;
        }

        AtomicInteger result = new AtomicInteger(0);
        Thread[] thr = new Thread[THREADS];
        long rTime = System.nanoTime();

        for (int i = 0; i < THREADS; i++) {
            thr[i] = new Thread(new SumArray(myArr, begin, begin + pLength, result));
            thr[i].start();
            begin += pLength;
        }

        for (int i = 0; i < THREADS; i++) {
            try {
                thr[i].join();
            } catch (InterruptedException e) {
            }
        }

        rTime = System.nanoTime() - rTime;
        System.out.println("Threads: ");
        System.out.println(result.get());
        System.out.println(rTime);
        System.out.println(THREADS);

        rTime = System.nanoTime();
        int sum = 0;

        for (int i = 0; i < myArr.length; i++) {
            sum += myArr[i];
        }

        long rTime1 = System.nanoTime() - rTime;
        System.out.println("Main: ");
        System.out.println(sum);
        System.out.println(rTime1);

    }
}
