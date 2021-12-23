package Design;

import java.util.*;

class MedianFinder {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        int n = maxHeap.size() + minHeap.size();
        if(n == 0){
            minHeap.add(num);
        }
        else{
            if(num >= minHeap.peek()){
                minHeap.add(num);
                if(minHeap.size()> n / 2 + 1){
                    maxHeap.add(minHeap.poll());
                }
            }
            else{
                maxHeap.add(num);
                if(maxHeap.size()> (n + 1) / 2){
                    minHeap.add(maxHeap.poll());

                }
            }
        }
    }



    public double findMedian() {
        int length = maxHeap.size() + minHeap.size();
        if(length % 2 != 0)
            return minHeap.peek();
        else
            return (double)(minHeap.peek() + maxHeap.peek()) / 2;
    }
    public static void main(String[] args) {


        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(3);
        obj.addNum(-1);
        obj.addNum(5);
        System.out.println(obj.findMedian());
    }
}

