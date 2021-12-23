package Misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseWords {


    public static void main(String[] args) {

        reverseWordsInPlace("a good   example".toCharArray());
    }

    public static String reverseWordsWithoutSplit(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while(i >= 0){
            if(s.charAt(i) == ' '){
                i--;
                continue;
            }
            int start = s.lastIndexOf(' ', i);
            sb.append(' ');
            sb.append(s.substring(start + 1, i + 1));
            i = start - 1;
        }
        if(sb.length() > 0){
            sb.deleteCharAt(0);
        }

        return sb.toString();

    }
    public static String reverseWords(String s) {
        String[] wordArr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = wordArr.length - 1; i >= 0; i--){
            if(!wordArr[i].isEmpty())
                sb.append(wordArr[i]).append(" ");
        }
        return sb.toString().trim();
    }

    public static void reverseWordsInPlace(char[] str) {
        reverseStr(str, 0, str.length - 1);
        int start = 0;
        for(int i = 0; i < str.length; i++){
            if(str[i] == ' '){
                reverseStr(str, start, i - 1);
                start = i + 1;
            }
        }
        reverseStr(str, start, str.length - 1);

    }

    public static void reverseStr(char[] str, int low, int high){
        while(low <= high){
            char temp = str[low];
            str[low] = str[high];
            str[high] = temp;
            low++;
            high--;
        }
    }
}
