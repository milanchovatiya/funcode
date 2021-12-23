package Stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class CountMaxPartition {


    public static void main(String[] args) {

        int[] arr = new int[]{10,2,4,1,6,5,9,7};
        System.out.println(countGroupsDeque(arr));


    }


    public static int countGroups(int[] a) {
        Stack<Integer> stack = new Stack<>();
        stack.push(a[0]);
        for (int i = 1; i < a.length; i++) {
            if (a[i] >= stack.peek()) stack.push(a[i]);
            else {
                int last = stack.pop();
                while (stack.size() > 0 && a[i] < stack.peek()) stack.pop();
                stack.push(last);
            }
        }
        return stack.size();
    }

    public static int countGroupsDeque(int[] a) {
        Deque<Integer> deque = new LinkedList<>();
        deque.push(a[0]);
        for (int i = 1; i < a.length; i++) {
            if (a[i] >= deque.peek()) deque.push(a[i]);
            else {
                int last = deque.pop();
                while (deque.size() > 0 && a[i] < deque.peek()) deque.pop();
                deque.push(last);
            }
        }
        return deque.size();
    }
}
