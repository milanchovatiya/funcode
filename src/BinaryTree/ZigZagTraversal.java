package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagTraversal {


    public static void main(String[] args) {


        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        for(List<Integer> list : zigzagLevelOrder(root)){
            System.out.println(list);
        }




    }
    static List<List<Integer>> ans = new ArrayList();

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return ans;

        zigzagLevelOrder(root, 0);

        return ans;
    }

    public static void zigzagLevelOrder(TreeNode root, int lev) {
        // Find or create new list for level
        List<Integer> l;
        if (ans.size() > lev)
            l = ans.get(lev);
        else {
            l = new ArrayList();
            ans.add(l);
        }
        System.out.println(root.val);

        // If we are on even levels, add to end
        // Otherwise, add to beginning
        if (lev % 2 == 0) {
            l.add(root.val);
        } else {
            l.add(0, root.val);
        }

        // Avoid a recursive call when not needed.
        // But always recurse in the same order: Left then Right
        if (root.left != null)
            zigzagLevelOrder(root.left, lev+1);

        if (root.right != null)
            zigzagLevelOrder(root.right, lev+1);

        return;
    }

    public static void LevelOrderUsingDFS(TreeNode root, int lev) {
        // Find or create new list for level
        List<Integer> l;
        if (ans.size() > lev)
            l = ans.get(lev);
        else {
            l = new ArrayList();
            ans.add(l);
        }
        //System.out.println(root.val);

        // If we are on even levels, add to end
        // Otherwise, add to beginning

        l.add(root.val);


        // Avoid a recursive call when not needed.
        // But always recurse in the same order: Left then Right
        if (root.left != null)
            LevelOrderUsingDFS(root.left, lev+1);

        if (root.right != null)
            LevelOrderUsingDFS(root.right, lev+1);

        return;
    }
}
