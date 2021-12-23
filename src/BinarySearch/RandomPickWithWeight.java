package BinarySearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPickWithWeight {

    List<Integer> psum = new ArrayList<>();
    int tot = 0;
    Random rand = new Random();

    public RandomPickWithWeight(int[] w) {
        for (int x : w) {
            tot += x;
            psum.add(tot);
        }
    }

    public int pickIndex() {
        int targ = rand.nextInt(tot);

        int lo = 0;
        int hi = psum.size() - 1;
        while (lo != hi) {
            int mid = (lo + hi) / 2;
            if (targ >= psum.get(mid)) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }


    public static void main(String[] args) {


        int arr[] = { 1, 3, 4, 4};
        RandomPickWithWeight ob = new RandomPickWithWeight(arr);
        System.out.println(ob.pickIndex());
        System.out.println(ob.pickIndex());
        System.out.println(ob.pickIndex());
        System.out.println(ob.pickIndex());




    }


}
