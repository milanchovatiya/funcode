package BinarySearch;

public class ShipWithinDays {

//    A conveyor belt has packages that must be shipped from one port to another within D days.
//
//    The i-th package on the conveyor belt has a weight of weights[i].  Each day, we load the ship
//    with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.
//
//    Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within D days.
}

class Solution {
    public int shipWithinDays(int[] weights, int D) {
        // use binary search to find the optimal weight
        int low = 1, high = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            boolean can = canShip(weights, D, mid);
            if (can) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // check whether can ship under the given D and capacity
    private boolean canShip(int[] weights, int D, int capacity) {
        int day = 1, w = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > capacity || day > D) return false;
            if (w + weights[i] > capacity) {
                w = weights[i];
                day++;
            } else {
                w += weights[i];
            }
        }
        return day <= D;
    }
}
