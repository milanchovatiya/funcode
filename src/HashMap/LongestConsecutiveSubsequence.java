package HashMap;

import java.util.HashSet;

public class LongestConsecutiveSubsequence {
//    Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
//
//    You must write an algorithm that runs in O(n) time.
//
//
//
//    Example 1:
//
//    Input: nums = [100,4,200,1,3,2]
//    Output: 4
//    Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
//    Example 2:
//
//    Input: nums = [0,3,7,2,5,8,4,6,0,1]
//    Output: 9

    public int longestConsecutiveBruteForce(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        if(nums.length == 1){
            return 1;
        }
        for(Integer num : nums) {
            set.add(num);
        }
        int globalseq = 0;
        for(Integer num : nums) {
            num = num + 1;
            int maxSeq = 1;
            if(set.contains(num)) {
                while(set.contains(num)) {
                    num = num + 1;
                    maxSeq++;

                }
            }
            globalseq = Math.max(globalseq, maxSeq);
        }

        return globalseq;
    }

    public int longestConsecutiveSolution2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();
        if(nums.length == 1){
            return 1;
        }
        for(Integer num : nums) {
            set.add(num);
        }
        int globalseq = 0;
        for(Integer num : nums) {
            num = num + 1;
            int maxSeq = 1;
            if(set.contains(num) && !visited.contains(num)) {
                while(set.contains(num)) {
                    visited.add(num);
                    num = num + 1;
                    maxSeq++;
                }
            }
            globalseq = Math.max(globalseq, maxSeq);
        }

        return globalseq;
    }

    public int longestConsecutiveBestSolution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();
        if(nums.length == 1){
            return 1;
        }
        for(Integer num : nums) {
            set.add(num);
        }
        int globalseq = 0;
        for(Integer num : nums) {
            if(!set.contains(num - 1)) {
                num = num + 1;
                int maxSeq = 1;
                if(set.contains(num)) {
                    while(set.contains(num)) {
                        num = num + 1;
                        maxSeq++;
                    }
                }
                globalseq = Math.max(globalseq, maxSeq);
            }
        }

        return globalseq;
    }
}
