package BinaryTree;

import java.util.*;

public class VerticalOrderTraversal {


    public static void main(String[] args) {
//        Given a binary tree, return the vertical order traversal of its nodes' values.
//        (ie, from top to bottom, column by column).
//
//        If two nodes are in the same row and column, the order should be from left to right.

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

        for(List<Integer> list : verticalOrder(root)){
            System.out.println(list);
        }

    }
    //Algorithm

    //BFS, put node, col into queue at the same time
    //Every left child access col - 1 while right child col + 1
    //This maps node into different col buckets
    //Get col boundary min and max on the fly
    //Retrieve result from cols
    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        int min = 0;
        int max = 0;
        queue.add(new Node(root, 0));
        while(!queue.isEmpty()){
            Node node = queue.remove();
            TreeNode temp = node.root;
            int col = node.col;
            min = Math.min(col, min);
            max = Math.max(col, max);
            if(!map.containsKey(col))
                map.put(col, new ArrayList<>());
            map.get(col).add(temp.val);
            if(temp.left != null)
                queue.add(new Node(temp.left, col - 1));
            if(temp.right != null)
                queue.add(new Node(temp.right, col + 1));

        }
        int start = min;
        while(start <= max){
            res.add(map.get(start));
            start++;
        }
        return res;
    }
}


class Node{
    TreeNode root;
    int col;
    public Node(TreeNode root, int col){
        this.root = root;
        this.col = col;
    }
}
