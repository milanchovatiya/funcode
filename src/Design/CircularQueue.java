package Design;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CircularQueue {


    public static void main(String[] args) {




//        Design your implementation of the circular queue.
//                The circular queue is a linear data structure in which
//        the operations are performed based on FIFO (First In First Out)
//        principle and the last position is connected back to the first position
//        to make a circle. It is also called "Ring Buffer".
//
//                One of the benefits of the circular queue is that we can
//        make use of the spaces in front of the queue. In a normal queue,
//        once the queue becomes full, we cannot insert the next element even
//        if there is a space in front of the queue. But using the circular queue,
//                we can use the space to store new values.


    }
    class ListNode {
        int val;
        ListNode prev, next;
        public ListNode(int x) {
            val = x;
            prev = null;
            next = null;
        }
    }

    class MyCircularQueue {
        int queueSize, currSize;
        ListNode head, tail;

        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            queueSize = k;
            currSize = 0;
            head = new ListNode(-1);
            tail = new ListNode(-1);
            head.next = tail;
            tail.prev = head;
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            ListNode newNode = new ListNode(value);
            newNode.next = tail;
            newNode.prev = tail.prev;
            tail.prev.next = newNode;
            tail.prev = newNode;
            currSize++;
            return true;
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            ListNode toBeDeleted = head.next;
            head.next = toBeDeleted.next;
            toBeDeleted.next.prev = head;
            toBeDeleted.next = null;
            toBeDeleted.prev = null;
            currSize--;
            return true;
        }

        /** Get the front item from the queue. */
        public int Front() {
            if(isEmpty()) {
                return -1;
            }
            return head.next.val;
        }

        /** Get the last item from the queue. */
        public int Rear() {
            if(isEmpty()) {
                return -1;
            }
            return tail.prev.val;
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return currSize == 0;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return currSize == queueSize;
        }
    }
}
