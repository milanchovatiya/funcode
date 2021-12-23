package TwoPointers;

public class SortColours {


    public static void main(String[] args) {



//        Given an array with n objects colored red, white or blue, sort them in-place
//        so that objects of the same color are adjacent, with the colors in the order red, white and blue.
//
//        Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

        //Dutch National Flag Problem

    }

//    Algorithm
//
//    Initialise the rightmost boundary of zeros : p0 = 0. During the algorithm execution nums[idx < p0] = 0.
//
//    Initialise the leftmost boundary of twos : p2 = n - 1. During the algorithm execution nums[idx > p2] = 2.
//
//    Initialise the index of current element to consider : curr = 0.
//
//    While curr <= p2 :
//
//    If nums[curr] = 0 : swap currth and p0th elements and move both pointers to the right.
//
//    If nums[curr] = 2 : swap currth and p2th elements. Move pointer p2 to the left.
//
//    If nums[curr] = 1 : move pointer curr to the right.
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p1 = 0, p2 = n - 1, curr = 0;
        while(curr <= p2){
            if(nums[curr] == 0){
                swap(nums, curr, p1);
                p1++;
                curr++;
            }
            else if(nums[curr] == 2){
                swap(nums, curr, p2);
                p2--;
            }
            else
                curr++;

        }
    }

    public void swap(int[] nums, int curr, int p1){
        int temp = nums[curr];
        nums[curr] = nums[p1];
        nums[p1] = temp;
    }
}
