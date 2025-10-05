// src/main/java/algorithms/HeapSort.java
package algorithms;

import metrics.PerformanceTracker;

public final class HeapSort {
    private HeapSort() {}

    public static void sort(int[] a, PerformanceTracker t) {
        if (a == null || a.length < 2) return;
        int n = a.length;

        // build max-heap
        for (int i = n / 2 - 1; i >= 0; i--) heapify(a, n, i, t);

        // extract max
        for (int end = n - 1; end > 0; end--) {
            swap(a, 0, end, t);
            heapify(a, end, 0, t);
        }
    }

    private static void heapify(int[] a, int size, int i, PerformanceTracker t) {
        while (true) {
            int largest = i;
            int l = 2 * i + 1, r = 2 * i + 2;

            if (l < size) { t.cmp(); if (a[l] > a[largest]) largest = l; }
            if (r < size) { t.cmp(); if (a[r] > a[largest]) largest = r; }
            if (largest == i) return;

            swap(a, i, largest, t);
            i = largest;
        }
    }

    private static void swap(int[] a, int i, int j, PerformanceTracker t) {
        int tmp = a[i]; a[i] = a[j]; a[j] = tmp;
        t.swap();
    }
}
