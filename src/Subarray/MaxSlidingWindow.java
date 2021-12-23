package Subarray;

import java.util.*;

public class MaxSlidingWindow {


    public static void main(String[] args) {

//        Given an array nums, there is a sliding window of size k which is moving from the very
//        left of the array to the very right. You can only see the k numbers in the window.
//        Each time the sliding window moves right by one position. Return the max sliding window.

        System.out.println(Arrays.asList(maxSlidingWindowPriorityQueue(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
    }
    public static int[] maxSlidingWindow(int[] a, int k) {
        int n = a.length;
        List<Integer> result = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        int l = 0;
        int r = 0;

        while(l <= n - k){
            for(int i = 0; i < k; i++){
                intList.add(a[l]);
                l++;
            }
            int max = Collections.max(intList);
            intList.clear();
            result.add(max);
            r++;
            l = r;
        }
        int[] resultArr = new int[result.size()];
        int index = 0;
        for(Integer i : result){
            resultArr[index] = i;
            index++;
        }
        return resultArr;

    }

    public static int[] maxSlidingWindowPriorityQueue(int[] nums, int k) {
        int len = nums.length;
        int[] result = new int[len - k + 1];
        if(nums.length == 0) return new int[0];
        Queue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2){
                return Integer.compare(i2, i1);
            }
        });

        for(int i = 0; i < k; i ++){
            queue.add(nums[i]);
        }
        result[0] = queue.peek();
        for(int i = k; i < len; i ++){
            queue.remove(nums[i - k]);
            queue.add(nums[i]);
            result[i - k + 1] = queue.peek();
        }

        return result;
    }
}
