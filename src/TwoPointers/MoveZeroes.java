package TwoPointers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MoveZeroes {


    public static void main(String[] args) {
        moveZeroes(new int[]{5, 6, 0, 1, 3, 0, 12, 11, 10});



    }

    public static void moveZeroes(int[] nums) {
        int temp = 0;
        boolean isSet = false;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0 && !isSet){
                temp = i;
                isSet = true;
            }
            else if(nums[i] == 0 && isSet){
                continue;
            }
            else{
                swap(nums, i, temp);
                temp++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
