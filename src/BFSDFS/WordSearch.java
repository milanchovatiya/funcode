package BFSDFS;

//Given a 2D board and a word, find if the word exists in the grid.
public class WordSearch {

    public static void main(String[] args){
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'D'},
                {'P', 'R', 'A', 'T'},
                {'K', 'I', 'T', 'A'},
                {'A', 'N', 'D', 'Y'},
        };
        patternSearch(board, "ARCD");

    }
    public static boolean[][] visited;
    public static boolean exist(char[][] board, String word) {

        visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean search(char[][]board, String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }

        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }

        visited[i][j] = true;
        if(search(board, word, i-1, j, index+1) ||
                search(board, word, i+1, j, index+1) ||
                search(board, word, i, j-1, index+1) ||
                search(board, word, i, j+1, index+1)){
            return true;
        }

        visited[i][j] = false;
        return false;
    }

    // For searching in all 8 direction
    static int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };

    // This function searches in all 8-direction from point
    // (row, col) in grid[][]
    static boolean search2D(char[][] grid, int row,
                            int col, String word)
    {
        // If first character of word doesn't match with
        // given starting point in grid.
        if (grid[row][col] != word.charAt(0))
            return false;

        int len = word.length();

        // Search word in all 8 directions
        // starting from (row,col)
        for (int dir = 0; dir < 8; dir++)
        {
            // Initialize starting point
            // for current direction
            int k, rd = row + x[dir], cd = col + y[dir];

            // First character is already checked,
            //  match remaining characters
            for (k = 1; k < len; k++)
            {
                // If out of bound break
                if (rd >= grid.length || rd < 0 || cd >= grid[0].length || cd < 0)
                    break;

                // If not matched, break
                if (grid[rd][cd] != word.charAt(k))
                    break;

                // Moving in particular direction
                rd += x[dir];
                cd += y[dir];
            }

            // If all character matched, then value of must
            // be equal to length of word
            if (k == len)
                return true;
        }
        return false;
    }

    // Searches given word in a given
    // matrix in all 8 directions
    static void patternSearch(char[][] grid, String word)
    {
        // Consider every point as starting
        // point and search given word
        for (int row = 0; row < grid.length; row++)
        {
            for (int col = 0; col < grid[0].length; col++)
            {
                if (search2D(grid, row, col, word))
                    System.out.println("pattern found at " + row +
                            ", " + col);
            }
        }
    }
}
