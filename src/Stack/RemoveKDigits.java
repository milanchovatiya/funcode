package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveKDigits {


    public static void main(String[] args) {


//        we want the result value smallest after removing k digits
//        a sequence of digits, the key is when we think about to remove it
//        some examples:
//        112368 k = 3, remove the last k digits
//        112134 k = 3, remove 2 and 34, 111
//        5413210 k = 3, 1210
//        1000123 k = 2, 12
//        451789 k = 2
//        always compare with next digit and if num[i] > nums[i+1] remove i
//        then at last, need to handle the leading 0s
        removeKdigits("1432219", 3);

    }
    public static String removeKdigits(String num, int k) {
        if(num.length() <= k)
            return "0";

        Stack<Character> stack = new Stack<>();

        for(Character c : num.toCharArray()){
            if(!stack.isEmpty() && stack.peek() > c && k > 0){
                while(!stack.isEmpty() && stack.peek() > c && k > 0){
                    stack.pop();
                    k--;
                }
            }
            stack.push(c);

        }

        while(k > 0){
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }

        while(sb.length() > 0 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
