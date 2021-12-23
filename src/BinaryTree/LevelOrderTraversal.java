package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LevelOrderTraversal {


    public static void main(String[] args) {




        //Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).


    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root != null)
            leverOrderTraversal(root, res, 0);
        return res;
    }

    public void leverOrderTraversal(TreeNode root, List<List<Integer>> res, int level){
        List<Integer> temp;
        if(res.size() < level + 1){
            temp = new ArrayList<>();
            res.add(temp);
        }
        else{
            temp = res.get(level);
        }
        temp.add(root.val);

        if(root.left != null){
            leverOrderTraversal(root.left, res, level + 1);
        }
        if(root.right != null){
            leverOrderTraversal(root.right, res, level + 1);
        }
    }
}
