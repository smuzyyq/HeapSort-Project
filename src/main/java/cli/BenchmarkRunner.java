package cli;

import algorithms.HeapSort;
import metrics.PerformanceTracker;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) throws Exception {
        int[] sizes = {100, 1_000, 10_000, 100_000};
        int trials = 5;
        String dist = "random";
        String algo = "HeapSort";

        for (String a : args) {
            if (a.startsWith("--sizes="))  sizes  = parseSizes(a.substring(8));
            else if (a.startsWith("--trials=")) trials = Integer.parseInt(a.substring(9));
            else if (a.startsWith("--dist="))   dist   = a.substring(7);
        }

        File csvDir = new File("docs/csv");
        csvDir.mkdirs();
        File csv = new File(csvDir, "metrics.csv");

        try (PrintWriter pw = new PrintWriter(new FileWriter(csv, false))) {
            pw.println("algo,input,dist,n,trial,time_ns,comparisons,swaps,accesses,alloc_bytes");
        }

        Random rnd = new Random(42);
        for (int n : sizes) {
            for (int t = 1; t <= trials; t++) {
                int[] arr = generate(n, dist, rnd);
                String inputName = algo + "_n" + n;

                PerformanceTracker tracker = new PerformanceTracker();
                tracker.start();
                HeapSort.sort(arr, tracker);
                tracker.stop();

                if (!isSorted(arr)) throw new IllegalStateException("Not sorted: n=" + n);
                tracker.appendCsv(csv, algo, inputName, dist, n, t);
            }
        }

        System.out.println("Metrics saved to: " + csv.getAbsolutePath());
    }


    private static int[] parseSizes(String s) {
        String[] parts = s.split(",");
        int[] out = new int[parts.length];
        for (int i = 0; i < parts.length; i++) out[i] = Integer.parseInt(parts[i].trim());
        return out;
    }

    private static int[] generate(int n, String dist, Random rnd) {
        int[] a = new int[n];
        switch (dist) {
            case "sorted":
                for (int i = 0; i < n; i++) a[i] = i;
                break;
            case "reversed":
                for (int i = 0; i < n; i++) a[i] = n - i;
                break;
            case "nearly":
                for (int i = 0; i < n; i++) a[i] = i;
                // small random perturbations
                for (int k = 0; k < Math.max(1, n / 100); k++) {
                    int i = rnd.nextInt(n), j = rnd.nextInt(n);
                    int tmp = a[i]; a[i] = a[j]; a[j] = tmp;
                }
                break;
            default:
                for (int i = 0; i < n; i++) a[i] = rnd.nextInt();
        }
        return a;
    }

    private static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) if (a[i-1] > a[i]) return false;
        return true;
    }
}