package Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Given a 2D board and a word, find if the word exists in the grid.
public class WordSearch_II {

    public static void main(String[] args){

//        Given a 2D board and a list of words from the dictionary, find all words in the board.
//
//                Each word must be constructed from letters of sequentially adjacent cell,
//        where "adjacent" cells are those horizontally or vertically neighboring.
//                The same letter cell may not be used more than once in a word.
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'D'},
                {'P', 'R', 'A', 'T'},
                {'K', 'I', 'T', 'A'},
                {'A', 'N', 'D', 'Y'},
        };
        //patternSearch(board, "ARCD");

    }
//    Intuitively, start from every cell and try to build a word in the dictionary.
//            Backtracking (dfs) is the powerful way to exhaust every possible ways.
//            Apparently, we need to do pruning when current character is not in any word.
//
//            How do we instantly know the current character is invalid? HashMap?
//    How do we instantly know what's the next valid character? LinkedList?
//    But the next character can be chosen from a list of characters. "Mutil-LinkedList"?
//    Combing them, Trie is the natural choice.
    public List<String> findWords(char[][] board, String[] words) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, res, visited);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res, boolean[][] visited) {
        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || visited[i][j]){
            return;
        }
        char c = board[i][j];

        if (p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {   // found one
            res.add(p.word);
            p.word = null;     // de-duplicate
        }

        visited[i][j] = true;
        dfs(board, i - 1, j ,p, res, visited);
        dfs(board, i, j - 1, p, res, visited);
        dfs(board, i + 1, j, p, res, visited);
        dfs(board, i, j + 1, p, res, visited);
        visited[i][j] = false;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    class Trie {
        TrieNode root = new TrieNode();

        public void putAWord(String word) {
            TrieNode trie = root;
            for(int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(trie.next[ch - 'a'] == null) {
                    trie.next[ch - 'a'] = new TrieNode();
                }
                trie = trie.next[ch - 'a'];
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
                if(trie.next[ch - 'a'] == null) {
                    return false;
                }
                trie = trie.next[ch - 'a'];
            }
            return trie.word.equalsIgnoreCase(word);
        }

        public boolean doesPrefixExists(String word) {
            TrieNode trie = root;
            for(int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(trie.next[ch - 'a'] == null) {
                    return false;
                }
                trie = trie.next[ch - 'a'];
            }
            return true;
        }

    }
    public List<String> findWordsBruteForce(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        Trie trie = new Trie();
        for(String word : words) {
            trie.putAWord(word);
        }


        if(board == null || board.length == 0 || board[0].length == 0) {
            return new ArrayList<>();
        }
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                helper(board, i, j, "", visited, result, trie);
            }
        }


        return new ArrayList<>(result);
    }

    private void helper(char[][] board, int i, int j, String wordSoFar, boolean[][] visited,
                        Set<String> result, Trie trie) {
        int n = board.length;
        int m = board[0].length;


        if(i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || !trie.doesPrefixExists(wordSoFar)) {
            return;
        }

        wordSoFar += board[i][j];

        if(trie.doesWordExists(wordSoFar)) {
            result.add(wordSoFar);
        }
        visited[i][j] = true;

        helper(board, i + 1, j, wordSoFar, visited, result, trie);
        helper(board, i - 1, j, wordSoFar, visited, result, trie);
        helper(board, i, j + 1, wordSoFar, visited, result, trie);
        helper(board, i, j - 1, wordSoFar, visited, result, trie);

        visited[i][j] = false;

    }
}
