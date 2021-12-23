package BFSDFS;

import javafx.util.Pair;

import java.util.*;

public class WordLadder {

    static class Node{
        String word;
        int distance;
        List<String> transSeq;

        public String getWord() {
            return word;
        }

        public int getDistance() {
            return distance;
        }

        public List<String> getTransSeq() {
            return transSeq;
        }

        public Node(String word, int distance, List<String> transSeq) {
            this.word = word;
            this.distance = distance;
            this.transSeq = transSeq;
        }
    }


    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");


        System.out.println(ladderLength("hit", "hot", list));


    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // Since all words are of same length.
        int L = beginWord.length();

        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        HashMap<String, ArrayList<String>> allComboDict = new HashMap<String, ArrayList<String>>();

        for(String word : wordList){
            for (int i = 0; i < L; i++) {
                // Key is the generic word
                // Value is a list of words which have the same intermediate generic word.
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                ArrayList<String> transformations =
                        allComboDict.getOrDefault(newWord, new ArrayList<String>());
                transformations.add(word);
                allComboDict.put(newWord, transformations);
            }
        }

        // Queue for BFS
        Queue<Node> Q = new LinkedList<>();
        Q.add(new Node(beginWord, 1, new ArrayList<>()));

        // Visited to make sure we don't repeat processing same word.
        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!Q.isEmpty()) {
            Node node = Q.remove();
            String word = node.getWord();
            int level = node.getDistance();
            List<String> transSeq = node.getTransSeq();
            for (int i = 0; i < L; i++) {

                // Intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                // Next states are all the words which share the same intermediate state.
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer.
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    // Otherwise, add it to the BFS Queue. Also mark it visited
                    if (!visited.containsKey(adjacentWord)) {
                        transSeq.add(adjacentWord);
                        visited.put(adjacentWord, true);
                        Q.add(new Node(adjacentWord, level + 1, transSeq));
                    }
                }
            }
        }

        return 0;
    }

    public static List<String> ladderPath(String beginWord, String endWord, List<String> wordList) {

        // Since all words are of same length.
        int L = beginWord.length();

        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        HashMap<String, ArrayList<String>> allComboDict = new HashMap<String, ArrayList<String>>();

        for(String word : wordList){
            for (int i = 0; i < L; i++) {
                // Key is the generic word
                // Value is a list of words which have the same intermediate generic word.
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                ArrayList<String> transformations =
                        allComboDict.getOrDefault(newWord, new ArrayList<String>());
                transformations.add(word);
                allComboDict.put(newWord, transformations);
            }
        }

        // Queue for BFS
        Queue<Node> Q = new LinkedList<>();
        Q.add(new Node(beginWord, 1, new ArrayList<>()));

        // Visited to make sure we don't repeat processing same word.
        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!Q.isEmpty()) {
            Node node = Q.remove();
            String word = node.getWord();
            int level = node.getDistance();
            List<String> transSeq = node.getTransSeq();
            for (int i = 0; i < L; i++) {

                // Intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                // Next states are all the words which share the same intermediate state.
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer.
                    if (adjacentWord.equals(endWord)) {
                        transSeq.add(endWord);
                        return transSeq;
                    }
                    // Otherwise, add it to the BFS Queue. Also mark it visited
                    if (!visited.containsKey(adjacentWord)) {
                        transSeq.add(adjacentWord);
                        visited.put(adjacentWord, true);
                        Q.add(new Node(adjacentWord, level + 1, transSeq));
                    }
                }
            }
        }

        return null;
    }
}
