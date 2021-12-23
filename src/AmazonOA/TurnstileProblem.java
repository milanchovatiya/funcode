package AmazonOA;

import com.sun.tools.javac.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import org.junit.Assert;
import org.junit.Test;

public class TurnstileProblem {

    @Test
    public void SongPairProblemTest() {
//        int[] time = new int[]{0, 0, 1, 5};
//        int[] dirn = new int[]{0, 1, 1, 0};

        int[] time = new int[]{1, 1, 3, 3, 4, 5, 6, 7, 7};
        int[] dirn = new int[]{1, 1, 0, 0, 0, 1, 1, 1, 1};


        Assert.assertTrue(Arrays.equals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, findTime(time, dirn)));
    }

    private int[] findTime(int[] time, int[] dir) {
     if(time.length == 0 || time.length == 1) {
         return time;
     }
     int i = 0, j = 1;
     while(i < time.length && j < time.length) {
         if(time[i] == time[j] && dir[i] != dir[j]) {
             int index = decideWhoGoes(time, dir, i, j);
             if(index == i) {
                 time[j] += 1;
                 i++;
             }
             else {
                 time[i] += 1;
                 j++;
             }
         } else {
             time[j] += 1;
             i = j;
             j++;
         }
     }

     return time;
    }

    private int decideWhoGoes(int[] time, int[] dir, int i, int j) {
        int previousSec = time[i] - 1;
        int index = IntStream.range(0, time.length).filter(ele -> time[ele] == previousSec).findFirst().orElse(-1);
        int inIndex = dir[i] == 0 ? i : j;
        int outIndex = dir[j] == 1 ? j : i;
        if(index == -1 || dir[index] == 1) {
            return outIndex;
        }
        else {
            return inIndex;
        }
    }

}
