package metrics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PerformanceTracker {

    private long comparisons = 0;
    private long swaps = 0;
    private long recursiveCalls = 0;
    private long currentRecursionDepth = 0;
    private long startTimeNs;
    private long endTimeNs;

    public void startTimer() {
        startTimeNs = System.nanoTime();
    }

    public void stopTimer() {
        endTimeNs = System.nanoTime();
    }

    public long getElapsedTime() {
        return (endTimeNs - startTimeNs) / 100000;
    }

    public void incrementComparisons() {
        comparisons++;
    }

    public void incrementSwaps() {
        swaps++;
    }



    public void incrementRecursiveCalls() {
        recursiveCalls++;
    }



    public void writeMetricsToCSV(String filename, String arrayName) throws IOException {
        File file = new File(filename);
        boolean isNewFile = !file.exists();

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            if (isNewFile) {

                writer.println("ArrayName,Comparisons,Swaps,RecursiveCalls,Time(ms)");
            }


            writer.println(arrayName + "," + comparisons + "," + swaps + "," +
                    recursiveCalls  + "," + getElapsedTime());
        }
    }


    public long getComparisons() {
        return comparisons;
    }

    public long getSwaps() {
        return swaps;
    }



    public long getRecursiveCalls() {
        return recursiveCalls;
    }



    public long getCurrentRecursionDepth() {
        return currentRecursionDepth;
    }
}
