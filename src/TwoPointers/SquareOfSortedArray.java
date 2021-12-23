package TwoPointers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SquareOfSortedArray {


    public static void main(String[] args) {


//        Given an array of integers A sorted in non-decreasing order,
//        return an array of the squares of each number, also in sorted non-decreasing order.


    }

    //We can use two pointers to read the positive and negative parts of the array -
    // one pointer j in the positive direction, and another i in the negative direction.
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        if(n == 0)
            return new int[0];
        if(n == 1)
            return new int[]{A[0] * A[0]};
        int[] ans = new int[n];
        int j = 0, k = 0;
        for(int i = 0; i < n; i++){
            if(A[i] >= 0){
                j = i;
                k = i - 1;
                break;
            }
        }
        int index = 0;
        while(k >= 0 && j < n){
            int a = A[k] * A[k];
            int b = A[j] * A[j];
            if(a <= b){
                ans[index] = a;
                k--;
            }
            else{
                ans[index] = b;
                j++;
            }

            index++;
        }
        if(k >= 0){
            while(k >= 0){
                ans[index] = A[k] * A[k];
                k--;
                index++;
            }
        }
        else{

            while(j < n){
                ans[index] = A[j] * A[j];
                j++;
                index++;
            }
        }

        return ans;
    }
}
