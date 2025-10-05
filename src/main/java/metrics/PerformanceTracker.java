package metrics;

import java.io.*;

public final class PerformanceTracker {
    private long comparisons, swaps, accesses, allocations;
    private long startNs, elapsedNs;

    public void start() { startNs = System.nanoTime(); }
    public void stop()  { elapsedNs += System.nanoTime() - startNs; }

    public void cmp() { comparisons++; }
    public void swap() { swaps++; accesses += 4; } // 2 reads + 2 writes
    public void access(int count) { accesses += count; }
    public void alloc(long bytes) { allocations += bytes; }

    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public long getAccesses() { return accesses; }
    public long getAllocations() { return allocations; }
    public long getElapsedNs() { return elapsedNs; }

    public static void ensureCsvHeader(File f) throws IOException {
        boolean newFile = f.createNewFile();
        if (newFile || f.length() == 0) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(f, true))) {
                pw.println("algo,input,dist,n,trial,time_ns,comparisons,swaps,accesses,alloc_bytes");
            }
        }
    }

    public void appendCsv(File f, String algo, String inputName, String dist, int n, int trial) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(f, true))) {
            pw.printf("%s,%s,%s,%d,%d,%d,%d,%d,%d,%d%n",
                    algo, inputName, dist, n, trial, elapsedNs, comparisons, swaps, accesses, allocations);
        }
    }
}