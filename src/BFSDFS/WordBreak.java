package BFSDFS;

import java.util.*;

public class WordBreak {


    public static void main(String[] args) {
        String s1 = "leetcode", s2 = "applepenapple", s3 = "catsandog", s4 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict = new ArrayList<>();
//        wordDict.add("apple");
//        wordDict.add("pen");
//        wordDict.add("apple");
        wordDict.add("abc");
        wordDict.add("a");
        wordDict.add("b");
        wordDict.add("c");
        wordDict.add("ab");
//        wordDict.add("aaaaaaaaa");
//        wordDict.add("aaaaaaaaaa");
        List<List<String>> res = new ArrayList<>();
        wordBreakBackTracking("abc", new ArrayList<String>(), res, wordDict);
        for(List<String> str : res){
            System.out.println(str);
        }
        //System.out.println(wordBreakDP(s2, wordDict));

    }

    private static void wordBreakBackTracking(String s1, List<String> temp,
                                              List<List<String>> res, List<String> wordDict) {
        if(s1.isEmpty()){
            List<String> list = new ArrayList<>(temp);
            res.add(list);
        }
        else{
            for(int i = 0; i < s1.length(); i++){
                if(wordDict.contains(s1.substring(0,i + 1))){
                    temp.add(s1.substring(0,i + 1));
                    wordBreakBackTracking(s1.substring(i + 1), temp, res, wordDict);
                    temp.remove(s1.substring(0,i + 1));
                }
            }
        }
    }

    public static boolean wordBreakBFS(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }

    public static boolean wordBreakDP(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String temp = s.substring(j, i);
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
