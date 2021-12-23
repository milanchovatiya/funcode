package Misc;

public class MissingNumber {


    public static void main(String[] args) {


        //Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.


    }

    public int missingNumberExtraSpace(int[] nums) {
        int[] temp = new int[nums.length + 1];
        for(int i = 0; i < temp.length; i++){
            temp[i] = -1;
        }
        for(int j = 0; j < nums.length; j++){
            temp[nums[j]] = 0;
        }
        for(int i = 0; i < temp.length; i++){
            if(temp[i] == -1)
                return i;
        }
        return 0;
    }
//    Gauss Algorithm
//    We can compute the sum of nums in linear time,
//    and by Gauss' formula, we can compute the sum of the first
//    nn natural numbers in constant time. Therefore, the number that
//    is missing is simply the result of Gauss' formula minus the sum of nums,
//    as nums consists of the first n natural numbers minus some number
    public int missingNumber(int[] nums) {
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }
}
