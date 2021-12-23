package BackTracking;

import java.util.List;

public class MaximumLengthConcatenatedStringwithUniqueCharacters {



//    Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.
//
//    Return the maximum possible length of s.
//
//
//
//            Example 1:
//
//    Input: arr = ["un","iq","ue"]
//    Output: 4
//    Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
//    Maximum length is 4.
//    Example 2:
//
//    Input: arr = ["cha","r","act","ers"]
//    Output: 6
//    Explanation: Possible solutions are "chaers" and "acters".
//    Example 3:
//
//    Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
//    Output: 26
    class WrapperResult {
        private int result;
        public void setResult(int value) {
            this.result = value;
        }
        public int getResult() {
            return this.result;
        }
    }
    public int maxLength(List<String> arr) {
        WrapperResult maxLength = new WrapperResult();
        int[] countMap = new int[26];
        helper(arr, 0, 0, maxLength, countMap);
        return maxLength.getResult();
    }

    private void helper(List<String> arr, int lengthSoFar, int index, WrapperResult maxLength, int[] countMap) {
        if(lengthSoFar > maxLength.getResult()) {
            maxLength.setResult(lengthSoFar);
        }
        for(int i = index; i < arr.size(); i++) {
            String str = arr.get(i);
            if(valid(str, countMap)) {
                helper(arr, lengthSoFar + str.length(), i + 1, maxLength, countMap);
            }
            removeStr(str, countMap);
        }
    }

    private boolean valid(String str, int[] countMap) {
        boolean hasDup = true;
        for(Character ch : str.toCharArray()) {
            int index = ch - 'a';
            countMap[index] = countMap[index] + 1;
            if(countMap[index] > 1) {
                hasDup = false;
            }
        }
        return hasDup;
    }

    private void removeStr(String str, int[] countMap) {
        for(Character ch : str.toCharArray()) {
            int index = ch - 'a';
            if(countMap[index] > 0) {
                countMap[index] = countMap[index] - 1;
            }
        }
    }
}
