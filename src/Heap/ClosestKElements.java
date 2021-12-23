package Heap;

import java.util.*;

public class ClosestKElements {


    public static void main(String[] args) {

        kSmallestPairsOptimized(new int[]{1,7,11}, new int[]{2,4,6}, 9);




    }

//    Basic idea: Use min_heap to keep track on next minimum pair sum,
//    and we only need to maintain K possible candidates in the data structure.
//
//    Some observations: For every numbers in nums1, its best partner(yields min sum)
//    always strats from nums2[0] since arrays are all sorted; And for a specific number in
//    nums1, its next candidate sould be [this specific number] + nums2[current_associated_index + 1],
//    unless out of boundary;)
    public static List<int[]> kSmallestPairsOptimized(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->a[0]+a[1]-b[0]-b[1]);
        List<int[]> res = new ArrayList<>();
        if(nums1.length==0 || nums2.length==0 || k==0) return res;
        for(int i=0; i<nums1.length && i<k; i++) que.offer(new int[]{nums1[i], nums2[0], 0});
        while(k-- > 0 && !que.isEmpty()){
            int[] cur = que.poll();
            res.add(new int[]{cur[0], cur[1]});
            if(cur[2] == nums2.length-1) continue;
            que.offer(new int[]{cur[0],nums2[cur[2]+1], cur[2]+1});
        }
        return res;
    }

    public static List<int[]> kSmallestPairsBruteForce(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> heap = new PriorityQueue(new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2){
                return Integer.compare(p2.x + p2.y, p1.x + p1.y);
            }
        });

        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                if(heap.size() < k)
                    heap.add(new Pair(nums1[i], nums2[j]));
                else if((heap.peek().x + heap.peek().y) > (nums1[i] + nums2[j])){
                    heap.remove();
                    heap.add(new Pair(nums1[i], nums2[j]));
                }
            }
        }

        List<int[]> res = new ArrayList<>();
        while(!heap.isEmpty()){
            Pair p = heap.remove();
            res.add(new int[]{p.x,p.y});
        }
        return res;
    }
    static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


}

