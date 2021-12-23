package BFSDFS;

import java.util.*;

public class Itinerary {
    static Map<String, PriorityQueue> map = new HashMap<String, PriorityQueue>();
    static LinkedList result = new LinkedList<>();


    public static void main(String[] args) {


        String[][] ticket = new String[][]{
                {"JFK","SFO"},
                {"JFK","ATL"},
                {"SFO","ATL"},
                {"ATL","JFK"},
                {"ATL","SFO"}
        };

        String[][] ticket1 = new String[][]{
                {"JFK","KUL"},
                {"JFK","NRT"},
                {"NRT","JFK"}
        };

        System.out.println(findItinerary(ticket));
        System.out.println(findItineraryMy(ticket1));


    }

    public static List<String> findItinerary(String[][] tickets) {
        if(tickets.length == 0)
            return result;

        for(String[] ticket : tickets){
            if(!map.containsKey(ticket[0])){
                PriorityQueue<String> pq = new PriorityQueue<>();
                map.put(ticket[0],pq);
            }
            map.get(ticket[0]).offer(ticket[1]);


        }
        dfs("JFK");
        return result;


    }

    public  static void dfs(String s){
        PriorityQueue<String> q = new PriorityQueue<>();
        q = map.get(s);
        while(q != null && !q.isEmpty()){
            dfs(q.poll());
        }
        result.addFirst(s);
    }

    public static List<String> findItineraryMy(String[][] tickets) {

        Map<String, PriorityQueue<String>> indexMap = new HashMap<>();
        List<String> result = new ArrayList<>();
        for(int i = 0; i < tickets.length; i++){
            if(indexMap.containsKey(tickets[i][0])){
                PriorityQueue<String> queue = indexMap.get(tickets[i][0]);
                queue.add(tickets[i][1]);
            }
            else{
                PriorityQueue<String> queue = new PriorityQueue<String>();
                queue.add(tickets[i][1]);
                indexMap.put(tickets[i][0], queue);
            }
        }
        result.add("JFK");
        dfs(tickets, result, indexMap, "JFK");
        return result;
    }

    public static void dfs(String[][] tickets, List<String> result,Map<String, PriorityQueue<String>> indexMap, String start){
        if(!indexMap.containsKey(start) || indexMap.get(start).isEmpty()){
            return;
        }
        PriorityQueue<String> queue = indexMap.get(start);
        String dest = null;
        while(!queue.isEmpty()){
            dest = queue.remove();
            if(indexMap.containsKey(dest))
                break;
        }

        result.add(dest);
        dfs(tickets, result, indexMap, dest);
    }

}
