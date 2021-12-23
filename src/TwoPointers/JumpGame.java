package TwoPointers;

import java.util.ArrayList;

public class JumpGame {


    public static void main(String[] args) {


//        Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//        Each element in the array represents your maximum jump length at that position.
//                Determine if you are able to reach the last index.


    }

    //Solution
//    We call a position in the array a "good index" if starting at that position, we can reach the last index.
//            Otherwise, that index is called a "bad index".
//    The problem then reduces to whether or not index 0 is a "good index"
    public enum Index{
        Good, Bad, Unknown
    }

    public boolean canJumpBottomUp(int[] nums) {
        int n = nums.length;
        Index[] dp = new Index[n];
        for(int i = 0; i < n; i++){
            dp[i] = Index.Unknown;
        }
        dp[n - 1] = Index.Good;
        for(int i = n - 2; i >= 0; i--){
            int furthest = Math.min(n - 1, i + nums[i]);
            for(int j = i + 1; j <= furthest; j++){
                if(dp[j] == Index.Good)
                    dp[i] = Index.Good;
                    break;
            }
        }
        return dp[0] == Index.Good;
    }

    boolean hasReached = false;
    public boolean canJumpDFS(int[] nums) {
        int n = nums.length;
        ArrayList<Integer>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = 1; j <= nums[i] && i + j < n; j++){
                list.add(i + j);
            }
            graph[i] = list;
        }
        boolean[] visited = new boolean[n];

        dfs(0, graph, visited);
        return hasReached;
    }

    public void dfs(int node, ArrayList<Integer>[] graph, boolean[] visited){
        if(visited[node])
            return;

        visited[node] = true;
        //System.out.println(node);
        if(node == graph.length - 1)
            hasReached = true;

        for(Integer i : graph[node])
            dfs(i, graph, visited);
    }

    public boolean canJumpSinglePass(int[] nums) {
        int n = nums.length;
        int leftMostIndex = n - 1;
        for(int i = n - 1; i >= 0; i--){
            if(i + nums[i] >= leftMostIndex)
                leftMostIndex = i;
        }

        return leftMostIndex == 0;
    }


}
