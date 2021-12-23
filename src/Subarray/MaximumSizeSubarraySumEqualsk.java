package Subarray;

import java.util.*;

public class MaximumSizeSubarraySumEqualsk {


    public static void main(String[] args) {


//        Given an array nums and a target value k,
//                find the maximum length of a subarray
//        that sums to k. If there isn't one, return 0 instead.


    }

    public int maxSubArrayLenBruteForce(int[] nums, int k) {
        if(nums.length == 0)
            return 0;
        int maxSizeYet = 0;
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum == k){
                    if(j - i + 1 > maxSizeYet){
                        maxSizeYet = j - i + 1;
                    }
                }
            }
        }

        return maxSizeYet;
    }

//    The Subarray stores the sum of all elements before index i as key,
//    and i as value. For each i, check not only the current sum but also
//            (currentSum - previousSum) to see if there is any that equals k,
//    and update max length.
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum == k)
                max = i + 1;
            else if (map.containsKey(sum - k))
                max = Math.max(max, i - map.get(sum - k));
            if (!map.containsKey(sum))
                map.put(sum, i);
        }
        return max;
    }
}
