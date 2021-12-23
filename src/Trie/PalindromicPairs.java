package Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PalindromicPairs {

//    Given a list of unique words, return all the pairs of the distinct indices (i, j) in the given list,
//    so that the concatenation of the two words words[i] + words[j] is a palindrome.
//
//
//
//            Example 1:
//
//    Input: words = ["abcd","dcba","lls","s","sssll"]
//    Output: [[0,1],[1,0],[3,2],[2,4]]
//    Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
//    Example 2:
//
//    Input: words = ["bat","tab","cat"]
//    Output: [[0,1],[1,0]]
//    Explanation: The palindromes are ["battab","tabbat"]
//    Example 3:
//
//    Input: words = ["a",""]
//    Output: [[0,1],[1,0]]

    class TrieNode{
        int index = -1;
        HashMap<Character, TrieNode> node = new HashMap<>();
        List<Integer> indexList = new ArrayList<>();
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        TrieNode trie = new TrieNode();
        for(int i = 0; i < words.length; i++) {
            insertIntoTrie(trie, new StringBuilder(words[i]).reverse().toString(), i);
        }

        List<List<Integer>> resultList = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            List<Integer> indexList = fetchFromTrie(trie, word);
            for(Integer index : indexList) {
                if(index != i) {
                    resultList.add(Arrays.asList(i, index));
                }
            }
            for(int j = 0; j < word.length(); j++) {
                if(isValidPalindrome(word.substring(j, word.length()))) {
                    String prefix = word.substring(0, j);
                    int prefixIndex = fetchIndexFromTrie(trie, prefix);
                    if(prefixIndex != -1 && prefixIndex != i) {
                        resultList.add(Arrays.asList(i, prefixIndex));
                    }
                }
            }
        }
        return resultList;

    }

    private Integer fetchIndexFromTrie(TrieNode root, String word) {
        TrieNode trie = root;
        for(int i = 0; i < word.length(); i++) {
            if(!trie.node.containsKey(word.charAt(i))) {
                return -1;
            }
            trie = trie.node.get(word.charAt(i));
        }
        return trie.index;
    }

    private List<Integer> fetchFromTrie(TrieNode root, String word) {
        TrieNode trie = root;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < word.length(); i++) {
            if(!trie.node.containsKey(word.charAt(i))) {
                return new ArrayList<>();
            }
            trie = trie.node.get(word.charAt(i));
        }
        result.addAll(trie.indexList);
        if(trie.index != -1) {
            result.add(trie.index);
        }
        return result;
    }

    private void insertIntoTrie(TrieNode root, String word, int index) {
        TrieNode trie = root;
        for(int i = 0; i < word.length(); i++) {
            if(!trie.node.containsKey(word.charAt(i))) {
                trie.node.put(word.charAt(i), new TrieNode());
            }
            if(isValidPalindrome(word.substring(i, word.length()))) {
                trie.indexList.add(index);
            }
            trie = trie.node.get(word.charAt(i));
        }
        trie.index = index;
    }

    private boolean isValidPalindrome(String word) {
        boolean isValid = true;
        int left = 0, right = word.length() - 1;
        while(left < right) {
            if(word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
