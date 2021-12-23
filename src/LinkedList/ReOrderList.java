package LinkedList;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class ReOrderList {

    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode middle = findMiddle(head);
        ListNode reverseMiddle = reverse(middle);
        ListNode mergedList = mergeTwoLists(head, reverseMiddle);
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode temp;
        while(head != null) {
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        boolean isFirst = true;
        ListNode temp = dummy;
        while(l1 != l2) {
            if(isFirst) {
                temp.next = l1;
                l1 = l1.next;
                isFirst = false;
            } else {
                temp.next = l2;
                l2 = l2.next;
                isFirst = true;
            }
            temp = temp.next;
        }

        return dummy.next;
    }
}