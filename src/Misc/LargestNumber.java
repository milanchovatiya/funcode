package Misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {


    public static void main(String[] args) {
        //Given a list of non negative integers, arrange them such that they form the largest number.


    }
//    First, we convert each integer to a string. Then, we sort the array of strings.
//
//    While it might be tempting to simply sort the numbers in descending order,
//            this causes problems for sets of numbers with the same leading digit.
//    For example, sorting the problem example in descending order would produce the number
//    9534330, while the correct answer can be achieved by transposing the 3 and the 30.
//    Therefore, for each pairwise comparison during the sort, we compare the numbers achieved
//    by concatenating the pair in both orders. We can prove that this sorts into the proper order as follows

    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for(Integer i : nums){
            list.add(String.valueOf(i));
        }
        Collections.sort(list, new Comparator<String>(){
            public int compare(String a, String b){
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);
            }
        });
        if (list.get(0).equals("0")) {
            return "0";
        }
        String res = "";
        for(String str : list){
            res += str;
        }
        return res;
    }
}
