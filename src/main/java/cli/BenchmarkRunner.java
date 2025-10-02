package cli;

import algorithms.HeapSort;
import metrics.PerformanceTracker;

import java.io.IOException;

public class BenchmarkRunner {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 50000};
        HeapSort heapSort = new HeapSort();
        PerformanceTracker tracker = new PerformanceTracker();

        for (int size : sizes) {
            int[] arr = new int[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) (Math.random() * size);
            }

            String arrayName = "Array Size: " + size;

            tracker.startTimer();
            heapSort.sort(arr, arrayName);
            tracker.stopTimer();

            System.out.println("Array size: " + size + " | Time (ms): " + tracker.getElapsedTime());
            try {
                tracker.writeMetricsToCSV("benchmark_metrics.csv", arrayName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
