import algorithms.HeapSort;
import metrics.PerformanceTracker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class HeapSortTest {

    private HeapSort heapSort;
    private PerformanceTracker tracker;

    @BeforeEach
    public void setUp() {
        heapSort = new HeapSort();
        tracker = new PerformanceTracker();
    }

    @Test
    public void testHeapSortWithDifferentArraySizes() throws IOException {
        int[] sizes = {1000, 5000, 10000, 50000};

        for (int size : sizes) {
            int[] arr = new int[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) (Math.random() * size);
            }

            long startTime = System.nanoTime();
            heapSort.sort(arr, "Array Size: " + size);
            long endTime = System.nanoTime();

            long duration = (endTime - startTime) / 1000000;

            System.out.println("Array size: " + size + ", Time: " + duration + " ms");

            for (int i = 0; i < arr.length - 1; i++) {
                assertTrue(arr[i] <= arr[i + 1]);
            }
        }
    }
}
