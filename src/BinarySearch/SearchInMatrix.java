package BinarySearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SearchInMatrix {


    public static void main(String[] args) {

//        Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//
//        Integers in each row are sorted from left to right.
//        The first integer of each row is greater than the last integer of the previous row.


    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int nr = matrix.length;
        if(nr == 0 || matrix[0].length == 0)
            return false;
        int nc = matrix[0].length;

        for(int i = 0; i < nr; i++){
            if(target >= matrix[i][0] && target <= matrix[i][nc - 1])
                return binarySearch(matrix[i], target);
        }
        return false;
    }

    public boolean binarySearch(int[] nums, int k){
        int r = nums.length - 1;
        int l = 0;
        while(l <= r){
            int mid = (l + r) / 2;
            //System.out.println(mid);
            if(nums[mid] == k)
                return true;
            else if(nums[mid] < k)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return false;
    }
}
