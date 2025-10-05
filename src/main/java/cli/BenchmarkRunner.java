package cli;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import algorithms.HeapSort;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BenchmarkRunner {

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(BenchmarkRunner.class.getSimpleName())
                .forks(1)
                .warmupIterations(3)
                .measurementIterations(5)
                .build();
        new Runner(opt).run();
    }

    private static int[] generateRandomArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(1000000);
        }
        return arr;
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testHeapSort_1000() {
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++)
            arr[i] = (int) (Math.random() * 10000);
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr, "Array Size: 1000");
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testHeapSort_5000() {
        int[] arr = new int[5000];
        for (int i = 0; i < arr.length; i++)
            arr[i] = (int) (Math.random() * 10000);
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr, "Array Size: 5000");
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testHeapSort_10000() {
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++)
            arr[i] = (int) (Math.random() * 10000);
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr, "Array Size: 10000");
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testHeapSort_50000() {
        int[] arr = new int[50000];
        for (int i = 0; i < arr.length; i++)
            arr[i] = (int) (Math.random() * 10000);
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr, "Array Size: 50000");
    }
}
