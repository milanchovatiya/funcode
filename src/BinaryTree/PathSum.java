package BinaryTree;

import java.util.*;

public class PathSum {
    static int numPath;
    static int count = 0;


    public static void main(String[] args) {


        TreeNode root = new TreeNode(1);
        TreeNode node4 = new TreeNode(-2);
        TreeNode node8 = new TreeNode(-3);
        TreeNode node11 = new TreeNode(11);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node13 = new TreeNode(13);
        TreeNode node42 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        root.left = node4;
        root.right = node8;
//        node4.left = node11;
//        node11.left = node7;
//        node11.right = node2;
//        node8.left = node13;
//        node8.right = node42;
//        node42.left = node5;
//        node42.right = node1;

        System.out.println(numOfpathSumHashMap(root, -1));


    }

    //Finds the number of paths
    public static int numOfpathSumHashMap(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0,1);
        helper(root, 0, sum, preSum);
        return count;
    }

    public static void helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return;
        }

        currSum += root.val;

        if (preSum.containsKey(currSum - target)) {
            count += preSum.get(currSum - target);
        }
        preSum.put(currSum, preSum.getOrDefault(currSum, 0)+1);

        helper(root.left, currSum, target, preSum);
        helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
    }

    //Finds lists of all the paths
    public List<List<Integer>> listOfpathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (root == null)
            return res;
        findPaths(root, sum, res, temp);

        return res;
    }

    public void findPaths(TreeNode root, int sum, List<List<Integer>> res, List<Integer> temp){
        if(root == null)
            return;
        List<Integer> temp1 = new ArrayList<>(temp);
        temp1.add(root.val);

        if(root.val == sum && root.left == null && root.right == null){
            res.add(temp1);
            return;
        }
        findPaths(root.left, sum - root.val, res, temp1);
        findPaths(root.right, sum - root.val, res, temp1);


    }

    public List<List<Integer>> findPathsDFS(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root, prev = null;
        int sum = 0;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                sum += cur.val;
                list.add(cur.val);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.left == null && cur.right == null && sum == target) res.add(new LinkedList<>(list));
            if (cur.right != null && cur.right != prev) cur = cur.right; //- if exists and still not visited
            else {
                prev = stack.pop();
                sum -= prev.val;
                list.removeLast();
                cur = null;
            }
        }
        return res;
    }
    //Finds whether a path exists
    public boolean hasPathSumDFS(TreeNode root, int target) {
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root, prev = null;
        int sum = 0;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                sum += cur.val;
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.left == null && cur.right == null && sum == target) return true;
            if (cur.right != null && cur.right != prev) cur = cur.right; //- if exists and still not visited
            else {
                prev = stack.pop();
                sum -= prev.val;
                cur = null;
            }
        }
        return false;
    }
    //Finds whether a path exists
    public boolean hasPathSumBFS(TreeNode root, int sum) {
        if (root == null) return false;
        Deque<TreeNode> queueT = new LinkedList<>();
        Deque<Integer> queueS = new LinkedList<>();
        queueT.addFirst(root);
        queueS.addFirst(root.val);
        while (!queueT.isEmpty()) {
            int n = queueT.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queueT.removeLast();
                int s = queueS.removeLast();
                if (node.left == null && node.right == null && s == sum) return true;
                if (node.left != null) {
                    queueT.addFirst(node.left);
                    queueS.addFirst(s + (int)node.left.val);
                }
                if (node.right != null) {
                    queueT.addFirst(node.right);
                    queueS.addFirst(s + (int)node.right.val);
                }
            }
        }
        return false;
    }


}
