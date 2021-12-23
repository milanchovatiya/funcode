package Stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class MaxFreqStack {


    public static void main(String[] args) {
        //[5,7,5,7,4,5]

        //Group Stack
        // 1 -> 4,7,5
        // 2 -> 7, 5
        // 3 -> 5


    }
}

class FreqStack {
    HashMap<Integer, Integer> freqMap;
    HashMap<Integer, Stack<Integer>> group;
    int maxFreq;

    public FreqStack() {
        freqMap = new HashMap<>();
        group = new HashMap<>();
    }

    public void push(int x) {
        int f = freqMap.getOrDefault(x, 0) + 1;
        freqMap.put(x, f);
        if (f > maxFreq)
            maxFreq = f;
        int freq = freqMap.get(x);
        if(group.containsKey(freq)){
            Stack<Integer> stack = group.get(freq);
            stack.push(x);
        }
        else{
            Stack<Integer> stack = new Stack<>();
            stack.push(x);
            group.put(freq, stack);
        }
    }
    public int pop() {
        int x = group.get(maxFreq).pop();
        freqMap.put(x, freqMap.get(x) - 1);
        if (group.get(maxFreq).size() == 0)
            maxFreq--;
        return x;
    }
}


