package Greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PartitionLabels {


    public static void main(String[] args) {


        partitionLabels("ababcbacadefegdehijhklij");

    }
    public static List<Integer> partitionLabels(String S) {
        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, S.lastIndexOf(S.charAt(i)));
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }
}
