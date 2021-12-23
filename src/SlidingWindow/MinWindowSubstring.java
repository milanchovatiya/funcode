package SlidingWindow;

import java.util.*;

public class MinWindowSubstring {


    public static void main(String[] args) {


        //Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).




    }
    public String minWindow(String s, String t) {
        if(t.length()> s.length()) return "";

        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int counter = 0;
        int minLength = Integer.MAX_VALUE;
        int minStartIndex = 0;

        int begin = 0, end = 0;


        int len = Integer.MAX_VALUE;

        //loop at the begining of the source string
        while(end < s.length()){

            char c = s.charAt(end);//get a character

            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);
                if(map.get(c) >= 0) counter++;
            }
            while(counter == t.length()){
                if(end - begin + 1 < minLength){
                    //System.out.println(begin + "," + end);
                    minStartIndex = begin;
                    minLength = end - begin + 1;
                }

                char tempc = s.charAt(begin);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0) counter--;
                }

                begin++;
            }
            end++;
        }
        if(minLength == Integer.MAX_VALUE)
            return "";


        return s.substring(minStartIndex, minStartIndex + minLength);
    }
}
