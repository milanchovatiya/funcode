package BFSDFS;

import java.util.*;

public class ZeroOneMatrix {


    public static void main(String[] args) {



        int[][] graph = new int[][]{{0 ,0 ,0}, {0, 1, 0}, {1,1,1}};
        // int[][] graph = new int[][]{{0,1}, {1,0}};

        updateMatrixAlternate(graph);



    }

    //Start from 1 and keep updating the distances
    public static int[][] updateMatrix(int[][] matrix) {
        int nr = matrix.length;
        int nc = matrix[0].length;

        for(int i = 0; i < nr; i++){
            for(int j = 0; j < nc; j++){
                if(matrix[i][j] == 1){
                    Queue<int []> queue = new LinkedList<>();
                    queue.add(new int[]{i * nc + j, 0});
                    boolean[][] visited = new boolean[nr][nc];
                    visited[i][j] = true;
                    while(!queue.isEmpty()){
                        int[] id = queue.remove();
                        int r = id[0] / nc;
                        int c = id[0] % nc;
                        int distance = id[1];
                        if(matrix[r][c] == 0){
                            matrix[i][j] = distance;
                            break;
                        }
                        if(r + 1 < nr && !visited[r + 1][c]){
                            queue.add(new int[]{(r + 1) * nc + c, distance + 1});
                            visited[r + 1][c] = true;
                        }
                        if(r - 1 >= 0 && !visited[r - 1][c]){
                            queue.add(new int[]{(r - 1) * nc + c, distance + 1});
                            visited[r - 1][c] = true;
                        }
                        if(c + 1 < nc && !visited[r][c + 1]){
                            queue.add(new int[]{r * nc + (c + 1), distance + 1});
                            visited[r][c + 1] = true;
                        }
                        if(c - 1 >= 0 && !visited[r][c - 1]){
                            queue.add(new int[]{r* nc + (c - 1), distance + 1});
                            visited[r][c - 1] = true;
                        }
                    }
                }
            }
        }

        return matrix;
    }
    //Start from Zero and keep updating the distance
    public static int[][] updateMatrixAlternate(int[][] matrix) {
        int nr = matrix.length;
        int nc = matrix[0].length;

        int[][] res = new int[nr][nc];
        for(int i = 0; i < nr; i++){
            for(int j = 0; j < nc; j++){
                if(matrix[i][j] == 1)
                    res[i][j] = Integer.MAX_VALUE;
                else
                    res[i][j] = 0;
            }
        }

        for(int i = 0; i < nr; i++){
            for(int j = 0; j < nc; j++){
                if(matrix[i][j] == 0){
                    Queue<int []> queue = new LinkedList<>();
                    queue.add(new int[]{i * nc + j, 0});
                    boolean[][] visited = new boolean[nr][nc];
                    visited[i][j] = true;
                    while(!queue.isEmpty()){
                        int[] id = queue.remove();
                        int r = id[0] / nc;
                        int c = id[0] % nc;
                        int distance = id[1];
                        if(matrix[r][c] == 1){
                            if(distance < res[r][c])
                                res[r][c] = distance;
                        }
                        if(r + 1 < nr && !visited[r + 1][c]){
                            queue.add(new int[]{(r + 1) * nc + c, distance + 1});
                            visited[r + 1][c] = true;
                        }
                        if(r - 1 >= 0 && !visited[r - 1][c]){
                            queue.add(new int[]{(r - 1) * nc + c, distance + 1});
                            visited[r - 1][c] = true;
                        }
                        if(c + 1 < nc && !visited[r][c + 1]){
                            queue.add(new int[]{r * nc + (c + 1), distance + 1});
                            visited[r][c + 1] = true;
                        }
                        if(c - 1 >= 0 && !visited[r][c - 1]){
                            queue.add(new int[]{r * nc + (c - 1), distance + 1});
                            visited[r][c - 1] = true;
                        }
                    }
                }
            }
        }

        return res;
    }
}
