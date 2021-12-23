package Design;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ZigZagIterator{
    Iterator<Integer> iterator1;
    Iterator<Integer> iterator2;
    boolean isFirst;

    public static void main(String[] args) {

        //Given two 1d vectors, implement an iterator to return their elements alternately.
        //Given k vectors, implement an iterator to return their elements alternately.
           // Use Queue to store K iterators

    }

    public ZigZagIterator(List<Integer> v1, List<Integer> v2) {
        iterator1 = v1.iterator();
        iterator2 = v2.iterator();
        isFirst = true;
    }

    public int next() {
        int value;
        Iterator<Integer> iterator3;
        if(iterator1.hasNext() && iterator2.hasNext()){
            if(isFirst){
                isFirst = false;
                value = iterator1.next();
            }
            else    {
                isFirst = true;
                value = iterator2.next();
            }
        }
        else{
            iterator3 = iterator1.hasNext() ? iterator1 : iterator2;
            value = iterator3.next();
        }
        return value;
    }

    public boolean hasNext() {
        return iterator1.hasNext() || iterator2.hasNext();
    }
}

class ZigzagIteratorK {
    LinkedList<Iterator> list;
    public ZigzagIteratorK(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<Iterator>();
        if(!v1.isEmpty()) list.add(v1.iterator());
        if(!v2.isEmpty()) list.add(v2.iterator());
    }

    public int next() {
        Iterator poll = list.remove();
        int result = (Integer)poll.next();
        if(poll.hasNext()) list.add(poll);
        return result;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}
