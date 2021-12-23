package LinkedList;

import java.util.*;

public class MergeSortedList {


    public static void main(String[] args) {


//        Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.


    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
    //Divide and Conquer
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        ListNode first = lists[0];
        for(int i = 1; i < lists.length; i++){
            first = mergeTwoLists(first, lists[i]);
        }
        return first;

    }
    //Put first node's value and the respective list in the priority queue.
    public ListNode mergeKListsPriorityQueue(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                return Integer.compare(p1.value, p2.value);
            }
        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                queue.add(new Pair(lists[i].val, lists[i]));
        }
        ListNode newList = new ListNode(-1);
        ListNode temp = newList;

        while (!queue.isEmpty()) {
            Pair p = queue.remove();
            int value = p.value;
            ListNode node = p.list;
            ListNode newNode = new ListNode(value);
            temp.next = newNode;
            node = node.next;
            if (node != null) {
                queue.add(new Pair(node.val, node));
            }

            temp = temp.next;
        }
        return newList.next;
    }
}

class Pair{
    int value;
    ListNode list;
    public Pair(int value, ListNode list){
        this.value = value;
        this.list = list;
    }
}