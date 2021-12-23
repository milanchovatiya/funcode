package Palindrome;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LongestPalindrome {


    public static void main(String[] args) {


    //


    }
    public int longestPalindrome(String s) {
        int[] map = new int[128];

        for(Character c : s.toCharArray()){
            map[c] = map[c] + 1;
        }

        int ans = 0;
        for(Integer v : map){
            ans += v / 2 * 2;
            if (ans % 2 == 0 && v % 2 == 1)
                ans++;
        }

        return ans;
    }
}
