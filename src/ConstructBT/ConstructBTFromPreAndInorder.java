package ConstructBT;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ConstructBTFromPreAndInorder {


    public static void main(String[] args) {
        ConstructBTFromPreAndInorder constBT = new ConstructBTFromPreAndInorder();
        constBT.buildTree(new int[]{3,9,20,15,7}, new int[]{9, 3, 15, 20, 7});
        constBT.buildTreeIterative(new int[]{3,9,20,15,7}, new int[]{9, 3, 15, 20, 7});

    }

    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length == 0 || preorder.length == 0)
            return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(inorder, 0, inorder.length - 1, map, preorder);
    }

    public TreeNode helper(int[] inorder, int left, int right, Map<Integer, Integer> map,
                           int[] preorder){
        if(left > right)
            return null;
        int index = map.get(preorder[preIndex]);
        TreeNode root = new TreeNode(inorder[index]);
        this.preIndex++;

        root.left = helper(inorder, left, index - 1, map, preorder);
        root.right = helper(inorder, index + 1, right, map, preorder);

        return root;
    }

    public TreeNode buildTreeIterative(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if(n == 0){
            return null;
        }
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < n; i++) pos.put(inorder[i], i);
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);

        for (int i = 1; i < n; i++) {
            Integer value = preorder[i];
            TreeNode node = new TreeNode(value);
            if (pos.get(value) < pos.get(stack.peek().val)) stack.peek().left = node;
            else {
                TreeNode parent = null;
                while (!stack.isEmpty() && pos.get(value) > pos.get(stack.peek().val)) {
                    parent = stack.pop();
                }
                parent.right = node;
            }
            stack.push(node);
        }
        return root;
    }


}
