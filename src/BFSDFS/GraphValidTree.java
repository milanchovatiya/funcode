package BFSDFS;

import java.util.ArrayList;
import java.util.Stack;

public class GraphValidTree {


    public static void main(String[] args) {

//        Given n nodes labeled from 0 to n-1 and a list of
//        undirected edges (each edge is a pair of nodes),
//        write a function to check whether these edges make up a valid tree.


        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 3}, {1, 4}};
        //System.out.println(validTree(5, edges));

    }
    public boolean validTree(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        if(edges.length == 0 && n == 1)
            return true;

        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < edges.length; i++){
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }

        if(!dfs(0, graph, visited, -1))
            return false;

        for(int i = 0; i < n; i++){
            if(!visited[i])
                return false;
        }
        return true;
    }

    public boolean dfs(int node, ArrayList<Integer>[] graph, boolean[] visited, int parent){
        if(visited[node]){
            return false;
        }
        visited[node] = true;

        for(Integer i : graph[node]){
            if(i != parent){
                if(!dfs(i, graph, visited, node)){
                    return false;
                }
            }
        }
        return true;
    }
}
