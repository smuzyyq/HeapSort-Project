# HeapSort Algorithm Implementation

## Description
This project implements the **HeapSort** algorithm in Java. HeapSort is a comparison-based sorting algorithm that works by converting the input array into a **heap** data structure and then extracting the largest (or smallest) element iteratively to produce a sorted array.

HeapSort uses a binary heap data structure and is often used in scenarios where sorting needs to be done with minimal additional memory usage, as it operates in **O(1)** extra space.

## Key Features
- **Time Complexity**: O(n log n) in the worst, best, and average cases.
- **Space Complexity**: O(1) (in-place sorting).
- **Stability**: Not stable.
- **Uses bottom-up heapify** for optimal performance.

## Project Structure
- `src/main/java/HeapSort.java` - Contains the implementation of the HeapSort algorithm.
- `src/test/java/HeapSortTest.java` - Contains unit tests for verifying the correctness of the algorithm.
- `pom.xml` - Maven build file to manage dependencies and project configuration.

## Testing
- Unit tests are located in the `src/test/java/HeapSortTest.java` file.
- The tests cover edge cases like empty arrays, single-element arrays, and arrays with duplicates.

## Complexity Analysis

### Time Complexity
- **Best Case**: O(n log n)  
  This occurs when the input array is already in a heap-like structure. Even though it’s already somewhat ordered, the heap operations still involve O(n log n) operations due to the nature of heapify and the way we build the heap and extract elements.

- **Average Case**: O(n log n)  
  On average, HeapSort performs approximately n log n comparisons and swaps. The input data may vary, but HeapSort guarantees that no matter how the array is ordered, it will perform in O(n log n) time.

- **Worst Case**: O(n log n)  
  In the worst case, HeapSort still performs in O(n log n) because it needs to build the heap and then perform n extractions, each of which involves log n operations.

### Space Complexity
- **Auxiliary Space**: O(1)  
  HeapSort is an in-place sorting algorithm, meaning it does not require additional memory for temporary arrays. All sorting is done within the input array itself.

- **Total Space**: O(1)  
  No additional storage is needed other than the input array.

### Stability
- HeapSort is **not stable**. This means that elements with equal values might not retain their original order after sorting. For example, if the array has two equal elements, one might come before the other after sorting, depending on the algorithm's internal workings.

---

## Edge Cases

The following edge cases are covered by unit tests:

- **Empty Arrays**: The algorithm should not attempt to sort an empty array and should return immediately.
- **Single-Element Arrays**: The algorithm should not alter a single-element array.
- **Arrays with Duplicates**: The algorithm handles arrays with duplicate elements correctly and sorts them as expected.
- **Sorted Arrays**: The algorithm should work efficiently with arrays that are already sorted.
- **Reverse-Sorted Arrays**: The algorithm correctly sorts arrays that are sorted in reverse order.

---

## Benchmarking and Performance

The **HeapSort** algorithm was benchmarked using **JMH (Java Microbenchmarking Harness)** for performance measurement. The performance was measured for different array sizes (1000, 5000, 10000, 50000), and the average time to sort each array was recorded.

The following tests were conducted:
- Sorting arrays of various sizes (1000, 5000, 10000, 50000 elements).
- Measuring the time taken for each array size.
- Recording the number of comparisons, swaps, memory allocations, recursive calls, and maximum recursion depth.

For detailed performance measurements, check the **CSV** file **`benchmark_metrics.csv`**, which contains:
- Array size.
- Number of comparisons.
- Number of swaps.
- Memory allocations.
- Recursive calls.
- Max recursion depth.
- Time in milliseconds.

---

