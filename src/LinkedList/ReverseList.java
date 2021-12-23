package LinkedList;


public class ReverseList {


    public static void main(String[] args) {
        ListNode head1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(7);
        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode head3 = reverseList(head1);
        while(head3 != null){
            String sign = head3.next == null ? " -> NULL" : " -> ";
            System.out.print(head3.val + sign);
            head3 = head3.next;
        }


    }
    public static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }



}
