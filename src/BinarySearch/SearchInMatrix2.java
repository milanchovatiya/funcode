package BinarySearch;

public class SearchInMatrix2 {


    public static void main(String[] args) {

//        Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

//        Integers in each row are sorted in ascending from left to right.
//        Integers in each column are sorted in ascending from top to bottom.


    }

//    First, we initialize a (row, col)(row,col) pointer to the bottom-left of the matrix.[1]
//    Then, until we find target and return true (or the pointer points to a (row, col)
//    that lies outside of the dimensions of the matrix), we do the following: if the currently-pointed-to
//    value is larger than target we can move one row "up".
//    Otherwise, if the currently-pointed-to value is smaller than target, we can move one column "right".
    public boolean searchMatrix(int[][] matrix, int target) {
        int nr = matrix.length;
        if(nr == 0 || matrix[0].length == 0)
            return false;
        int nc = matrix[0].length;
        int i = nr - 1, j = 0;
        while(i >= 0 && j < nc){
            if(matrix[i][j] == target)
                return true;
            else if(matrix[i][j] > target)
                i--;
            else
                j++;

        }
        return false;
    }
}
