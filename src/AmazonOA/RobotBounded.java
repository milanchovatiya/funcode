package AmazonOA;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import javafx.util.Pair;
import org.junit.Test;

public class RobotBounded {

//    On an infinite plane, a robot initially stands at (0, 0) and faces north. The robot can receive one of three instructions:
//
//            "G": go straight 1 unit;
//"L": turn 90 degrees to the left;
//"R": turn 90 degrees to the right.
//    The robot performs the instructions given in order, and repeats them forever.
//
//            Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.

    //Hint : The robot stays in the circle iff (looking at the final vector) it changes direction (ie. doesn't stay pointing north), or it moves 0.

    class Vector{
        Pair<Integer, Integer> pos;
        char dirn;

        public Vector(Pair<Integer, Integer> pos, char dirn) {
            this.pos = pos;
            this.dirn = dirn;
        }

    }
    public boolean isRobotBounded(String instructions) {
        Vector start = new Vector(new Pair<>(0, 0), 'N');
        int[] dx = new int[]{0, 1, -1, 0};
        int[] dy = new int[]{1, 0, 0, -1};
        String dirMap = "NEWS";
        String instMap = "LR";
        char[][] directions = new char[][]{
                {'W', 'E'},
                {'N', 'S'},
                {'S', 'N'},
                {'E', 'W'}
        };
        for(Character inst : instructions.toCharArray()){
            char oldDirn = start.dirn;
            int dirIndex = dirMap.indexOf(oldDirn);
            if(inst == 'L' || inst == 'R') {
                start.dirn = directions[dirIndex][instMap.indexOf(inst)];
            } else {
                Pair<Integer, Integer> oldPos = start.pos;
                start.pos = new Pair<>(oldPos.getKey() + dx[dirIndex], oldPos.getValue() + dy[dirIndex]);
            }
        }

        if((start.pos.getKey() == 0 && start.pos.getValue() == 0) || start.dirn != 'N') {
            return true;
        }
        return false;

    }

    @Test
    public void robotBoundedTest() {

        List<List<Integer>> options = Arrays.asList(Arrays.asList(2, 3), Arrays.asList(4), Arrays.asList(2, 3), Arrays.asList(1, 2));
        assertTrue(isRobotBounded("LLGRL"));
    }


}
