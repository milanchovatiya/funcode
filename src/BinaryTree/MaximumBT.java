package BinaryTree;

public class MaximumBT {


    public static void main(String[] args) {




//        Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

//          The root is the maximum number in the array.
//          The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
//          The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
//          Construct the maximum tree by the given array and output the root node of this tree.


    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return null;
        return constructTree(nums, 0, n - 1);
    }

    public TreeNode constructTree(int[] nums, int l, int h){
        if(l == h){
            return new TreeNode(nums[l]);
        }
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for(int i = l; i <= h; i++){
            if(nums[i] > max){
                maxIndex = i;
                max = nums[i];
            }
        }
        TreeNode newNode = new TreeNode(max);
        if(maxIndex - 1 >= l)
            newNode.left = constructTree(nums, l, maxIndex - 1);
        if(maxIndex + 1 <= h)
            newNode.right = constructTree(nums, maxIndex + 1, h);
        return newNode;
    }
}
