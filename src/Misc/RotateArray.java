package Misc;

public class RotateArray {


    public static void main(String[] args) {


//        Given an array, rotate the array to the right by k steps, where k is non-negative.

    }
    public void rotateExtraSpace(int[] nums, int k) {
        int n = nums.length;
        if(k == 0)
            return;
        int[] temp = new int[n];
        for(int i = 0; i < n; i++){
            int newIndex = (i + k) % n;
            temp[newIndex] = nums[i];

        }
        for(int i = 0; i < n; i++){
            nums[i] = temp[i];
        }
    }
    //Using Cyclic Replacements
    public void rotateCyclicApproach(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
//    Original List                   : 1 2 3 4 5 6 7
//    After reversing all numbers     : 7 6 5 4 3 2 1
//    After reversing first k numbers : 5 6 7 4 3 2 1
//    After revering last n-k numbers : 5 6 7 1 2 3 4
    public void rotateReverse(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
