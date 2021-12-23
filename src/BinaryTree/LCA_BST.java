package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LCA_BST {


    public static void main(String[] args) {



        //Find LCA in a BST


    }
    TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        findLCA(root, p, q);
        return lca;

    }

    public void findLCA(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return;
        if(p.val == root.val){
            lca = p;
            return;
        }
        if(q.val == root.val){
            lca = q;
            return;
        }
        if(p.val < root.val && q.val < root.val){
            findLCA(root.left, p, q);
        }
        else if(p.val > root.val && q.val > root.val){
            findLCA(root.right, p, q);
        }
        else{
            lca = root;
            return;
        }
    }

    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {

        // Value of p
        int pVal = p.val;

        // Value of q;
        int qVal = q.val;

        // Start from the root node of the tree
        TreeNode node = root;

        // Traverse the tree
        while (node != null) {

            // Value of ancestor/parent node.
            int parentVal = node.val;

            if (pVal > parentVal && qVal > parentVal) {
                // If both p and q are greater than parent
                node = node.right;
            } else if (pVal < parentVal && qVal < parentVal) {
                // If both p and q are lesser than parent
                node = node.left;
            } else {
                // We have found the split point, i.e. the LCA node.
                return node;
            }
        }
        return null;
    }
}
