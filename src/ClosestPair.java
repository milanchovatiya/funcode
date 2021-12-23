import java.util.*;

public class ClosestPair {


    public static void main(String[] args) {




        printClosest(new int[]{3000,5000,7000,10000}, new int[]{2000,3000,4000,5000}, 4, 4, 17000);

        //printClosest(new int[]{2000,4000,6000}, new int[]{2000}, 3, 1, 7000);

//        int[][] points = new int[][]{{1,3}, {-2, 2}};
//        kClosest(points, 1);


    }
    public static void printClosest(int ar1[], int ar2[], int m, int n, int x)
    {
        // Initialize the diff between pair sum and x.
        int diff = Integer.MAX_VALUE;
        Stack<List<Integer>> stack = new Stack<>();

        // res_l and res_r are result indexes from ar1[] and ar2[]
        // respectively
        int res_l = 0, res_r = 0, minDiff = Integer.MAX_VALUE;

        List<List<Integer>> resultList = new ArrayList<>();

        // Start from left side of ar1[] and right side of ar2[]
        int l = 0, r = n-1;
        while (l<m && r>=0)
        {
            int sumPair = ar1[l] + ar2[r];
            // If this pair is closer to x than the previously
            // found closest, then update res_l, res_r and diff
            if (sumPair - x <= diff && x - sumPair >= 0)
            {
                res_l = l;
                res_r = r;
                diff = Math.abs(sumPair - x);
                if(minDiff == diff){
                    List<Integer> pair = new ArrayList<>();
                    pair.add(res_l);
                    pair.add(res_r);
                    stack.push(pair);
                }
                if(diff < minDiff) {
                    minDiff = diff;
                    while(!stack.isEmpty())
                        stack.pop();
                    List<Integer> pair = new ArrayList<>();
                    pair.add(res_l);
                    pair.add(res_r);
                    stack.push(pair);
                }
            }

            // If sum of this pair is more than x, move to smaller
            // side
            if (sumPair > x)
                r--;
            else  // move to the greater side
                l++;
        }

//        if(diff != 0){
//            List<Integer> pair = new ArrayList<>();
//            pair.add(ar1[res_l]);
//            pair.add(ar2[res_r]);
//            resultList.add(pair);
//        }
        System.out.println(stack);
//        // Print the result
//        System.out.print("The closest pair is [" + ar1[res_l] +
//                ", " + ar2[res_r] + "]");
    }
}
