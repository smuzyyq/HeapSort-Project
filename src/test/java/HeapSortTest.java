import algorithms.HeapSort;
import metrics.PerformanceTracker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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
    public void testHeapSort() {
        int[] arr = {12, 11, 13, 5, 6, 7};
        heapSort.sort(arr, "Array Size: " + arr.length);
        int[] expectedArr = {5, 6, 7, 11, 12, 13};

        for (int i = 0; i < arr.length; i++) {
            assertEquals(expectedArr[i], arr[i]);
        }
    }

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        heapSort.sort(arr, "Array Size: " + arr.length);

        assertEquals(0, arr.length);
    }

    @Test
    public void testSingleElementArray() {
        int[] arr = {5};
        heapSort.sort(arr, "Array Size: " + arr.length);

        assertEquals(1, arr.length);
        assertEquals(5, arr[0]);
    }

    @Test
    public void testArrayWithDuplicates() {
        int[] arr = {5, 7, 5, 3, 5, 7, 7};
        heapSort.sort(arr, "Array Size: " + arr.length);
        int[] expectedArr = {3, 5, 5, 5, 7, 7, 7};

        assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void testSortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        heapSort.sort(arr, "Array Size: " + arr.length);

        int[] expectedArr = {1, 2, 3, 4, 5};
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void testReverseSortedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        heapSort.sort(arr, "Array Size: " + arr.length);

        int[] expectedArr = {1, 2, 3, 4, 5};
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    public void testMetricsCSV() throws IOException {
        int[] arr = {12, 11, 13, 5, 6, 7};
        heapSort.sort(arr, "Array Size: " + arr.length);

        File file = new File("benchmark_metrics.csv");
        assertTrue(file.exists());

        try (Scanner scanner = new Scanner(file)) {
            assertTrue(scanner.hasNextLine());
        }
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
