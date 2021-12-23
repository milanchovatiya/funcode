package LinkedList;


public class SwapNodes {


    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head1.next = node2;
        node2.next = node3;
        node3.next = node4;

        //node6.next = head1;

        System.out.println(swapPairs(head1));


    }
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        head.next.next = swapPairs(head.next.next);
        head = swapNode(head, head.next);
        return head;
    }

    static ListNode swapNode(ListNode l1, ListNode l2){
        ListNode temp = l2.next;
        l2.next = l1;
        l1.next = temp;
        return l2;
    }



}
