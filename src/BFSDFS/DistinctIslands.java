package BFSDFS;

import java.util.*;

public class DistinctIslands {


    public static void main(String[] args) {

    //Using direction strings to check the duplicate island


    }
    public int numDistinctIslands(int[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        Set<String> set = new HashSet<>();
        int numIsland = 0;
        for(int i = 0; i < nr; i++){
            for(int j = 0; j < nc; j++){
                if(grid[i][j] == 1){
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, "o");
                    set.add(sb.toString());
                }
            }
        }

        return set.size();

    }


    public void dfs(int[][] grid, int r, int c, StringBuilder sb, String dir){
        int nr = grid.length;
        int nc = grid[0].length;
        if(r < 0 || r >= nr || c < 0 || c >= nc || grid[r][c] == 0)
            return;

        grid[r][c] = 0;
        sb.append(dir);
        dfs(grid, r + 1, c, sb, "d");
        dfs(grid, r - 1, c, sb, "u");
        dfs(grid, r, c + 1, sb, "r");
        dfs(grid, r, c - 1, sb, "l");
        sb.append("b");
    }
}
