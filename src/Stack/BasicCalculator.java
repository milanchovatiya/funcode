package Stack;

import java.util.Stack;

public class BasicCalculator {

//    Given a string s representing a valid expression, implement a basic calculator to evaluate it,
//    and return the result of the evaluation.
//
//            Note: You are not allowed to use any built-in function which evaluates
//    strings as mathematical expressions, such as eval()
//
//    Example 1:
//
//    Input: s = "1 + 1"
//    Output: 2
//    Example 2:
//
//    Input: s = " 2-1 + 2 "
//    Output: 3
//    Example 3:
//
//    Input: s = "(1+(4+5+2)-3)+(6+8)"
//    Output: 23


//    Algorithm
//
//    Iterate the expression string one character at a time. Since we are reading the expression character by character,
//    we need to be careful when we are reading digits and non-digits.
//
//    The operands could be formed by multiple characters. A string "123" would mean a numeric 123,
//    which could be formed as: 123 >> 120 + 3 >> 100 + 20 + 3. Thus, if the character read is a digit
//    we need to form the operand by multiplying 10 to the previously formed continuing operand and adding the digit to it.
//
//    Whenever we encounter an operator such as + or - we first evaluate the expression to the left and
//    then save this sign for the next evaluation.
//
//    If the character is an opening parenthesis (, we just push the result calculated so far and the sign on to the stack (the sign and the magnitude) and
//    start a fresh as if we are calculating a new expression.
//
//    If the character is a closing parenthesis ), we first calculate the expression to the left.
//    The result from this would be the result of the expression within the set of parenthesis that just concluded.
//    This result is then multiplied with the sign, if there is any on top of the stack.
//    Remember we saved the sign on top of the stack when we had encountered an open parenthesis?
//    This sign is associated with the parenthesis that started then, thus when the expression ends
//    or concludes, we pop the sign and multiply it with result of the expression.
//    It is then just added to the next element on top of the stack.


    public int calculate(String s) {

        Stack<Integer> stack = new Stack<Integer>();
        int operand = 0;
        int result = 0; // For the on-going result
        int sign = 1;  // 1 means positive, -1 means negative

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {

                // Forming operand, since it could be more than one digit
                operand = 10 * operand + (int) (ch - '0');

            } else if (ch == '+') {

                // Evaluate the expression to the left,
                // with result, sign, operand
                result += sign * operand;

                // Save the recently encountered '+' sign
                sign = 1;

                // Reset operand
                operand = 0;

            } else if (ch == '-') {

                result += sign * operand;
                sign = -1;
                operand = 0;

            } else if (ch == '(') {

                // Push the result and sign on to the stack, for later
                // We push the result first, then sign
                stack.push(result);
                stack.push(sign);

                // Reset operand and result, as if new evaluation begins for the new sub-expression
                sign = 1;
                result = 0;

            } else if (ch == ')') {

                // Evaluate the expression to the left
                // with result, sign and operand
                result += sign * operand;

                // ')' marks end of expression within a set of parenthesis
                // Its result is multiplied with sign on top of stack
                // as stack.pop() is the sign before the parenthesis
                result *= stack.pop();

                // Then add to the next operand on the top.
                // as stack.pop() is the result calculated before this parenthesis
                // (operand on stack) + (sign on stack * (result from parenthesis))
                result += stack.pop();

                // Reset the operand
                operand = 0;
            }
        }
        return result + (sign * operand);
    }
}
