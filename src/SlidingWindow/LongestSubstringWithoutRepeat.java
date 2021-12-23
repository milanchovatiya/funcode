package SlidingWindow;

import java.util.*;

public class LongestSubstringWithoutRepeat {


    public static void main(String[] args) {


       // Given a string, find the length of the longest substring without repeating characters.


    }

    public int lengthOfLongestSubstringAlternate(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, maxLength = Integer.MIN_VALUE;
        int counter = 0;
        WindowUpdated window = new WindowUpdated();
        while(end < s.length()){
            window.add(s.charAt(end));
            while(window.counter() != 0){
                window.remove(s.charAt(start));
                start++;
            }
            end++;
            maxLength = Math.max(maxLength, end - start);
        }
        if(maxLength == Integer.MIN_VALUE)
            return 0;
        return maxLength;
    }

    public int lengthOfLongestSubstringSlidingWindow(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, maxLength = Integer.MIN_VALUE;
        int counter = 0;
        while(end < s.length()){
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
            if(map.get(s.charAt(end)) > 1)
                counter++;
            while(counter != 0){
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                if(map.get(s.charAt(start)) > 0){
                    counter--;
                }
                start++;
            }
            end++;
            maxLength = Math.max(maxLength, end - start);
        }
        if(maxLength == Integer.MIN_VALUE)
            return 0;
        return maxLength;
    }
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstringBruteForce(String s) {
        if(s.isEmpty())
            return 0;
        int maxLength = 0;
        Set<Character> hashSet = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            int countSoFar = 0;
            for(int j = i; j < s.length(); j++){
                if(!hashSet.contains(s.charAt(j))){
                    countSoFar++;
                    hashSet.add(s.charAt(j));
                }
                else
                    break;
            }
            System.out.println(countSoFar);
            if(countSoFar > maxLength)
                maxLength = countSoFar;
            hashSet.clear();
        }
        return maxLength;
    }
}

class WindowUpdated {
    Map<Character, Integer> count;
    int counter;

    WindowUpdated() {
        count = new HashMap();
        counter = 0;
    }

    void add(Character x) {
        count.put(x, count.getOrDefault(x, 0) + 1);
        if (count.get(x) > 1)
            counter++;
    }

    void remove(Character x) {
        count.put(x, count.get(x) - 1);
        if (count.get(x) > 0)
            counter--;
    }

    int counter() {
        return counter;
    }
}
