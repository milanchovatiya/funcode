package Design;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class SnakeGame {

    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */

    int[][] f;
    int score = 0;
    int rows;
    int cols;
    LinkedList<int[]> snakeList;

    static Map<String, int[]> dirMap = new HashMap<>();

    static {
        dirMap.put("R", new int[]{ 0,  1});
        dirMap.put("L", new int[]{ 0, -1});
        dirMap.put("U", new int[]{-1,  0});
        dirMap.put("D", new int[]{ 1,  0});
    }

    public SnakeGame(int width, int height, int[][] food) {
        f = food;
        rows = height;
        cols = width;
        score = 0;
        snakeList = new LinkedList();
        snakeList.addFirst(new int[] {0, 0});
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] dir = dirMap.get(direction);
        //update head position
        int[] head = snakeList.getFirst();
        int[] headPosition = new int[] {head[0] + dir[0], head[1] + dir[1]};

        if (headPosition[0] < 0 || headPosition[0] >= rows ||
                headPosition[1] < 0 || headPosition[1] >= cols) {
            return -1;
        }
        //check if we eat the food
        if (f.length <= score || !(headPosition[0] == f[score][0] && headPosition[1] == f[score][1])) {
            snakeList.removeLast();
            //check if haven't eat ourselves
            Iterator<int[]> it = snakeList.iterator();
            while (it.hasNext()) {
                int[] curr = it.next();
                if (headPosition[0] == curr[0] && headPosition[1] == curr[1])
                    return -1;
            }
            snakeList.addFirst(headPosition);
        }
        else {
            score++;
            snakeList.addFirst(headPosition);
        }

        return score;
    }
}
