package Palindrome;

import java.util.*;

public class PalindromePermutation {


    public static void main(String[] args) {

    canPermutePalindromeSinglePass("carerac");



    }
    public boolean canPermutePalindrome(String s) {
        int[] map = new int[128];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
        }
        int count = 0;
        for (int key = 0; key < map.length && count <= 1; key++) {
            count += map[key] % 2;
        }
        return count <= 1;
    }

    public static boolean canPermutePalindromeSinglePass(String s) {
        int[] map = new int[128];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            if (map[s.charAt(i)] % 2 == 0)
                count--;
            else
                count++;
        }
        return count <= 1;
    }

    public boolean canPermutePalindromeHashMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(Character c : s.toCharArray()){
            if(map.getOrDefault(c, 0) == 0)
                map.put(c, 1);
            else
                map.remove(c);
        }
        if(map.keySet().size() > 1)
            return false;
        return true;

    }
}
