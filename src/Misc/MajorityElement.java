package Misc;

import java.util.*;

public class MajorityElement {


    public static void main(String[] args) {

//Boyer-Moore Voting Algorithm Application

//        Given an array of size n, find the majority element.
//                The majority element is the element that appears more than ⌊ n/2 ⌋ times.
        // Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
        MajorityElement me = new MajorityElement();
        me.majorityElementII(new int[]{1,1,1,3,3,2,2,2});

    }
    //Approach 1 use Subarray


    //Approach 2
    //If the elements are sorted in monotonically increasing (or decreasing) order,
    // the majority element can be found at the middle
    public int majorityElementSorting(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    //Approach 3

    //Essentially, what Boyer-Moore does is look for a suffix sufsuf of nums where suf[0]suf[0]
    // is the majority element in that suffix. To do this, we maintain a count, which is incremented
    // whenever we see an instance of our current candidate for majority element and decremented whenever
    // we see anything else. Whenever count equals 0, we effectively forget about everything in nums up
    // to the current index and consider the current number as the candidate for majority element.
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int majorElement = nums[0], count = 1;

        for(int i = 1; i < nums.length; i++){
            if(count == 0){

                majorElement = nums[i];
                count = 1;
                continue;
            }

            if(nums[i] == majorElement){
                count++;
            }
            else{
                count--;
            }

        }

        return majorElement;

    }



//    Idea: There are at most 2 elements that appear more than floor(n / 3) times.
//    Similar to Majority Element, but keep track of 2 candidates.

    public List<Integer> majorityElementII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        int candidate1 = nums[0]; // Random initialization
        int count1 = 0;
        int candidate2 = nums[0];
        int count2 = 0;
        for (int currentElem : nums) {
            if (currentElem == candidate1) {
                count1++;
            } else if (currentElem == candidate2) {
                count2++;
            } else if (count1 == 0) { // currentElem != both candidate1 and candidate2
                candidate1 = currentElem; // currentElem is the new candidate1; don't decrement count2
                count1++;
            } else if (count2 == 0) {
                candidate2 = currentElem; // currentElem is the new candidate2; don't decrement count1
                count2++;
            } else { // Decrement both count1 and count2
                count1--;
                count2--;
            }
        }

        // Validation
        count1 = 0;
        count2 = 0;
        for (int currentElem : nums) {
            if (currentElem == candidate1) {
                count1++;
            } else if (currentElem == candidate2) {
                count2++;
            }
        }

        List<Integer> result = new ArrayList<>();
        if (count1 > nums.length / 3) {
            result.add(candidate1);
        }

        if (count2 > nums.length / 3) {
            result.add(candidate2);
        }

        return result;
    }
}
