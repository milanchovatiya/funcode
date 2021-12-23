package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TraversalsIterative {


    public static void main(String[] args) {

    }
    public void inorderIterative(List<Integer> res, TreeNode root) {
        Stack<TreeNode> stack = new Stack();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
    }

    public void postOrderIterative(TreeNode root, List<Integer> res){
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(0, node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
    }

    public void preOrderIterative(TreeNode root, List<Integer> res){
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }

        }
    }
}
