package ConstructBT;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromPostAndInorder {


    public static void main(String[] args) {
        //Given inorder and postorder traversal of a tree, construct the binary tree.

    }

    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0)
            return null;
        this.postIndex = postorder.length - 1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(inorder, 0, inorder.length - 1, map, postorder);
    }

    public TreeNode helper(int[] inorder, int left, int right, Map<Integer, Integer> map,
                           int[] postorder){
        if(left > right)
            return null;
        int index = map.get(postorder[postIndex]);
        TreeNode root = new TreeNode(inorder[index]);
        this.postIndex--;
        root.right = helper(inorder, index + 1, right, map, postorder);
        root.left = helper(inorder, left, index - 1, map, postorder);

        return root;
    }

}
