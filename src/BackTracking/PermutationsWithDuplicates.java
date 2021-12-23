package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsWithDuplicates {


    public static void main(String[] args) {

        for(List<Character> list : permuteUniqueString(new char[]{'a', 'b', 'c'})){
            System.out.println(list);
        }

    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue; //Skip if its duplicate
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static List<List<Character>> permuteUniqueString(char[] nums) {
        List<List<Character>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private static void backtrack(List<List<Character>> list, List<Character> tempList, char [] nums, boolean [] used){
        if(tempList.size() == nums.length){
            if(isPalindrome(tempList))
                list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(List<Character> s){
        if (s == null || s.size() == 0) return true;
        int i = 0, j = s.size() - 1;
        while (i < j) {
            final char ic = s.get(i);
            final char jc = s.get(j);
            if (!Character.isLetterOrDigit(ic)) { i++; continue; }
            if (!Character.isLetterOrDigit(jc)) { j--; continue; }
            if (ic != jc) return false;
            i++; j--;
        }
        return true;
    }

}
