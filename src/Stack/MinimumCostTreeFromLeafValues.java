package Stack;

import java.util.Stack;

public class MinimumCostTreeFromLeafValues {


//Let's review the problem again.
//
//        When we build a node in the tree, we compared the two numbers a and b.
//        In this process,
//        the smaller one is removed and we won't use it anymore,
//        and the bigger one actually stays.
//
//        The problem can translated as following:
//        Given an array A, choose two neighbors in the array a and b,
//        we can remove the smaller one min(a,b) and the cost is a * b.
//        What is the minimum cost to remove the whole array until only one left?
//
//        To remove a number a, it needs a cost a * b, where b >= a.
//        So a has to be removed by a bigger number.
//        We want minimize this cost, so we need to minimize b.
//
//        b has two candidates, the first bigger number on the left,
//        the first bigger number on the right.
//
//        The cost to remove a is a * min(left, right).

//    we decompose a hard problem into reasonable easy one:
//        Just find the next greater element in the array, on the left and one right.
//        Refer to the problem 503. Next Greater Element II
//
//
//        Time O(N) for one pass
//        Space O(N) for stack in the worst cases

    public int mctFromLeafValues(int[] A) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        for (int a : A) {
            while (stack.peek() <= a) {
                int mid = stack.pop();
                res += mid * Math.min(stack.peek(), a);
            }
            stack.push(a);
        }
        while (stack.size() > 2) {
            res += stack.pop() * stack.peek();
        }
        return res;
    }
}
