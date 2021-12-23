package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BackSpaceStringCompare {


    //Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
    public static void main(String[] args) {


        System.out.println(backspaceCompare("ab#c", "ad#c"));


    }
    public static boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public static String build(String S) {
        Stack<Character> ans = new Stack();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }
}
