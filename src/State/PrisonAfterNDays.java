package State;

import java.util.*;

public class PrisonAfterNDays {


    public static void main(String[] args) {
        int[] arr = new int[]{1,0,0,1,0,0,1,0};

        prisonAfterNDaysAlt(new int[]{1,0,0,1,0,0,1,0}, 100);


        System.out.println("");
        prisonAfterNDays(new int[]{1,0,0,1,0,0,1,0}, 100);

//        for(Integer i : arr){
//            System.out.print(i + " ");
//        }


    }
    public static int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> seen = new HashMap<>();

        while (N > 0) {
            seen.put(Arrays.toString(cells), N);
            N--;

            int cells2[] = new int[cells.length];

            for (int i = 1; i < 7; i++) {
                cells2[i] = cells[i-1] == cells[i+1] ? 1 : 0;
            }

            cells = cells2;

            String past = Arrays.toString(cells);

            if (seen.containsKey(past)) {
                int prevIndex = seen.get(past);
                N %= prevIndex - N;
            }
        }
        for(Integer i : cells){
            System.out.print(i + " ");
        }
        return cells;
    }

    public static int[] prisonAfterNDaysAlt(int[] cells, int N) {
        //Map<String, Integer> seen = new Subarray<>();
        Set<String> seen = new HashSet<>();

        int c = 1;
        while (c <= N) {

            int cells2[] = new int[cells.length];

            for (int i = 1; i < 7; i++) {
                cells2[i] = cells[i-1] == cells[i+1] ? 1 : 0;
            }

            cells = cells2;

            String past = Arrays.toString(cells);

            if(c == 1){
                seen.add(Arrays.toString(cells));
            }

            if (seen.contains(past) && c != 1) {
                N = c + (N % c);
            }
            c++;
        }
        for(Integer i : cells){
            System.out.print(i + " ");
        }

        return cells;
    }
}
