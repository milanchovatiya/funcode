package Heap;

import java.util.*;

class Pair{
    int key;
    int freq;
    public Pair(int key, int freq){
        this.key = key;
        this.freq = freq;
    }
}

public class KMostFrequent {


    public static void main(String[] args) {

        int arr[] = { 1, 1, 1, 2, 2, 3};

        List<Integer> resultList = topKFrequent(arr, 2);
        System.out.println(resultList);

    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        for(Integer i : nums){
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Pair> kFreq = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2){
                return Integer.compare(p1.freq, p2.freq);
            }
        });

        Set<Integer> keySet = freqMap.keySet();
        int index = 0;
        for(Integer i : keySet){
            int key = i;
            int freq = freqMap.get(i);
            if(index < k){
                kFreq.add(new Pair(key, freq));
            }
            else if(kFreq.peek().freq < freq){
                kFreq.remove();
                kFreq.add(new Pair(key, freq));
            }
            index++;
        }

        List<Integer> resultSet = new ArrayList<>();
        while(!kFreq.isEmpty()){
            resultSet.add(kFreq.remove().key);
        }
        return resultSet;
    }

}
