package Misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CountJudge {


    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 3},
                {1 ,4},
                {2, 3},
                {2, 4},
                {4, 3}
        };
        findJudge(4, input);



    }
    public static int findJudge(int N, int[][] trust) {
        int[] judge = new int[N];
        for(int[] pair : trust){
            judge[pair[0]-1]--;
            judge[pair[1]-1]++;
        }
        for(int i = 0; i < N; i++) {
            if(judge[i] == N-1) return i+1;
        }
        return -1;
    }
}
