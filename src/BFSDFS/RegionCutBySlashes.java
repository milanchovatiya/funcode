package BFSDFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RegionCutBySlashes {


    public static void main(String[] args) {


        System.out.println(regionsBySlashes(new String[]{"/\\","\\/ "}));


    }


    public static int regionsBySlashes(String[] grid) {
        int n;
        if (grid == null || (n = grid.length) ==0)
            return 0;
        int[][] nums = new int[3 * n][3 * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '/') {
                    nums[i * 3][j * 3 + 2] = 1;
                    nums[i * 3 + 1][j * 3 + 1] = 1;
                    nums[i * 3 + 2][j * 3] = 1;
                }
                if (c == '\\') {
                    nums[i * 3][j * 3] = 1;
                    nums[i * 3 + 1][j * 3 + 1] = 1;
                    nums[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (nums[i][j] == 0) {
                    cnt++;
                    dfs(nums, i, j);
                }
            }
        }
        return cnt;
    }

    public static void dfs(int[][] nums, int x, int y) {
        if (x < 0 || x >= nums.length || y < 0 || y >= nums.length || nums[x][y] != 0)
            return;
        nums[x][y] = 1;
        dfs(nums, x - 1, y);
        dfs(nums, x + 1, y);
        dfs(nums, x, y - 1);
        dfs(nums, x, y + 1);
    }
}
