package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {


    public static void main(String[] args) {




//        Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees,
//        you only need to return the root node of any one of them.
//
//                Two trees are duplicate if they have the same structure with same node values.


    }
    int t;
    Map<String, Integer> trees;
    Map<Integer, Integer> count;
    List<TreeNode> ans;

//    Intuition
//
//    Suppose we have a unique identifier for subtrees: two subtrees are the same if and only if they have the same id.
//
//            Then, for a node with left child id of x and right child id of y, (node.val, x, y) uniquely determines the tree.
//
//    Algorithm
//
//    If we have seen the triple (node.val, x, y) before, we can use the identifier we've remembered.
//    Otherwise, we'll create a new one.

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        t = 1;
        trees = new HashMap();
        count = new HashMap();
        ans = new ArrayList();
        lookup(root);
        return ans;
    }

    public int lookup(TreeNode node) {
        if (node == null) return 0;
        String serial = node.val + "," + lookup(node.left) + "," + lookup(node.right);
        if(!trees.containsKey(serial)){
            trees.put(serial, t++);
        }
        int uid = trees.get(serial);
        count.put(uid, count.getOrDefault(uid, 0) + 1);
        if (count.get(uid) == 2)
            ans.add(node);
        return uid;
    }
}
