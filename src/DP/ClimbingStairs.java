package DP;

import java.util.LinkedList;
import java.util.List;
import java.util.*;

public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(35));
    }

    static class Node{
        int step;
        int remStairs;
        public Node(int step, int remStairs){
            this.step = step;
            this.remStairs = remStairs;
        }
    }
    public static int climbStairs(int n) {
        Queue<Node> queue = new LinkedList<>();
        List<Integer> steps = new ArrayList<>();
        steps.add(1);
        steps.add(2);
        if(n == 0)
            return 0;
        int result = 0;
        for(Integer i : steps){
            if(n - i >= 0)
                queue.add(new Node(i, n - i));
        }
        Map<Integer, Integer> map = new HashMap<>();


        while(!queue.isEmpty()){
            Node node = queue.remove();
            int remStairs = node.remStairs;
            if(remStairs == 0){
                result++;
                continue;
            }
            for(Integer i : steps){
                if(remStairs - i >= 0)
                    queue.add(new Node(i, remStairs - i));
            }
        }

        return result;
    }
}
