package Design;

public class KthSmallestBST {

//    What if the BST is modified (insert/delete operations) often and
//    you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

//    Insert and delete in a BST were discussed last week, the time complexity of these operations is {O(H),
// where HH is a height of binary tree, and H=logN for the balanced tree.
//
//    Hence without any optimisation insert/delete + search of kth element has O(2H + k) complexity.
// How to optimise that?
//
//    That's a design question, basically we're asked to implement a structure which contains
// a BST inside and optimises the following operations :
//
//    Insert
//
//            Delete
//
//    Find kth smallest
//
//    Seems like a database description, isn't it? Let's use here the same logic as for LRU cache design,
// and combine an indexing structure (we could keep BST here) with a double linked list.
//
//    Such a structure would provide:
//
//            \mathcal{O}(H) time for the insert and delete.
//
//            \mathcal{O}(k) for the search of kth smallest

    /**
     * Definition for a custom node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     DlinkedList node;
     *     TreeNode(int x) { val = x; }
     * }
     * class DLinkedNode {
        int val;
        DLinkedNode prev;
        DLinkedNode next;
     }
     */
}
