package Subarray;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubarraysWithKDifferentIntegers {


    public static void main(String[] args) {


//        Given an array A of positive integers, call a (contiguous, not necessarily distinct)
// subarray of A good if the number of different integers in that subarray is exactly K.

//        (For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)
//
//        Return the number of good subarrays of A.

//        Input: A = [1,2,1,2,3], K = 2
//        Output: 7
//        Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
        System.out.println(subarraysWithKDistinct(new int[]{3,2,3,4}, 1));
        System.out.println(subarraysWithKDistinctBruteForce(new int[]{3,2,3,4}, 1));

    }

    public static int subarraysWithKDistinctBruteForce(int[] A, int K) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < A.length; i++){
            set.add(A[i]);
            for(int j = i; j < A.length; j++){
                if(!set.contains(A[j]) && set.size() > K)
                    continue;
                set.add(A[j]);
                if(set.size() == K)
                    count++;
            }
            //System.out.println(set);
            set.clear();
        }
        return count;
    }

//    We'll maintain two sliding windows, corresponding to left1j and left2j
//        . Each sliding window will be able to count how many different elements there are in the window,
// and add and remove elements in a queue-like fashion.
    public static int subarraysWithKDistinct(int[] A, int K) {
    Window window1 = new Window();
    Window window2 = new Window();
    int ans = 0, left1 = 0, left2 = 0;

    for (int right = 0; right < A.length; ++right) {
        int x = A[right];
        window1.add(x);
        window2.add(x);

        while (window1.different() > K)
            window1.remove(A[left1++]);
        while (window2.different() >= K)
            window2.remove(A[left2++]);

        ans += left2 - left1;
    }

    return ans;
}
}

class Window {
    Map<Integer, Integer> count;
    int nonzero;

    Window() {
        count = new HashMap();
        nonzero = 0;
    }

    void add(int x) {
        count.put(x, count.getOrDefault(x, 0) + 1);
        if (count.get(x) == 1)
            nonzero++;
    }

    void remove(int x) {
        count.put(x, count.get(x) - 1);
        if (count.get(x) == 0)
            nonzero--;
    }

    int different() {
        return nonzero;
    }
}


