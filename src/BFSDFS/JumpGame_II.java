package BFSDFS;

import java.util.*;

public class JumpGame_II {


    public static void main(String[] args) {

//        Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//        Each element in the array represents your maximum jump length at that position.
//
//                Your goal is to reach the last index in the minimum number of jumps.




    }
    public int jumpBFS(int[] nums) {
        int n = nums.length;
        ArrayList<Integer>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = 1; j <= nums[i] && i + j < n; j++)
                list.add(i + j);
            graph[i] = list;
        }
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int minDist = 0;
        queue.add(new int[]{0,0});
        while(!queue.isEmpty()){
            int[] nodeArr = queue.remove();
            int node = nodeArr[0];
            int dist = nodeArr[1];
            visited[node] = true;
            if(node == n - 1){
                minDist = dist;
                break;
            }

            for(Integer i : graph[node]){
                if(!visited[i])
                    queue.add(new int[]{i, dist + 1});
            }

        }
        return minDist;

    }
    //Greedy Algo
//    The main idea is based on greedy. Let's say the range of the current jump is [curBegin, curEnd],
//    curFarthest is the farthest point that all points in [curBegin, curEnd] can reach.
//    Once the current point reaches curEnd, then trigger another jump, and set the new
//    curEnd with curFarthest, then keep the above steps, as the following:

    public int jumpSinglePass(int[] A) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + A[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
}
