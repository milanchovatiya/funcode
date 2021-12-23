package AmazonOA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Assert;
import org.junit.Test;

public class SongPairProblem {
    private class Pair{
        int a;
        int b;
        public Pair(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object obj) {
            Pair p2 = (Pair) obj;
            return (this.a == p2.a && this.b == p2.b) ||
                    (this.b == p2.a && this.a == p2.b);
        }
    }

    @Test
    public void SongPairProblemTest() {
        numPairsDivisibleBy60(new int[]{30,20,150,100,40});

    }

    public int numPairsDivisibleBy60(int[] time) {
        int remainders[] = new int[60];
        int count = 0;
        for(int i = 0; i < time.length; i++) {
            time[i] = time[i] % 60;
        }

        for (int t: time) {
            if (t == 0) { // check if a%60==0 && b%60==0
                count += remainders[0];
            } else { // check if a%60+b%60==60
                count += remainders[60 - t];
            }
            remainders[t]++; // remember to update the remainders
        }
        return count;
    }

    public List<Pair> twoSum(int[] nums, int target) {
        List<Pair> pairList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                Pair newPair = new Pair(nums[i], complement);
                if(!pairList.contains(newPair)) {
                    pairList.add(newPair);
                }
            }
        }
        return pairList;
    }

}
