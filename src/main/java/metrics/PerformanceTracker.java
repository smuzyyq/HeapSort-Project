package metrics;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PerformanceTracker {

    private long comparisons = 0;
    private long swaps = 0;
    private long heapifyCalls = 0;
    private long startTime;
    private long endTime;

    public void startTimer() {
        startTime = System.nanoTime();
    }

    public void stopTimer() {
        endTime = System.nanoTime();
    }

    public long getElapsedTime() {
        return endTime - startTime;
    }

    public void incrementComparisons() {
        comparisons++;
    }

    public void incrementSwaps() {
        swaps++;
    }

    public void incrementHeapifyCalls() {
        heapifyCalls++;
    }

    public void writeMetricsToCSV(String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println("Comparisons,Swaps,HeapifyCalls,Time(ms)");
            writer.println(comparisons + "," + swaps + "," + heapifyCalls + "," + getElapsedTime() / 1000000);
        }
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getSwaps() {
        return swaps;
    }

    public long getHeapifyCalls() {
        return heapifyCalls;
    }
}
