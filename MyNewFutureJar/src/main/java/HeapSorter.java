public class HeapSorter {
    private int count;

    public int getCount() {
        return count;
    }

    public void sort(Integer[] arr) {
        count = 0;
        int n = arr.length;

        //creating a max heap

        for (int j = n / 2 - 1; j >= 0; j--) {
            heapify(arr, j, n);
        }

        // sorting a max heap

        for (int i = n - 1; i >= 0; i--) {
            count++;
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }
    }

    private void heapify(Integer[] arr, int i, int n) {
        count++;
        int largest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        if (left < n) {
            if (arr[largest] < arr[left]) {
                largest = left;
            }
        }
        if (right < n) {
            if (arr[largest] < arr[right]) {
                largest = right;
            }
        }
        if (largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            heapify(arr, largest, n);
        }
    }
}