package TwoPointers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveElementInPlace {


    public static void main(String[] args) {
        removeElement(new int[]{0,1,2,2,3,4,0,2}, 2);

//        Given an array nums and a value val, remove all instances of that value in-place and return the new length.
//                The order of elements can be changed. It doesn't matter what you leave beyond the new length.


    }

//    When nums[j]nums[j] equals to the given value, skip this element by incrementing j. As long as nums[j] \neq valnums[j]
//            
//            ​
//            =val, we copy nums[j] to nums[i] and increment both indexes at the same time.
//    Repeat the process until jj reaches the end of the array and the new length is ii.
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
