package BinaryTree;

import java.util.*;

public class KDistanceNeighbours {


    public static void main(String[] args) {




//        We are given a binary search tree (with root node root), a target node, and an integer value K.
//
//        Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.


    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        bfs(target, k, res);
        if(root == target)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node == target){
                break;
            }
            if(node.left != null){
                parentMap.put(node.left, node);
                queue.add(node.left);
            }
            if(node.right != null){
                parentMap.put(node.right, node);
                queue.add(node.right);
            }
        }

        while(parentMap.containsKey(target)){
            TreeNode parent = parentMap.get(target);
            k--;

            if(k == 0){
                res.add(parent.val);
                break;
            }
            else if(parent.left != null && parent.left.val != target.val){
                bfs(parent.left, k - 1, res);
            }
            else if(parent.right != null && parent.right.val != target.val){
                bfs(parent.right, k - 1, res);
            }
            target = parent;
        }
        return res;
    }
    public List<Integer> distanceKBST(TreeNode root, TreeNode target, int k) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while(root != null){
            if(root.val == target.val){
                break;
            }
            stack.push(root);
            if(root.val > target.val){
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        bfs(target.left, k, res);
        bfs(target.right, k, res);
        while(!stack.isEmpty()){
            TreeNode n = stack.pop();
            k--;
            if(k == 0){
                res.add(n.val);
            }
            else if(target.val > n.val){
                bfs(n.left, k, res);
            }
            else{
                bfs(n.right, k, res);
            }
        }
        return res;

    }

    public void bfs(TreeNode node, int k, List<Integer> list){
        if(node == null){
            return;
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(node, 1));
        while(!queue.isEmpty()){
            Pair p = queue.remove();
            TreeNode n = p.node;
            int dist = p.distance;
            if(dist == k){
                list.add(n.val);
            }
            if(n.left != null && dist != k){
                queue.add(new Pair(n.left, dist + 1));
            }
            if(n.right != null && dist != k){
                queue.add(new Pair(n.right, dist + 1));
            }
        }
    }
}

class Pair{
    TreeNode node;
    int distance;
    public Pair(TreeNode node, int distance){
        this.node = node;
        this.distance = distance;
    }
}
