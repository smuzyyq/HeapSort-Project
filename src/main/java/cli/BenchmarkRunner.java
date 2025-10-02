package cli;

import org.openjdk.jmh.annotations.*;
import algorithms.HeapSort;
import java.util.concurrent.TimeUnit;

public class BenchmarkRunner {

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)  // Среднее время
    @OutputTimeUnit(TimeUnit.MILLISECONDS)  // Измеряем в миллисекундах
    public void testHeapSort_1000() {
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10000);
        }
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr, "Array Size: 1000");
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testHeapSort_5000() {
        int[] arr = new int[5000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10000);
        }
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr, "Array Size: 5000");
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testHeapSort_10000() {
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10000);
        }
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr, "Array Size: 10000");
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testHeapSort_50000() {
        int[] arr = new int[50000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10000);
        }
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr, "Array Size: 50000");
    }
}
