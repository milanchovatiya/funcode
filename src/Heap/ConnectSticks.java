package Heap;

import java.util.PriorityQueue;

public class ConnectSticks {


    public static void main(String[] args) {

//        You have some sticks with positive integer lengths.
//
//        You can connect any two sticks of lengths X and Y into one stick by paying a cost of X + Y.  You perform this action until there is one stick remaining.
//
//                Return the minimum cost of connecting all the given sticks into one stick in this way.




    }


    public int connectSticks(int[] sticks) {
        int res = 0;
        int prev = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(Integer i : sticks){
            queue.add(i);
        }
        while(queue.size() > 1){
            int a = queue.remove();
            int b = queue.remove();
            res += a + b;
            queue.add(a + b);
        }

        return res;

    }



}

