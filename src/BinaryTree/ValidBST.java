package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class ValidBST {


    public static void main(String[] args) {



        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        System.out.println(isValidBSTStack(root));

    }

    public static boolean isValidBSTStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double inorder = - Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // If next element in inorder traversal
            // is smaller than the previous one
            // that's not BST.
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
    public static boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        for(int i = 1; i < list.size(); i++){
            if(list.get(i) <= list.get(i - 1))
                return false;
        }
        return true;
    }

    public static void inorderTraversal(TreeNode node, List<Integer> list){
        if(node == null)
            return;
        inorderTraversal(node.left, list);
        list.add(node.val);
        inorderTraversal(node.right, list);
    }
}
