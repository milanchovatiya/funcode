package BinaryTree;

public class MaxPathSum {


    public static void main(String[] args) {




//        Given a non-empty binary tree, find the maximum path sum.
//
//        For this problem, a path is defined as any sequence of nodes from
//        some starting node to any node in the tree along the parent-child connections.
//                The path must contain at least one node and does not need to go through the root


    }

//    Algorithm
//
//    Now everything is ready to write down an algorithm.
//
//    Initiate max_sum as the smallest possible integer and call max_gain(node = root).
//    Implement max_gain(node) with a check to continue the old path/to start a new path:
//    Base case : if node is null, the max gain is 0.
//    Call max_gain recursively for the node children to compute max gain from the left and right subtrees :
// left_gain = max(max_gain(node.left), 0) and
//            right_gain = max(max_gain(node.right), 0).
//            Now check to continue the old path or to start a new path.
// To start a new path would cost price_newpath = node.val + left_gain + right_gain. Update max_sum if it's better to start a new path.
//    For the recursion return the max gain the node and one/zero of its subtrees could add to the current path :
// node.val + max(left_gain, right_gain)
    int max_sum = Integer.MIN_VALUE;

    public int max_gain(TreeNode node) {
        if (node == null) return 0;

        // max sum on the left and right sub-trees of node
        int left_gain = Math.max(max_gain(node.left), 0);
        int right_gain = Math.max(max_gain(node.right), 0);

        // the price to start a new path where `node` is a highest node
        int price_newpath = node.val + left_gain + right_gain;

        // update max_sum if it's better to start a new path
        max_sum = Math.max(max_sum, price_newpath);

        // for recursion :
        // return the max gain if continue the same path
        return node.val + Math.max(left_gain, right_gain);
    }

    public int maxPathSum(TreeNode root) {
        max_gain(root);
        return max_sum;
    }
}
