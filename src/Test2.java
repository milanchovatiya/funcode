import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.*;

import static org.junit.Assert.*;

public class Test2 {

    static class Solution {
        class TrieNode {
            TrieNode[] arr = new TrieNode[26];
            String word = "";
        }

        class Trie {
            TrieNode root = new TrieNode();

            public void putAWord(String word) {
                TrieNode trie = root;
                for(int i = 0; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    if(trie.arr[ch - 'a'] == null) {
                        trie.arr[ch - 'a'] = new TrieNode();
                    }
                    trie = trie.arr[ch - 'a'];
                }
                trie.word = word;
            }

            public boolean doesWordExists(String word) {
                if(word.equalsIgnoreCase("")) {
                    return false;
                }
                TrieNode trie = root;
                for(int i = 0; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    if(trie.arr[ch - 'a'] == null) {
                        return false;
                    }
                    trie = trie.arr[ch - 'a'];
                }
                return trie.word.equalsIgnoreCase(word);
            }

            public boolean doesPrefixExists(String word) {
                TrieNode trie = root;
                for(int i = 0; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    if(trie.arr[ch - 'a'] == null) {
                        return false;
                    }
                    trie = trie.arr[ch - 'a'];
                }
                return true;
            }

        }
        public List<String> findWords(char[][] board, String[] words) {
            List<String> result = new ArrayList<>();
            Trie trie = new Trie();
            for(String word : words) {
                trie.putAWord(word);
            }


            if(board == null || board.length == 0 || board[0].length == 0) {
                return result;
            }
            int n = board.length;
            int m = board[0].length;
            boolean[][] visited = new boolean[n][m];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    helper(board, i, j, visited, result, trie.root);
                }
            }


            return result;
        }

        private void helper(char[][] board, int i, int j, boolean[][] visited,
                            List<String> result, TrieNode trie) {
            int n = board.length;
            int m = board[0].length;

            if(!trie.word.equals("")) {
                result.add(trie.word);
                //trie.word = "";
            }

            if(i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || trie.arr[board[i][j] - 'a'] == null) {
                return;
            }

            trie = trie.arr[board[i][j] - 'a'];





            visited[i][j] = true;

            helper(board, i + 1, j, visited, result, trie);
            helper(board, i - 1, j, visited, result, trie);
            helper(board, i, j + 1, visited, result, trie);
            helper(board, i, j - 1, visited, result, trie);


            visited[i][j] = false;

        }
    }

    private static List<int[]> find_word_location(char[][] grid, String word) {

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == word.charAt(0)) {
                    List<int[]> result = new ArrayList<>();
                    List<int[]> main = new ArrayList<>();
                    helper(i, j, 0, result, grid, word, main);
                    if(main.size() == word.length()) {
                        return main;
                    }
                }
            }
        }

        return null;
    }

    private static void helper(int row, int col, int index, List<int[]> result, char[][] grid, String word, List<int[]> main) {
        int maxRow = grid.length;
        int maxCol = grid[0].length;

        //System.out.println(index + "," + grid[row][col]);
        if(row < 0 || row >= maxRow || col < 0 || col >= maxCol || grid[row][col] != word.charAt(index)) {
            return;
        }

        if(index == word.length() - 1) {
            result.add(new int[]{row, col});
            main.addAll(result);
            return;
        }
        result.add(new int[]{row, col});
        helper(row, col + 1, index + 1, result, grid, word, main);
        helper(row + 1, col, index + 1, result, grid, word, main);
        result.remove(result.size() - 1);

    }

    public static void main(String[] args) {
        char[][] grid1 = {
                {'c', 'c', 'x', 't', 'i', 'b'},
                {'c', 'c', 'a', 't', 'n', 'i'},
                {'a', 'c', 'n', 'n', 't', 't'},
                {'t', 'c', 's', 'i', 'p', 't'},
                {'a', 'o', 'o', 'o', 'a', 'a'},
                {'o', 'a', 'a', 'a', 'o', 'o'},
                {'k', 'a', 'i', 'c', 'k', 'i'}
        };
        String word1 = "catnip";
        String word2 = "cccc";
        String word3 = "s";
        String word4 = "bit";
        String word5 = "aoi";
        String word6 = "ki";
        String word7 = "aaa";
        String word8 = "ooo";

        char[][] grid2 = {{'a'}};
        String word9 = "a";

        for(int[] arr : find_word_location(grid1, word8)) {
            System.out.println(arr[0] + ", " + arr[1]);
        }
//        char[][] board = new char[][]{
//                {'o', 'a', 'a', 'n'},
//                {'e', 't', 'a', 'e'},
//                {'i', 'h', 'k', 'r'},
//                {'i', 'f', 'l', 'v'},
//        };
//        Solution solution = new Solution();
//        solution.findWords(board, new String[]{"oath","pea","eat","rain"});

    }
}