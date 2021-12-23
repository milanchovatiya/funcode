import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Sense8 {

    static char[][] stringToChar(String[] stringArray)
    {
        char[][] charArray = new char[stringArray.length][stringArray[0].length()];
        for(int i = 0; i < stringArray.length; i++)
        {
            for(int j = 0; j < stringArray[0].length(); j++)
            {
                charArray[i][j] = stringArray[i].charAt(j);
            }
        }
        return charArray;
    }

    public static void main(String[] args){
        String[] str = new String[]{
                "ELEKTRAHTHORGV",
                "SILVERAORWTNSH",
                "AUAUAWREHSINUP",
                "HNERKCTNWHAMRR",
                "AFTEHSIITMASFA",
                "ICYMILDRRNCAEA",
                "IEIMAOIEEAERRL",
                "WWYTWNDVRMGEIO",
                "INVIDIBLEGAGRO",
                "TDHSPAEOHDCNOP",
                "CIOSKTTZTGEAND",
                "HFKOKPRNNLKRMA",
                "EBWOMANPAEUTAE",
                "UOFALCONPFLSND"
        };
        char[][] board = stringToChar(str);
//        char[][] board = new char[][]{
//                {'A', 'B', 'C', 'D'},
//                {'P', 'R', 'A', 'T'},
//                {'K', 'I', 'T', 'A'},
//                {'A', 'N', 'D', 'Y'},
//        };

          System.out.println(exist(board, "WITCH"));
//        List<String> input = Arrays.asList(new String[]{"ANTMAN", "DAREDEVIL", "DEADPOOL","ELEKTRA","HAWKEYE","PUNISHER",
//        "THING", "WITCH"});
//        for(String word : input){
//            System.out.println(exist(board, word));
//        }

    }
    public static boolean[][] visited;
    public static String exist(char[][] board, String word) {

        visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                char ch = board[i][j];
                //System.out.println(ch);
                if(ch == 'W')
                    System.out.println();
                if((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)){
                    System.out.println();
                    return word + " " + i + " " + j;
                }
            }
        }

        return word + " " + -1 + " " + -1;
    }

    private static boolean search(char[][]board, String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }

        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }
        System.out.println(board[i][j]);
        visited[i][j] = true;
        if(search(board, word, i-1, j, index+1) || // -1 0
                search(board, word, i+1, j, index+1) || // 1 0
                search(board, word, i, j-1, index+1) ||// 0 -1
                search(board, word, i, j+1, index+1) ||// 0 1

                search(board, word, i - 1, j - 1, index+1) ||// -1 -1
                search(board, word, i - 1, j + 1, index+1) ||// -1 1
                search(board, word, i + 1, j - 1, index+1) ||// 1 -1
                search(board, word, i + 1, j + 1, index+1) ){// 1 1
            return true;
        }

        visited[i][j] = false;
        return false;
    }
}
