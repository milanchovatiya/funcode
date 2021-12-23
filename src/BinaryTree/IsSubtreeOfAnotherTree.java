package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class IsSubtreeOfAnotherTree {


    public static void main(String[] args) {




//        Given two non-empty binary trees s and t, check whether tree t
//        has exactly the same structure and node values with a subtree of s.
//                A subtree of s is a tree consists of a node in s and all of
//        this node's descendants. The tree s could also be considered as a subtree of itself.


    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(s);
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node.val == t.val){
                if(isIdentical(node, t))
                    return true;
            }
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
        }
        return false;

    }

    public boolean isIdentical(TreeNode s, TreeNode t){
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(s);
        queue2.add(t);
        while(!queue1.isEmpty() && !queue2.isEmpty()){
            TreeNode node1 = queue1.remove();
            TreeNode node2 = queue2.remove();
            if(node1.val != node2.val)
                return false;
            if(node1.left != null)
                queue1.add(node1.left);
            if(node2.left != null)
                queue2.add(node2.left);
            if(node1.right != null)
                queue1.add(node1.right);
            if(node2.right != null)
                queue2.add(node2.right);
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
