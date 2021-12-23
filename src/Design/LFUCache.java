package Design;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;


//The trick is to use 3 data structures -
//One for storing the key value pair
//two for storing the frequencies for individual keys
//three for storing a linked hashset of values mapped with their respective frequencies.


public class LFUCache {
    HashMap<Integer, Integer> vals;
    HashMap<Integer, Integer> counts;
    HashMap<Integer, LinkedHashSet<Integer>> lists;
    int cap;
    int min = -1;
    public LFUCache(int capacity) {
        cap = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
        lists.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if(!vals.containsKey(key))
            return -1;
        int count = counts.get(key);
        counts.put(key, count+1);
        lists.get(count).remove(key);
        if(count==min && lists.get(count).size()==0)
            min++;
        if(!lists.containsKey(count+1))
            lists.put(count+1, new LinkedHashSet<>());
        lists.get(count+1).add(key);
        return vals.get(key);
    }

    public void put(int key, int value) {
        if(cap<=0)
            return;
        if(vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        }
        if(vals.size() >= cap) {
            int evit = lists.get(min).iterator().next();
            lists.get(min).remove(evit);
            vals.remove(evit);
        }
        vals.put(key, value);
        counts.put(key, 1);
        min = 1;
        lists.get(1).add(key);
    }

    public static void main(String[] args) {

        LFUCache cache = new LFUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.get(3);       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }

}

class OptimizedLFUCache {

    private Map<Integer, DoublyNode> cacheMap;
    private Map<Integer, DoublyLinkedList> frequencyDoublyList;
    private int capacity;

    public OptimizedLFUCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>();
        frequencyDoublyList = new HashMap<>();
    }

    public int get(int key) {
        if(capacity == 0) return -1;
        if (cacheMap.containsKey(key)) {
            DoublyNode currentNode = moveNodeToNextFrequency(key);
            return currentNode.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(capacity == 0) return;
        if (cacheMap.containsKey(key)) {
            DoublyNode currentNode = moveNodeToNextFrequency(key);
            currentNode.value = value;
        } else {
            if(cacheMap.size() == capacity) {
                int minFrequency = Collections.min(frequencyDoublyList.keySet());
                DoublyLinkedList leastFrequencyNode = frequencyDoublyList.get(minFrequency);
                DoublyNode lruNode = leastFrequencyNode.removeTail();
                cacheMap.remove(lruNode.key);
            }
            DoublyNode currentNode = new DoublyNode(key, value);
            frequencyDoublyList.computeIfAbsent(1, dl -> new DoublyLinkedList()).moveNodeToFront(currentNode);
            cacheMap.put(key, currentNode);
        }
    }

    private DoublyNode moveNodeToNextFrequency(int key) {
        DoublyNode currentNode = cacheMap.get(key);
        int currentFrequency = currentNode.frequency;
        DoublyLinkedList frequencyDl = frequencyDoublyList.get(currentFrequency);
        frequencyDl.removeNode(currentNode);
        if (frequencyDl.isEmpty()) {
            frequencyDoublyList.remove(currentFrequency);
        }
        currentFrequency++;
        frequencyDoublyList.computeIfAbsent(currentFrequency, dl -> new DoublyLinkedList()).moveNodeToFront(currentNode);
        currentNode.frequency = currentFrequency;
        return currentNode;
    }
}

class DoublyLinkedList {
    private DoublyNode head;
    private DoublyNode tail;

    public DoublyLinkedList() {
        head = new DoublyNode(-1, -1);
        tail = new DoublyNode(-1, -1);
        head.next = tail;
        tail.previous = head;
    }

    public void moveNodeToFront(DoublyNode currentNode) {
        currentNode.next = head.next;
        currentNode.previous = head;
        head.next.previous = currentNode;
        head.next = currentNode;
    }

    public boolean isEmpty() {
        return head.next == tail && tail.previous == head;
    }

    public DoublyNode removeTail() {
        DoublyNode tailNode = tail.previous;
        tailNode.previous.next = tail;
        tail.previous = tailNode.previous;
        return tailNode;
    }

    public void removeNode(DoublyNode currentNode) {
        currentNode.next.previous = currentNode.previous;
        currentNode.previous.next = currentNode.next;
    }
}

class DoublyNode {
    int key;
    int value;
    int frequency;
    DoublyNode previous;
    DoublyNode next;

    public DoublyNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.frequency = 1;
    }
}