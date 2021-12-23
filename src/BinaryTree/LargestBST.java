package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LargestBST {


    public static void main(String[] args) {




//        Given a binary tree, find the largest subtree which is a Binary Search Tree (BST),
//          where largest means subtree with largest number of nodes in it.
//
//        Note:
//        A subtree must include all of its descendants.


    }
    // return array for each node:
    //     [0] --> min
    //     [1] --> max
    //     [2] --> largest BST in its subtree(inclusive)

    public int largestBSTSubtree(TreeNode root) {
        int[] ret = largestBST(root);
        return ret[2];
    }

    private int[] largestBST(TreeNode node){
        if(node == null){
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        int[] left = largestBST(node.left);
        int[] right = largestBST(node.right);
        if(node.val > left[1] && node.val < right[0]){
            return new int[]{Math.min(node.val, left[0]), Math.max(node.val, right[1]), left[2] + right[2] + 1};
        }else{
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left[2], right[2])};
        }
    }
}
