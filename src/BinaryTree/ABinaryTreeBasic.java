package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class ABinaryTreeBasic {


    public static void main(String[] args) {



        //Invert a binary tree.
        //MaxDepth of Binary Tree
        //Determine if a tree is balanced


    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public TreeNode invertTreeIterative(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if(Math.abs(leftDepth - rightDepth) > 1)
            return false;
        else{
            return isBalanced(root.left) && isBalanced(root.right);
        }

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return java.lang.Math.max(left_height, right_height) + 1;
        }
    }
}
