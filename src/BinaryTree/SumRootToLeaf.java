package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeaf {


    public static void main(String[] args) {




//        Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
//
//                An example is the root-to-leaf path 1->2->3 which represents the number 123.
//
//        Find the total sum of all root-to-leaf numbers.
//
//                Note: A leaf is a node with no children


    }
    List<String> list = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        int sum = 0;
        for(int i = 0; i < list.size(); i++){
            sum += Integer.parseInt(list.get(i));
        }
        return sum;
    }

    public void helper(TreeNode root, StringBuilder sb){
        sb.append(root.val);
        if(root.left == null && root.right == null){
            list.add(sb.toString());
        }
        if(root.left != null)
            helper(root.left, sb);
        if(root.right != null)
            helper(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
