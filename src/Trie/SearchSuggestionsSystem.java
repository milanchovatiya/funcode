package Trie;


import java.util.*;
import java.util.PriorityQueue;






class Solution {


//    Given an array of strings products and a string searchWord. We want to design a system
//    that suggests at most three product names from products after each character of searchWord is typed.
//    Suggested products should have common prefix with the searchWord. If there are more than three products
//    with a common prefix return the three lexicographically minimums products.
//
//    Return list of lists of the suggested products after each character of searchWord is typed.
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        for(String product : products){
            trie.insert(product);
        }
        List<List<String>> res = new ArrayList<>();

        for(int i = 1; i <= searchWord.length(); i++){
            String str = searchWord.substring(0, i);
            List<String> inner = trie.suggest(str);
            res.add(inner);


        }
        return res;



    }

    class Trie{

        class TrieNode{
            TrieNode[] node;
            String word;

            public TrieNode(){
                node = new TrieNode[26];
                word = "";
            }

            public void put(char c, TrieNode node){
                this.node[c - 'a'] = node;
            }

            public TrieNode get(char c){
                return node[c - 'a'];
            }

            public boolean contains(char c){
                return node[c - 'a'] != null;
            }

            public void setWord(String word){
                this.word = word;
            }

            public String getWord(){
                return this.word;
            }
        }
        TrieNode root;

        public Trie(){
            root = new TrieNode();
        }

        public void insert(String word){
            TrieNode temp = root;
            for(int i = 0; i < word.length(); i++){
                if(!temp.contains(word.charAt(i)))
                    temp.node[word.charAt(i) - 'a'] = new TrieNode();
                temp = temp.node[word.charAt(i) - 'a'];
            }
            temp.word = word;
            //temp.setWord(word);
        }

        public List<String> suggest(String word){
            List<String> res = new ArrayList<>();
            PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>(){
                public int compare(String str1, String str2){
                    return str1.compareTo(str2);
                }
            });
            TrieNode temp = root;
            for(int i = 0; i < word.length(); i++){
                if(!temp.contains(word.charAt(i)))
                    return new ArrayList<>();
                temp = temp.get(word.charAt(i));
            }
            helper(temp, queue, word);
            while(!queue.isEmpty()){
                if(res.size() == 3)
                    break;
                res.add(queue.remove());
            }
            return res;
        }

        public int int_(char c) {
            return c == ' ' ? 26 : c - 'a';
        }

        public void helper(TrieNode temp, PriorityQueue<String> queue, String word){
            if(!temp.getWord().equals(""))
                queue.add(word);
            for (char i = 'a'; i <= 'z'; i++) {
                if(temp.get(i) != null){
                    helper(temp.get(i), queue, word + i);
                }
            }
        }

        public boolean hasPrefix(String word){
            TrieNode temp = root;
            for(int i = 0; i < word.length(); i++){
                if(!temp.contains(word.charAt(i)))
                    return false;
                temp = temp.get(word.charAt(i));
            }
            return true;
        }

    }
}