package iterator;

import java.util.Iterator;

/**
 * The Sequence interface represents a collection that can produce an iterator.
 */
public interface Sequence {
    Iterator<Integer> iterator();
}
