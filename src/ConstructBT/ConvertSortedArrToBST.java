package ConstructBT;

public class ConvertSortedArrToBST {


    public static void main(String[] args) {




        //Given an array where elements are sorted in ascending order, convert it to a height balanced BST.


    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;
        TreeNode root = createBST(nums, 0, nums.length - 1);
        return root;
    }

    public TreeNode createBST(int[] nums, int start, int end){
        if(end < start)
            return null;
        if(end == start)
            return new TreeNode(nums[start]);
        if(end - start == 1){
            TreeNode left = new TreeNode(nums[start]);
            TreeNode root = new TreeNode(nums[end]);
            root.left = left;
            return root;
        }
        int mid = (start + end) / 2;
        System.out.println(mid);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createBST(nums, start, mid - 1);
        root.right = createBST(nums, mid + 1, end);

        return root;
    }
}
