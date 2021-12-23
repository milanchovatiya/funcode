package SlidingWindow;

import java.util.*;

public class MaxSlidingWindow {


    public static void main(String[] args) {

        MaxSlidingWindow sw = new MaxSlidingWindow();

        System.out.println(Arrays.asList(sw.maxSlidingWindowDeque(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
    }


    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int [] nums;

    public void clean_deque(int i, int k) {
        // remove indexes of elements not from sliding window
        if (!deq.isEmpty() && deq.getFirst() == i - k)
            deq.removeFirst();

        // remove from deq indexes of all elements
        // which are smaller than current element nums[i]
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])                           deq.removeLast();
    }

    public int[] maxSlidingWindowDeque(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        // init deque and output
        this.nums = nums;
        int max_idx = 0;
        for (int i = 0; i < k; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            // compute max in nums[:k]
            if (nums[i] > nums[max_idx]) max_idx = i;
        }
        int [] output = new int[n - k + 1];
        output[0] = nums[max_idx];

        // build output
        for (int i  = k; i < n; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            output[i - k + 1] = nums[deq.getFirst()];
        }
        return output;
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
