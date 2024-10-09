package Strategy;

import java.util.Random;

public class SortingApplication {
    public static void main(String[] args) {
        int[] smallArray = generateRandomArray(30);
        int[] largeArray = generateRandomArray(100000);

        SortingContext context = new SortingContext();

        // Quick Sort
        context.setSortStrategy(new QuickSort());
        measureSortingTime(context, smallArray.clone(), "Quick Sort (Small)");
        measureSortingTime(context, largeArray.clone(), "Quick Sort (Large)");

        // Merge Sort
        context.setSortStrategy(new MergeSort());
        measureSortingTime(context, smallArray.clone(), "Merge Sort (Small)");
        measureSortingTime(context, largeArray.clone(), "Merge Sort (Large)");

        // Heap Sort
        context.setSortStrategy(new HeapSort());
        measureSortingTime(context, smallArray.clone(), "Heap Sort (Small)");
        measureSortingTime(context, largeArray.clone(), "Heap Sort (Large)");
    }

    private static void measureSortingTime(SortingContext context, int[] arr, String sortType) {
        long startTime = System.nanoTime();
        context.sort(arr);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println(sortType + " took " + duration + " nanoseconds.");
    }

    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        return rand.ints(size, 0, 100000).toArray();
    }
}
