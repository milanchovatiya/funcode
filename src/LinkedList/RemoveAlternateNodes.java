package LinkedList;


public class RemoveAlternateNodes {


    public static void main(String[] args) {
        ListNode head1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(7);
        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = head1;

        removeAlternateElements(head1);


        while(head1 != null){

            String sign = head1.next == null ? "" : " -> ";
            System.out.print(head1.val + sign);
            head1 = head1.next;
        }

    }
    public static ListNode removeAlternateElements(ListNode head) {
        ListNode temp = head.next;
        ListNode prev = head;

        boolean isAlternate = true;
        while(temp != head){
            if(isAlternate){
                if(temp.next != null)
                    prev.next = temp.next;
                else
                    prev.next = head;
                isAlternate = false;
            }
            else{
                isAlternate = true;
            }
            prev = temp;
            temp = temp.next;
        }
        return null;
    }



}
