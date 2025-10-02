import algorithms.HeapSort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HeapSortTest {

    private HeapSort heapSort;

    @BeforeEach
    public void setUp() {
        heapSort = new HeapSort();
    }

    @Test
    public void testHeapSort() {
        int[] arr = {12, 11, 13, 5, 6, 7};
        heapSort.sort(arr);
        int[] expectedArr = {5, 6, 7, 11, 12, 13};

        for (int i = 0; i < arr.length; i++) {
            assertTrue(arr[i] == expectedArr[i]);
        }
    }

    @Test
    public void testMetricsCSV() throws IOException {
        int[] arr = {12, 11, 13, 5, 6, 7};
        heapSort.sort(arr);

        File file = new File("metrics.csv");
        assertTrue(file.exists());

        try (Scanner scanner = new Scanner(file)) {
            assertTrue(scanner.hasNextLine());
        }
    }
}
