package BinarySearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindSingleElementInSortedArray {


    public static void main(String[] args) {


//        Given a sorted array consisting of only integers where every element appears
//        twice except for one element which appears once. Find this single element that appears only once.


    }
    //The trick is to understand indices of equal values. If odd mid value is equal to (mid - 1) value
    // then the single element will be on the right side else on the left side.
    public int singleNonDuplicate(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (mid % 2 == 0)
                mid++; 			// make mid odd, only consider odd mid
            if (nums[mid - 1] != nums[mid])
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return nums[lo];
    }
}
