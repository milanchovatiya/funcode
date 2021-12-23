package Design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;



//You have an infinite number of stacks arranged in a row and numbered (left to right) from 0, each of the stacks has the same maximum capacity.
//
//        Implement the DinnerPlates class:
//
//        DinnerPlates(int capacity) Initializes the object with the maximum capacity of the stacks.
//        void push(int val) pushes the given positive integer val into the leftmost stack with size less than capacity.
//        int pop() returns the value at the top of the rightmost non-empty stack and removes it from that stack, and returns -1 if all stacks are empty.
//        int popAtStack(int index) returns the value at the top of the stack with the given index and removes it from that stack, and returns -1 if the stack with that given index is empty.

public class DinnerPlateStacks {
    Map<Integer, Stack<Integer>> map;
    int cap;
    int curr;
    int last;
    int count;

    public DinnerPlateStacks(int capacity) {
        cap = capacity;
        curr = 0; //where to push element
        last = 0; //where to pop element
        count = 0; //number of elements
        map = new HashMap<>();
        map.put(curr, new Stack<>());
    }

    public void push(int val) {
        //do some preprocessing to update current index
        while(map.containsKey(curr) && map.get(curr).size()==cap){
            curr++;
        }
        if(!map.containsKey(curr)){
            map.put(curr, new Stack<>());
        }
        map.get(curr).push(val);
        last = Math.max(last, curr);
        count++;
    }

    public int pop() {
        if(count==0) return -1;
        while(last>=0 && map.get(last).isEmpty()){
            last--;
        }
        count--;
        curr=Math.min(curr, last);
        return map.get(last).pop();
    }

    public int popAtStack(int index) {
        if(!map.containsKey(index) || map.get(index).isEmpty()){
            return -1;
        }
        count--;
        curr=Math.min(curr, index);
        return map.get(index).pop();
    }
}
