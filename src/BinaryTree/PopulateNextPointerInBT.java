package BinaryTree;

import java.util.*;


public class PopulateNextPointerInBT {


    public static void main(String[] args) {



//        Populate each next pointer to point to its next right node.
//                If there is no next right node, the next pointer should be set to NULL.

    }
    //BFS approach
    public Node connect(Node root) {
        if(root == null)
            return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;
        int n = 1;
        while(!queue.isEmpty()){
            Node node = queue.remove();

            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
            if(index == Math.pow(2, n) - 1){
                node.next = null;
                n++;
            }
            else{
                node.next = queue.peek();
            }
            index++;
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
