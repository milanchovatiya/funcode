import java.util.*;

public class Amazon {

    public static void main(String args[]){

        List<List<Integer>> networkRoutesAvailable = new ArrayList<>();
        List<Integer> route = new ArrayList<>();
        route.add(1);
        route.add(4);
        networkRoutesAvailable.add(route);
        List<Integer> route1 = new ArrayList<>();
        route1.add(4);
        route1.add(5);
        networkRoutesAvailable.add(route1);
        List<Integer> route2 = new ArrayList<>();
        route2.add(2);
        route2.add(3);
        networkRoutesAvailable.add(route2);

        List<List<Integer>> costNewNetworkRoutesConstruct = new ArrayList<>();
        List<Integer> route3 = new ArrayList<>();
        route3.add(1);
        route3.add(2);
        route3.add(5);
        costNewNetworkRoutesConstruct.add(route3);
        List<Integer> route4 = new ArrayList<>();
        route4.add(1);
        route4.add(3);
        route4.add(10);
        costNewNetworkRoutesConstruct.add(route4);
        List<Integer> route5 = new ArrayList<>();
        route5.add(1);
        route5.add(6);
        route5.add(2);
        costNewNetworkRoutesConstruct.add(route5);
        List<Integer> route6 = new ArrayList<>();
        route6.add(5);
        route6.add(6);
        route6.add(5);
        costNewNetworkRoutesConstruct.add(route6);

        minimumCost(6, 3,
                networkRoutesAvailable, 4, costNewNetworkRoutesConstruct);


    }


    public static int minimumCost(int numTotalEdgeNodes, int numTotalAvailableNetworkRoutes, List<List<Integer>> networkRoutesAvailable,
                           int numNewNetworkRoutesConstruct, List<List<Integer>> costNewNetworkRoutesConstruct){
        ArrayList<Integer>[] graph = new ArrayList[numTotalEdgeNodes + 1];

        for(int i = 1; i <= numTotalEdgeNodes; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < networkRoutesAvailable.size(); i++){
            List<Integer> edge = networkRoutesAvailable.get(i);
            List<Integer> list = graph[edge.get(0)];
            list.add(edge.get(1));
        }

        boolean[] visited = new boolean[numTotalEdgeNodes + 1];
        Map<Integer, HashSet<Integer>> dfsForestMap = new HashMap<>();
        List<HashSet<Integer>> dfsForest = new ArrayList<>();

        for(int i = 1; i <= numTotalEdgeNodes; i++){
            if(!visited[i]) {
                HashSet<Integer> forest = new HashSet<>();
                dfs(i, visited, graph, forest);
                dfsForest.add(forest);
                dfsForestMap.put(i, forest);
            }

        }
        Collections.sort(costNewNetworkRoutesConstruct, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return Integer.compare(o1.get(2), o2.get(2));
            }
        });
        int minimumCost = 0;
        int size = dfsForest.size();
        for(List<Integer> route : costNewNetworkRoutesConstruct){
            if(size == 1)
                break;
            minimumCost += route.get(2);
            size--;
        }

        return minimumCost;

    }

    private static void dfs(int i, boolean[] visited, ArrayList<Integer>[] graph, Set<Integer> forest) {
        if(visited[i])
            return;

        visited[i] = true;
        forest.add(i);
        for(Integer node : graph[i]){
            dfs(node, visited, graph, forest);
        }
    }
}
