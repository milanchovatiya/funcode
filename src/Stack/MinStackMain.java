package Stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
    }

    public void push(int x) {
        if(x <= min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.pop() == min)
            min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

public class MinStackMain {


    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(3);
        obj.push(2);
        obj.push(1);
        obj.push(0);
        obj.pop();
        System.out.println(obj.top());
        obj.pop();
        System.out.println(obj.top());
        obj.pop();
        System.out.println(obj.top());
    }



}
