package Design;

import java.util.LinkedList;

public class HitCounter {
    LinkedList<Integer> list;

    /** Initialize your data structure here. */
    public HitCounter() {
        list = new LinkedList<Integer>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        list.addFirst(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        if(!list.isEmpty()){
            while(!list.isEmpty()){
                int oldestTS = list.peekLast();
                if(timestamp - oldestTS >= 300)
                    list.removeLast();
                else
                    break;
            }
        }
        return list.size();
    }

    public static void main(String[] args) {

        HitCounter obj = new HitCounter();
        obj.hit(1);
        obj.hit(1);
        obj.hit(1);
        obj.hit(300);
        System.out.println(obj.getHits(300));
        obj.hit(300);
        System.out.println(obj.getHits(300));
        obj.hit(301);
        System.out.println(obj.getHits(301));
//        System.out.println(obj.getHits(302));
//        System.out.println(obj.getHits(303));
//        System.out.println(obj.getHits(304));
//        System.out.println(obj.getHits(600));


    }
}
