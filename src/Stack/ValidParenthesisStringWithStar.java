package Stack;

import java.util.Stack;

public class ValidParenthesisStringWithStar {

//    Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
//
//    The following rules define a valid string:
//
//    Any left parenthesis '(' must have a corresponding right parenthesis ')'.
//    Any right parenthesis ')' must have a corresponding left parenthesis '('.
//    Left parenthesis '(' must go before the corresponding right parenthesis ')'.
//            '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
//
//
//    Example 1:
//
//    Input: s = "()"
//    Output: true
//    Example 2:
//
//    Input: s = "(*)"
//    Output: true
//    Example 3:
//
//    Input: s = "(*))"
//    Output: true

    public boolean checkValidString(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()) {
            if(c == '*' || c == '(') {
                stack.push(c);
            } else {
                int countStar = 0;
                while(!stack.isEmpty() && stack.peek() != '('){
                    countStar++;
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    if(countStar == 0) {
                        return false;
                    } else {
                        countStar--;
                    }
                } else {
                    stack.pop();

                }
                while(countStar > 0) {
                    stack.push('*');
                    countStar--;
                }
            }
        }
        int stars = 0;
        while(!stack.isEmpty()) {
            Character ch = stack.pop();
            if(ch == '*') {
                stars++;
            } else {
                if(stars == 0) {
                    return false;
                } else {
                    stars--;
                }
            }
        }

        return true;
    }

    public boolean checkValidStringOptimized(String s) {
        int lo = 0, hi = 0;
        for (char c: s.toCharArray()) {
            lo += c == '(' ? 1 : -1;
            hi += c != ')' ? 1 : -1;
            if (hi < 0) return false;
            lo = Math.max(lo, 0);
        }
        return lo == 0;

    }
}
