package Design;

import java.util.*;

public class StackUsingQueues {


    public static void main(String[] args) {


        //Implement stack using queues


    }
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    int top;


    /** Initialize your data structure here. */
    public StackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        this.top = x;
        queue1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(queue1.size() == 1)
            return queue1.remove();
        while(!queue1.isEmpty()){
            int ele = queue1.remove();
            queue2.add(ele);
            if(queue1.peek() == top){
                top = ele;
                break;
            }
        }
        int popEle = queue1.remove();
        while(!queue2.isEmpty()){
            queue1.add(queue2.remove());
        }

        return popEle;
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
