package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SymmetricTree {


    public static void main(String[] args) {



        //Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).


    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        List<String> leftList = new ArrayList<>();
        List<String> rightList = new ArrayList<>();
        leftTraversal(root.left, leftList);
        rightTraversal(root.right, rightList);
        if(leftList.size() != rightList.size())
            return false;
        System.out.println(leftList);
        System.out.println(rightList);
        for(int i = 0; i < leftList.size(); i++){
            if(!leftList.get(i).equals(rightList.get(i)))
                return false;
        }
        return true;
    }

    public void leftTraversal(TreeNode root, List<String> leftList){
        if(root != null){
            leftList.add(String.valueOf(root.val));
            leftTraversal(root.left, leftList);
            leftTraversal(root.right, leftList);
        }
        else{
            leftList.add("n");
        }
    }

    public void rightTraversal(TreeNode root, List<String> rightList){
        if(root != null){
            rightList.add(String.valueOf(root.val));
            rightTraversal(root.right, rightList);
            rightTraversal(root.left, rightList);
        }
        else{
            rightList.add("n");
        }
    }
}
