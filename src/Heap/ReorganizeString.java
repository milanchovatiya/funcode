package Heap;

import java.util.PriorityQueue;

public class ReorganizeString {

//    Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
//
//    Return any possible rearrangement of s or return "" if not possible.
//
//
//
//    Example 1:
//
//    Input: s = "aab"
//    Output: "aba"
//    Example 2:
//
//    Input: s = "aaab"
//    Output: ""

    class Count{
        Character letter;
        int count;
        public Count(Character letter, int count) {
            this.letter = letter;
            this.count = count;
        }
    }
    public String reorganizeString(String s) {

        PriorityQueue<Count> queue = new PriorityQueue<>((c1, c2) -> Integer.compare(c2.count, c1.count));
        int[] map = new int[26];
        for(Character c : s.toCharArray()) {
            map[c - 'a'] = map[c - 'a'] + 1;
        }
        for(char c = 'a'; c <= 'z'; c++) {
            if(map[c - 'a'] > 0) {
                queue.add(new Count(c, map[c - 'a']));
            }
        }

        String result = "";
        Count prev = new Count('0', -1);
        while(!queue.isEmpty()) {
            if(queue.size() == 1 && queue.peek().count > 1) return "";
            Count first = queue.poll();
            Count second = null;
            if(!queue.isEmpty()) {
                second = queue.remove();
            }

            result += first.letter;
            first.count = first.count - 1;
            if(first.count > 0) {
                queue.add(first);
            }
            if(second != null) {
                result += second.letter;
                second.count = second.count - 1;
                if(second.count > 0) {
                    queue.add(second);
                }
            }

        }
        return result;

    }
}
