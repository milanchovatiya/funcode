package LinkedList;


import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {


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
        //node6.next = head1;


    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2){
                return Integer.compare(p1.value, p2.value);
            }
        });
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null)
                queue.add(new Pair(lists[i].val, lists[i]));
        }
        ListNode newList = new ListNode(-1);
        ListNode temp = newList;

        while(!queue.isEmpty()){
            Pair p = queue.remove();
            int value = p.value;
            ListNode node = p.list;
            ListNode newNode = new ListNode(value);
            temp.next = newNode;
            node = node.next;
            if(node != null){
                queue.add(new Pair(node.val, node));
            }

            temp = temp.next;
        }
        return newList.next;
    }



}
