package Subarray;

import java.util.HashMap;

public class MaximumSubarray {


    public static void main(String[] args) {


//        Given an integer array nums, find the contiguous subarray
//                (containing at least one number) which has the
//        largest sum and return its sum.


    }
//    The catch here is that we have to take care of negative value.
    public int maxSubArray(int[] A) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (sum < 0)
                sum = A[i];
            else
                sum += A[i];
            if (sum > max)
                max = sum;
        }
        return max;
    }
}


