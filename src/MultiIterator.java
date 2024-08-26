/*
 * Copyright
 * Andrei Razhkou
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class MultiIterator {

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1,2,3);
        List<Integer> b = Arrays.asList(4,5,6);
    }

    static class MultiIteratorInner<T> implements Iterator<T> {
        private final Iterator<T> a;
        private final Iterator<T> b;

        public MultiIteratorInner(Iterator<T> a, Iterator<T> b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void remove() {
            a.remove();
        }

        @Override
        public boolean hasNext() {
            return a.hasNext() || b.hasNext();
        }

        @Override
        public T next() {
            return a.hasNext() ? a.next() : b.hasNext() ? b.next() : null;
        }
    }
}