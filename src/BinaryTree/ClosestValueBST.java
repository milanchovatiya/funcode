package BinaryTree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class ClosestValueBST {


    public static void main(String[] args) {



        //Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.


    }
    public int closestValue(TreeNode root, double target) {
        Stack<TreeNode> stack = new Stack<>();
        int prev = Integer.MIN_VALUE;
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.val > target){
                if(prev == Integer.MIN_VALUE)
                    return root.val;
                double mid = (double)(root.val + prev) / 2;
                return target >= mid ? root.val : prev;
            }
            prev = root.val;
            root = root.right;
        }
        return prev;
    }

    public List<Integer> closestKValuesUsingStackQueue(TreeNode root, double target, int k) {
        Stack<Integer> pred = new Stack<>();
        Queue<Integer> succ = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.val < target)
                pred.push(root.val);
            else{
                succ.add(root.val);
            }
            root = root.right;
        }
        while(k > 0){
            if(pred.isEmpty()){
                res.add(succ.remove());
                k--;
            }
            else if(succ.isEmpty()){
                res.add(pred.pop());
                k--;
            }
            else{
                int cand1 = pred.pop();
                int cand2 = succ.remove();
                double diff1 = Math.abs(cand1 - target);
                double diff2 = Math.abs(cand2 - target);
                if(diff1 < diff2){
                    res.add(cand1);
                    k--;
                    if(k > 0){
                        res.add(cand2);
                        k--;
                    }
                }
                else{
                    res.add(cand2);
                    k--;
                    if(k > 0){
                        res.add(cand1);
                        k--;
                    }
                }

            }
        }
        return res;
    }



    public List<Integer> closestKValuesHeap(TreeNode root, double target, int k) {
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2){
                return Double.compare(p2.diff, p1.diff);
            }
        });
        List<Integer> res = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            double diff = Math.abs(root.val - target);
            if(queue.size() < k)
                queue.add(new Pair(root.val, diff));
            else if(diff < queue.peek().diff){
                queue.remove();
                queue.add(new Pair(root.val, diff));
            }
            root = root.right;
        }
        while(!queue.isEmpty()){
            res.add(queue.remove().val);
        }
        return res;
    }
    class Pair{
        int val;
        double diff;
        public Pair(int val, double diff){
            this.val = val;
            this.diff = diff;
        }
    }
}


