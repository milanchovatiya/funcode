package BFSDFS;

import java.util.PriorityQueue;
import java.util.Queue;

class MaximumMinimumPath {


//    Given a matrix of integers A with R rows and C columns, find the maximum score of a path starting at [0,0] and ending at [R-1,C-1].
//
//    The score of a path is the minimum value in that path.  For example, the value of the path 8 →  4 →  5 →  9 is 4.
//
//    A path moves some number of times from one visited cell to any neighbouring unvisited cell in one of the 4 cardinal directions (north, east, west, south)


    static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};


    //For every cell, we keep track of the minimum which we have encountered so far and then use the max heap to choose
    // the next maximum value of all the minimum values stored in the heap!!
    public static int maximumMinimumPath(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        boolean[][] visited = new boolean[n][m];

        // in the BFS approach, for each step, we are interested in getting the maximum min that we have seen so far, thus we reverse the ordering in the pq
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);

        pq.offer(new int[]{0, 0, A[0][0]});

        // BFS
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int row = cell[0];
            int col = cell[1];

            if (row == n - 1 && col == m - 1) {
                return cell[2];
            }

            visited[row][col] = true;

            for (int[] dir : directions) {
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];

                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m || visited[nextRow][nextCol]) continue;

                // we are keeping track of the min element that we have seen until now
                pq.offer(new int[]{nextRow, nextCol, Math.min(cell[2], A[nextRow][nextCol])});
            }
        }
        return -1;
    }
}