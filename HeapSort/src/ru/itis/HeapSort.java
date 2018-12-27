package ru.itis;

public class HeapSort {

    private int count;

    public int getCount(){
        return count;
    }

    public void heapSort(int[]array) {
        count = 0;
        int length = array.length;
        buildMaxHeap(array, length);
        for (int i = length - 1; i > 0; i--) {
            count ++;
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            maxHeapify(array, 1, i);
        }

    }

    public void buildMaxHeap(int[] array, int heapSize) {
        if (heapSize > array.length) {
            heapSize = array.length;
        }

        for (int i = heapSize / 2; i > 0; i--) {
            maxHeapify(array, i, heapSize);
        }
    }

    public void maxHeapify(int[] array, int index, int heapSize) {
        count++;
        int l = index * 2;
        int r = l + 1;
        int largest;

        if (l <= heapSize && array[l - 1] > array[index - 1]) {
            largest = l;
        } else {
            largest = index;
        }

        if (r <= heapSize && array[r - 1] > array[largest - 1]) {
            largest = r;
        }

        if (largest != index) {
            int temp = array[index - 1];
            array[index - 1] = array[largest - 1];
            array[largest - 1] = temp;
            maxHeapify(array, largest, heapSize);
        }
    }
}
