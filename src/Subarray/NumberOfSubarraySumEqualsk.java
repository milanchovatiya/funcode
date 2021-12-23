package Subarray;

import java.util.HashMap;

public class NumberOfSubarraySumEqualsk {


    public static void main(String[] args) {


//        Given an array of integers and an integer k, you
//        need to find the total number of continuous subarrays whose sum equals to k.


    }

    public int subarraySumBruteForce(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum=0;
            for (int end = start; end < nums.length; end++) {
                sum+=nums[end];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }

//    The idea behind this approach is as follows: If the cumulative sum(repreesnted by sum[i]
//            for sum upto ith
//    index) upto two indices is the same, the sum of the elements lying in between those indices
//    is zero. Extending the same thought further, if the cumulative sum upto two indices,
//    say i and j is at a difference of k i.e. if sum[i] - sum[j] = k, the
//    sum of elements lying between indices i and j is k.

    public int subarraySum(int[] nums, int k) {
        int sum = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];

            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }
        return count;
    }

}
