package LinkedList;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class AddTwoNumberInAList {


    public static void main(String[] args) {
        ListNode head1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        head1.next = node2;
        node2.next = node3;


        ListNode head2 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(4);
        head2.next = node4;
        node4.next = node5;

        ListNode head3 = addTwoNumbers(head1, head2);

        while(head3 != null){
            String sign = head3.next == null ? "" : " -> ";
            System.out.print(head3.val + sign);
            head3 = head3.next;
        }

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;

    }

    public ListNode addTwoNumbersWithoutReversing(ListNode l1, ListNode l2) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        while (l1 != null) {
            st1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            st2.push(l2.val);
            l2 = l2.next;
        }
        ListNode pre = null;
        int carry = 0;
        while(!st1.isEmpty() || !st2.isEmpty() || carry != 0) {
            int sum = carry;
            if (!st1.isEmpty()) sum += st1.pop();
            if (!st2.isEmpty()) sum += st2.pop();
            int remain = sum % 10;
            carry = sum / 10;
            ListNode head = new ListNode(remain);
            head.next = pre;
            pre = head;
        }
        return pre;
    }
}
