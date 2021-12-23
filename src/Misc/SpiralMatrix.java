package Misc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class SpiralMatrix {


    public static void main(String[] args) {


        //Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.


    }

    public List<Integer> spiralOrderQueue(int[][] matrix) {
        int nr = matrix.length;
        int nc = matrix[0].length;
        if(nr == 0) {
            return new ArrayList<>();
        }
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};
        boolean[][] visited = new boolean[nr][nc];
        for(int i = 0; i < nr; i++) {
            for(int j = 0; j < nc; j++) {
                visited[i][j] = false;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0][0] = true;
        List<Integer> result = new ArrayList<>();
        int currDir = 0;
        while(!queue.isEmpty()) {
            int index = queue.remove();
            int row = index / nc;
            int col = index % nc;
            result.add(matrix[row][col]);
            int counter = 0;
            while(row + dr[currDir] < 0 || row + dr[currDir] >= nr ||  col + dc[currDir] < 0 || col + dc[currDir] >= nc
                    || visited[row + dr[currDir]][col + dc[currDir]]) {
                if(counter == 4) {
                    break;
                }
                currDir++;
                if(currDir % 4 == 0) {
                    currDir = 0;
                }
                counter++;
            }
            if(counter != 4) {
                int newNode = (row + dr[currDir]) * nc + (col + dc[currDir]);
                queue.add(newNode);
                visited[row + dr[currDir]][col + dc[currDir]] = true;
            }
        }
        return result;


    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int nr = matrix.length;
        if(nr == 0)
            return res;
        int nc = matrix[0].length;

        int rl = 0, rh = nr - 1, cl = 0, ch = nc - 1;
        int count = 0;
        while(rl <= rh && cl <= ch){
            System.out.println(count);
            fillValues(res, matrix, rl, rh, cl, ch);
            rl++;
            rh--;
            cl++;
            ch--;
        }

        return res;
    }

    public void fillValues(List<Integer> list, int[][] matrix,
                           int lr, int hr, int lc, int hc){
        for(int i = lc; i <= hc; i++)
            list.add(matrix[lr][i]);
        for(int i = lr + 1; i <= hr; i++)
            list.add(matrix[i][hc]);
        if(lr != hr){
            for(int i = hc - 1; i >= lc; i--)
                list.add(matrix[hr][i]);
        }
        if(lc != hc){
            for(int i = hr - 1; i > lr; i--)
                list.add(matrix[i][lc]);
        }

    }
}
