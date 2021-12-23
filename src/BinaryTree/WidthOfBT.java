package BinaryTree;

import java.util.*;

public class WidthOfBT {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);

        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        node1.right = node5;
        System.out.println(widthOfBinaryTree(root));


    }

    //The main idea in this question is to give each node a position value.
    // If we go down the left neighbor, then position -> position * 2; and
    // if we go down the right neighbor, then position -> position * 2 + 1.
    // This makes it so that when we look at the position values L and R of two
    // nodes with the same depth, the width will be [pos(Rightmost Node) - pos(LeftMost) + 1].
    public static int widthOfBinaryTree(TreeNode root) {
        Queue<AnnotatedNode> queue = new LinkedList();
        queue.add(new AnnotatedNode(root, 0, 0));
        int curDepth = 0, left = 0, ans = 0;
        while (!queue.isEmpty()) {
            AnnotatedNode a = queue.poll();
            if (curDepth != a.depth) {
                curDepth = a.depth;
                left = a.pos;
            }
            ans = Math.max(ans, a.pos - left + 1);
            if (a.node.left != null) {
                queue.add(new AnnotatedNode(a.node.left, a.depth + 1, a.pos * 2));
            }
            if (a.node.right != null) {
                queue.add(new AnnotatedNode(a.node.right, a.depth + 1, a.pos * 2 + 1));
            }
        }
        return ans;
    }
}


class AnnotatedNode {
    TreeNode node;
    int depth, pos;
    AnnotatedNode(TreeNode n, int d, int p) {
        node = n;
        depth = d;
        pos = p;
    }
}
