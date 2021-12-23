package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithAtmost2Distinct {


    public static void main(String[] args) {


       // Given a string s , find the length of the longest
        // substring t  that contains at most 2 distinct characters.


    }

    public int lengthOfLongestSubstringTwoDistinctAlternate(String s) {
        Map<Character, Integer> map = new HashMap<>();

        Window window = new Window();
        int begin = 0, end = 0, maxLength = Integer.MIN_VALUE;
        int counter = 0;

        while(end < s.length()){
            window.add(s.charAt(end));

            while(window.different() > 2){
                window.remove(s.charAt(begin));
                begin++;
            }
            end++;
            if(end - begin > maxLength){
                maxLength = end - begin;
            }

        }
        if(maxLength == Integer.MIN_VALUE){
            return 0;
        }

        return maxLength;


    }
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();


        int begin = 0, end = 0, maxLength = Integer.MIN_VALUE;
        int counter = 0;

        while(end < s.length()){
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
            if(map.get(s.charAt(end)) == 1)
                counter++;
            while(counter > 2){
                if(map.containsKey(s.charAt(begin))){
                    map.put(s.charAt(begin), map.get(s.charAt(begin)) - 1);
                    if(map.get(s.charAt(begin)) == 0)
                        counter--;
                }
                begin++;
            }
            end++;
            if(end - begin > maxLength){
                maxLength = end - begin;
            }

        }
        if(maxLength == Integer.MIN_VALUE){
            return 0;
        }

        return maxLength;


    }
}
