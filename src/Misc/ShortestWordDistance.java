package Misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ShortestWordDistance {


    public static void main(String[] args) {


//        Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
//
//                Example:
//        Assume that words = ["practice", "makes", "perfect", "coding", "makes"]


    }
    public int shortestDistance(String[] words, String word1, String word2) {
        int n = words.length;
        List<Integer> startList = new ArrayList<>();
        List<Integer> endList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(words[i].equals(word1))
                startList.add(i);
            else if(words[i].equals(word2))
                endList.add(i);
        }
        int minDistance = Integer.MAX_VALUE;
        for(Integer i : startList){
            for(Integer j : endList){
                if(Math.abs(i - j) < minDistance){
                    minDistance = Math.abs(i - j);
                }
            }
        }
        return minDistance;
    }
    //Only stores the last occurence of each word!!!
    public int shortestDistanceOptimized(String[] words, String word1, String word2) {
        int i1 = -1, i2 = -1;
        int minDistance = words.length;
        int currentDistance;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                i1 = i;
            } else if (words[i].equals(word2)) {
                i2 = i;
            }

            if (i1 != -1 && i2 != -1) {
                minDistance = Math.min(minDistance, Math.abs(i1 - i2));
            }
        }
        return minDistance;
    }
}
