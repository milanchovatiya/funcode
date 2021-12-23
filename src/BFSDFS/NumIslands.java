package BFSDFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumIslands {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {

        char[][] graph = new char[][]{{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};
        System.out.println(numIslandsBFSAlternate(graph));

        List<List<Integer>> forest = new ArrayList<>();
        List<Integer> trees1 = new ArrayList<>();
        trees1.add(1);
        trees1.add(1);
        trees1.add(1);
        trees1.add(1);
        trees1.add(0);
        forest.add(trees1);

        List<Integer> trees2 = new ArrayList<>();
        trees2.add(1);
        trees2.add(1);
        trees2.add(0);
        trees2.add(1);
        trees2.add(0);
        forest.add(trees2);

        List<Integer> trees3 = new ArrayList<>();
        trees3.add(1);
        trees3.add(1);
        trees3.add(0);
        trees3.add(0);
        trees3.add(0);
        forest.add(trees3);

        List<Integer> trees4 = new ArrayList<>();
        trees3.add(0);
        trees3.add(0);
        trees3.add(0);
        trees4.add(0);
        trees4.add(0);
        forest.add(trees4);

        //System.out.println(distBFS(forest,0 ,0,4,4));




    }

    static void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }

    public static int numIslandsBFS(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    grid[r][c] = '0'; // mark as visited
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            neighbors.add((row-1) * nc + col);
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row+1][col] == '1') {
                            neighbors.add((row+1) * nc + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            neighbors.add(row * nc + col-1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col+1] == '1') {
                            neighbors.add(row * nc + col+1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }

        return num_islands;
    }

    public static int numIslandsBFSAlternate(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    grid[r][c] = '0';
                    // mark as visited
                    Queue<int[]> queue = new LinkedList();
                    queue.add(new int[]{r, c});
                    boolean[][] seen = new boolean[nr][nc];
                    seen[r][c] = true;
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        for (int di = 0; di < 4; ++di) {
                            int i = cur[0] + dr[di];
                            int j = cur[1] + dc[di];
                            if (0 <= i && i < nr && 0 <= j && j < nc &&
                                    !seen[i][j] && grid[i][j] == '1') {
                                seen[i][j] = true;
                                grid[i][j] = '0';
                                queue.add(new int[]{i, j});
                            }
                        }
                    }
                }
            }
        }

        return num_islands;
    }
}
