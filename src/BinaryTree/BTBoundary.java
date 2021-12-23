package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTBoundary {


    public static void main(String[] args) {


//        Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root.
//          Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.
//
//          Left boundary is defined as the path from root to the left-most node.
//      Right boundary is defined as the path from root to the right-most node.
//      If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary.
//          Note this definition only applies to the input binary tree, and not applies to any subtrees.
//
//        The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists.
//          If not, travel to the right subtree. Repeat until you reach a leaf node.
//
//            The right-most node is also defined by the same way with left and right exchanged.


    }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        if(root == null)
            return res;
        if(root.left != null || root.right != null)
            res.add(root.val);
        if(root.left != null){
            leftBoundary(res, root);
            if(res.size() > 1)
                res.remove(res.size() - 1);
        }
        addLeaves(res, root);
        if(root.right != null){
            rightBoundary(stack, root);
            stack.pop();
            while(!stack.isEmpty())
                res.add(stack.pop());
        }
        return res;
    }

    public void leftBoundary(List<Integer> res, TreeNode root){
        TreeNode curr = root;
        while(curr != null){
            if(curr.left != null)
                curr = curr.left;
            else if(curr.right != null)
                curr = curr.right;
            else
                break;
            res.add(curr.val);
        }
    }

    public void addLeaves(List<Integer> res, TreeNode root){
        if(root.left == null && root.right == null){
            res.add(root.val);
            return;
        }
        if(root.left != null)
            addLeaves(res, root.left);
        if(root.right != null)
            addLeaves(res, root.right);
    }

    public void rightBoundary(Stack<Integer> stack, TreeNode root){
        TreeNode curr = root;
        while(curr != null){
            if(curr.right != null)
                curr = curr.right;
            else if(curr.left != null)
                curr = curr.left;
            else
                break;
            stack.push(curr.val);
        }
    }
}
