package Misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IslandPerimeter {


    public static void main(String[] args) {


//        The grid is rectangular, width and height
//        don't exceed 100. Determine the perimeter of the island


    }
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int perimeter = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    int sides = 4;
                    if(i + 1 < n && grid[i + 1][j] == 1)
                        sides--;
                    if(i - 1 >= 0 && grid[i - 1][j] == 1)
                        sides--;
                    if(j + 1 < m && grid[i][j + 1] == 1)
                        sides--;
                    if(j - 1 >= 0 && grid[i][j - 1] == 1)
                        sides--;
                    perimeter += sides;
                }
            }
        }

        return perimeter;
    }
}
