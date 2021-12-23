package TwoPointers;

public class TrappingRainWater {


    public static void main(String[] args) {
//        Given n non-negative integers representing an elevation map where
//        the width of each bar is 1, compute how much water it is able to trap after raining.
//
//
//        The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
//        In this case, 6 units of rain water (blue section) are being trapped.



    }

    public int trap(int[] A) {
        int left=0;
        int right=A.length-1;
        int result = 0;
        int leftmax = 0;
        int rightmax = 0;
        while(left <= right){
            leftmax = Math.max(leftmax,A[left]);
            rightmax = Math.max(rightmax,A[right]);
            if(leftmax < rightmax){
                result += (leftmax-A[left]);       // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
                left++;
            }
            else{
                result += (rightmax-A[right]);
                right--;
            }
        }
        return result;
    }

//    Intuition
//
//    Do as directed in question. For each element in the array, we find the
//    maximum level of water it can trap after the rain, which is equal to the
//    minimum of maximum height of bars on both the sides minus its own height.
//
//    Algorithm
//
//    Initialize ans=0ans=0
//    Iterate the array from left to right:
//    Initialize \text{max\_left}=0max_left=0 and \text{max\_right}=0max_right=0
//    Iterate from the current element to the beginning of array updating:
//            \text{max\_left}=\max(\text{max\_left},\text{height}[j])max_left=max(max_left,height[j])
//    Iterate from the current element to the end of array updating:
//            \text{max\_right}=\max(\text{max\_right},\text{height}[j])max_right=max(max_right,height[j])
//    Add \min(\text{max\_left},\text{max\_right}) - \text{height}[i]min(max_left,max_right)−height[i] to \text{ans}ans
    public int trapBrute(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) { //Search the left part for max bar size
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j < size; j++) { //Search the right part for max bar size
                max_right = Math.max(max_right, height[j]);
            }
            ans += Math.min(max_left, max_right) - height[i];
        }
        return ans;
    }
}
