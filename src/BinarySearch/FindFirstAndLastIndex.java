package BinarySearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindFirstAndLastIndex {


    public static void main(String[] args) {

        int[] nums = {5,7,7,8,8,8};

        searchRange(nums, 8);
        System.out.println(getLeftIndex(nums, 8));
        System.out.println(getRightIndex(nums, 8));

    }
    private static int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }

        return lo;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

        return targetRange;
    }

    public static int getLeftIndex(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;

        while(l <= r){
            int k = (l + r) / 2;
            if(nums[k] == target || nums[k] > target)
                r = k - 1;
            else
                l = k + 1;
        }
        return l;
    }

    public static int getRightIndex(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;

        while(l <= r){
            int k = (l + r) / 2;
            if(nums[k] > target)
                r = k - 1;
            else
                l = k + 1;
        }
        return l - 1;
    }
}
