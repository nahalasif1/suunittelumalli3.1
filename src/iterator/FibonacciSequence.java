
package iterator;

import java.util.Iterator;

/**
 * FibonacciSequence acts as a pseudo-collection that provides an iterator
 * for generating Fibonacci numbers on demand.
 */
public class FibonacciSequence implements Sequence {
    private final int limit; // Number of Fibonacci numbers to generate

    /**
     * Constructor to create a FibonacciSequence with a given limit.
     * @param limit The number of Fibonacci numbers to generate.
     */
    public FibonacciSequence(int limit) {
        this.limit = limit;
    }

    /**
     * Creates and returns an iterator for the Fibonacci sequence.
     * @return An instance of FibonacciIterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(limit);
    }
}
