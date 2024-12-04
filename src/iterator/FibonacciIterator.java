package iterator;

import java.util.Iterator;

/**
 * FibonacciIterator handles the logic for iterating through the Fibonacci sequence.
 * It maintains the state for generating Fibonacci numbers.
 */
public class FibonacciIterator implements Iterator<Integer> {
    private int current = 1; // Current Fibonacci number
    private int prev = 0;    // Previous Fibonacci number
    private final int limit; // Limit to the number of elements in the sequence
    private int count = 0;   // Tracks how many numbers have been generated

    /**
     * Constructor to create a FibonacciIterator with a given limit.
     * @param limit The number of Fibonacci numbers to generate.
     */
    public FibonacciIterator(int limit) {
        this.limit = limit;
    }

    /**
     * Indicates if there are more elements in the sequence to generate.
     * @return True if the count is less than the limit, false otherwise.
     */
    @Override
    public boolean hasNext() {
        return count < limit;
    }

    /**
     * Generates the next Fibonacci number in the sequence.
     * @return The next Fibonacci number.
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more elements in the sequence.");
        }
        int nextValue = current + prev;
        prev = current;
        current = nextValue;
        count++;
        return prev;
    }
}

