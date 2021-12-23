package TwoPointers;

import java.util.*;

public class ThreeSum {


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        //threeSumAlternate(nums);
        for(List<Integer> list : threeSum(nums, -1)){
            System.out.println(list);
        }


    }

    public static List<List<Integer>> threeSum(int[] nums, int sum) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        // generate map of values -> count
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : nums) {
            int count = map.getOrDefault(a, 0);
            map.put(a, count + 1);
        }

        // find 3 sums
        List<List<Integer>> results = new ArrayList<>();
        for (int a : map.keySet()) {
            map.put(a, map.get(a) - 1);
            for (int b : map.keySet()) {
                map.put(b, map.get(b) - 1);
                int c = sum - (a + b);
                if (map.get(b) >= 0 && a <= b && b <= c && map.containsKey(c) && map.get(c) > 0) {
                    results.add(Arrays.asList(new Integer[]{a, b, c}));
                }
                map.put(b, map.get(b) + 1);
            }
            map.put(a, map.get(a) + 1);
        }
        return results;
    }

    public List<List<Integer>> threeSumAlternate(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            int target = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                    while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }

    public int threeSumClosest(int[] nums, int target) {
        int result = 0;

        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {

            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum >= target) {
                    k--;
                } else {
                    j++;
                }
                if (Math.abs(sum - target) < minDiff) {
                    result = sum;
                    minDiff = Math.abs(sum - target);
                }
            }
        }
        return result;
    }
}

