package Design;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
        Iterator<Integer> iterator;
        private boolean hasPeeked;
        private int peekedElement;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (!hasPeeked) {
                peekedElement = iterator.next();
                hasPeeked = true;
            }
            return peekedElement;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (!hasPeeked) {
                return iterator.next();
            }
            int result = peekedElement;
            hasPeeked = false;
            return result;
        }

        @Override
        public boolean hasNext() {
            return hasPeeked || iterator.hasNext();
        }

    public static void main(String[] args) {

    }


}
