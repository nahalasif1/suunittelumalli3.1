package iterator;

import java.util.Iterator;

/**
 * Main class to demonstrate the functionality of the Fibonacci sequence generator.
 */
public class Main {
    public static void main(String[] args) {
        // Create a Fibonacci sequence to generate the first 10 Fibonacci numbers.
        FibonacciSequence sequence = new FibonacciSequence(10);

        // Get the iterator for the sequence.
        Iterator<Integer> iterator = sequence.iterator();

        // Iterate through and print the Fibonacci numbers.
        System.out.println("First 10 Fibonacci numbers:");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}
