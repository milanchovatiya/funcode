package BackTracking;

import java.util.*;

public class LetterCombinations {


    public static void main(String[] args) {


//        Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
//
//        A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


    }
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = backtracking(digits.toCharArray(), map);
        return res;
    }

    public List<String> backtracking(char[] digits, Map<Character, String> map){
        List<String> res = new ArrayList<>();
        for(int i = 0; i < digits.length; i++){
            List<String> temp = new ArrayList<>();
            String digit = map.get(digits[i]);
            if(res.isEmpty()){
                for(Character c : digit.toCharArray()){
                    temp.add("" + c);
                }
            }
            else{
                for(String comb : res){
                    for(Character c : digit.toCharArray()){
                        temp.add(comb + c);
                    }
                }
            }
            res = temp;
        }
        return res;
    }
}
