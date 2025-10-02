package cli;

import algorithms.HeapSort;
import metrics.PerformanceTracker;

import java.io.IOException;

public class BenchmarkRunner {

    public static void main(String[] args) {
        int[] sizes;

        if (args.length > 0) {
            sizes = new int[args.length];
            for (int i = 0; i < args.length; i++) {
                sizes[i] = Integer.parseInt(args[i]);
            }
        } else {
            sizes = new int[]{100, 1000, 10000, 100000};
        }

        HeapSort heapSort = new HeapSort();
        PerformanceTracker tracker = new PerformanceTracker();

        for (int size : sizes) {
            int[] arr = new int[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) (Math.random() * size);
            }

            tracker.startTimer();
            heapSort.sort(arr);
            tracker.stopTimer();

            System.out.println("Array size: " + size + " | Time (ms): " + tracker.getElapsedTime());
            try {
                tracker.writeMetricsToCSV("benchmark_metrics.csv");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
