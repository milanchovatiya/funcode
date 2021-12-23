package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindInorderSuccessor {


    public static void main(String[] args) {


//        Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
//
//                The successor of a node p is the node with the smallest key greater than p.val


    }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        int prev = Integer.MIN_VALUE;
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prev == p.val){
                return root;
            }
            prev = root.val;
            root = root.right;
        }
        return null;
    }
}
