package BinaryTree;

public class DiameterOfBT {


    public static void main(String[] args) {




//        Given a binary tree, you need to compute the length of the diameter of the tree.
//                The diameter of a binary tree is the length of the longest path between any two
//        nodes in a tree. This path may or may not pass through the root.

    }
    int diameter = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        if(depth(root.left) + depth(root.right) > diameter){
            diameter = depth(root.left) + depth(root.right);
        }
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return diameter;
    }

    public int depth(TreeNode root){
        if(root == null)
            return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}
