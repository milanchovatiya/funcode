package BFSDFS;

import java.util.*;

class Node{
    int point;
    int distance;
    public Node(int point, int distance){
        this.point = point;
        this.distance = distance;
    }
}

public class ShortestBridge {

    public static void main(String[] args) {

       int[][] graph = new int[][]{{1,1,1,1,1}, {1,0,0,0,1}, {1,0,1,0,1}, {1,0,0,0,1}, {1,1,1,1,1}};
       // int[][] graph = new int[][]{{0,1}, {1,0}};

        shortestBridge(graph);




    }

    public static void dfs(int[][] A, int r, int c, List<int[]> island){
        int n = A.length;
        if(r >= n || r < 0 || c >= n || c < 0 || A[r][c] == 0)
            return;

        island.add(new int[]{r, c});
        dfs(A, r + 1, c, island);
        dfs(A, r - 1, c, island);
        dfs(A, r, c + 1, island);
        dfs(A, r, c - 1, island);
    }

    public static int shortestBridge(int[][] A) {

        List<List<int[]>> islands = new ArrayList<>();
        int nr = A.length;
        int nc = A[0].length;
        boolean[][] seen = new boolean[nr][nc];

        for(int r = 0; r < nr; r++){
            for(int c = 0; c < nc; c++){
                if(A[r][c] == 1){
                    List<int[]> island = new ArrayList<>();
                    dfs(A, r, c, island, seen);
                    if(!island.isEmpty())
                        islands.add(island);
                }
            }
        }

        List<int[]> source = islands.get(0);
        List<int[]> destination = islands.get(1);
        Set<Integer> destSet = new HashSet<>();
        for(int[] point : destination){
            destSet.add(point[0] * nc + point[1]);
        }
        int min = Integer.MAX_VALUE;
        for(int[] point : source) {
            Queue<Node> queue = new LinkedList<>();

            boolean[][] visited = new boolean[nr][nc];
            int id = point[0] * nc + point[1];
            queue.add(new Node(id, 0));
            while (!queue.isEmpty()) {
                Node n = queue.poll();
                int row = n.point / nc;
                int col = n.point % nc;
                int dist = n.distance;
                if (destSet.contains(row * nc + col)) {
                    if (n.distance < min)
                        min = n.distance;
                    break;
                }
                if (row + 1 < nr && !visited[row + 1][col]) {
                    queue.add(new Node((row + 1) * nc + col, dist + 1));
                    visited[row + 1][col] = true;
                }
                if (row - 1 >= 0 && !visited[row - 1][col]) {
                    queue.add(new Node((row - 1) * nc + col, dist + 1));
                    visited[row - 1][col] = true;
                }
                if (col + 1 < nc && !visited[row][col + 1]) {
                    queue.add(new Node(row * nc + (col + 1), dist + 1));
                    visited[row][col + 1] = true;
                }
                if (col - 1 >= 0 && !visited[row][col - 1]) {
                    queue.add(new Node(row * nc + (col - 1), dist + 1));
                    visited[row][col - 1] = true;
                }


            }

        }
        return min - 1;


    }

    public static void dfs(int[][] A, int r, int c, List<int[]> island, boolean[][] seen){
        int n = A.length;
        if(r >= n || r < 0 || c >= n || c < 0 || A[r][c] == 0 || seen[r][c])
            return;

        seen[r][c] = true;
        island.add(new int[]{r, c});
        dfs(A, r + 1, c, island, seen);
        dfs(A, r - 1, c, island, seen);
        dfs(A, r, c + 1, island, seen);
        dfs(A, r, c - 1, island, seen);
    }
}
