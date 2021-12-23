package LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PartitionList {


    public static void main(String[] args) {


       // Given a linked list and a value x, partition it such that all nodes less than x come
        // before nodes greater than or equal to x.

          //      You should preserve the original relative order of the nodes in each of the two partitions.

    }
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        left.next = null;
        ListNode right = new ListNode(0);
        right.next = null;
        ListNode temp1 = left;
        ListNode temp2 = right;

        while(head != null){
            if(head.val < x){
                left.next = head;
                left = left.next;
            }
            else{
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        right.next = null;
        left.next = temp2.next;
        return temp1.next;
    }
}
