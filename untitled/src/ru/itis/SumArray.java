package ru.itis;

import java.util.concurrent.atomic.AtomicInteger;

public class SumArray implements Runnable {
    private int begin;
    private int end;
    private int[]a;
    private AtomicInteger result;
    public SumArray(int[]a, int begin, int end, AtomicInteger result){
        this.result = result;
        this.a = a;
        this.begin = begin;
        if (a.length > end){
            this.end = end;
        } else {
            this.end = a.length;
        }
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = begin; i < end; i++){
            sum+=a[i];
        }
        result.addAndGet(sum);
    }
}
