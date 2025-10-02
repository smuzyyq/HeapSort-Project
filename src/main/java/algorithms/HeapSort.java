package algorithms;

import metrics.PerformanceTracker;

import java.io.IOException;

public class HeapSort {

    private PerformanceTracker tracker = new PerformanceTracker();

    private void heapify(int[] arr, int n, int i) {
        tracker.incrementRecursiveCalls();

        tracker.updateRecursionDepth(i);

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        tracker.incrementComparisons();

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        tracker.incrementComparisons();

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            tracker.incrementSwaps();
            heapify(arr, n, largest);
        }
    }

    public void sort(int[] arr, String arrayName) {
        tracker.startTimer();
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            tracker.incrementSwaps();
            heapify(arr, i, 0);
        }

        tracker.stopTimer();  // Остановка таймера
        try {
            tracker.writeMetricsToCSV("benchmark_metrics.csv", arrayName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] arr = {12, 11, 13, 5, 6, 7};

        System.out.println("Original array:");
        heapSort.printArray(arr);

        heapSort.sort(arr, "Array Size: " + arr.length);

        System.out.println("Sorted array:");
        heapSort.printArray(arr);
    }
}
