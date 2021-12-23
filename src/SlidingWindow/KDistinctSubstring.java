package SlidingWindow;

import java.util.*;

public class KDistinctSubstring {


    public static void main(String[] args) {

        System.out.println(subStringKDist("awaglknagawunagwkwagl", 4));
        System.out.println(subStringKDistSlidingWindow("awaglknagawunagwkwagl", 4));




    }

    //Optmization
    public static List<String> subStringKDistSlidingWindow(String s, int num) {
        int start = 0, end = 0;
        List<String> res = new ArrayList<>();
        Window window = new Window();

        while(end < s.length()){
            window.add(s.charAt(end));
            if(end - start + 1 == num){
                if(window.different() == num) {
                    if(!res.contains(s.substring(start, end + 1)))
                        res.add(s.substring(start, end + 1));
                }
                window.remove(s.charAt(start));
                start++;
            }
            end++;

        }
        return res;
    }
    public static List<String> subStringKDist(String inputStr, int num)
    {

        char[] sArr = inputStr.toCharArray();
        int strLen = sArr.length;

        HashSet<Character> set = new LinkedHashSet<>();
        List<String> result = new ArrayList<>();

        int l = 0;
        int r = 0;

        while(l <= strLen - num){
            for(int i = 0; i < num; i++){
                set.add(sArr[l]);
                l++;
            }
            String res = "";
            if(set.size() == num){
                for(Character c : set){
                    res += c;
                }
                if(!result.contains(res))
                    result.add(res);
            }
            set.clear();
            r++;
            l = r;
        }
        return result;

    }
}

class Window {
    Map<Character, Integer> count;
    int nonzero;

    Window() {
        count = new HashMap();
        nonzero = 0;
    }

    void add(Character x) {
        count.put(x, count.getOrDefault(x, 0) + 1);
        if (count.get(x) == 1)
            nonzero++;
    }

    void remove(Character x) {
        count.put(x, count.get(x) - 1);
        if (count.get(x) == 0)
            nonzero--;
    }

    int different() {
        return nonzero;
    }
}
