package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class KLengthSubstringsWithNoRepeatedCharacters {


    //Given a string S, return the number of substrings of length K with no repeated characters.


    public int numKLenSubstrNoRepeats(String S, int K) {
        Map<Character, Integer> map = new HashMap<>();
        int n = S.length();
        if(n < K)
            return 0;

        int l = 0, r = 0, count = 0;
        char[] arr = S.toCharArray();
        int res = 0;

        while(r < n){
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
            if(map.get(arr[r]) == 1)
                count++;

            if(r - l + 1 == K){
                if(count == K)
                    res++;
                map.put(arr[l], map.get(arr[l]) - 1);
                if(map.get(arr[l]) == 0)
                    count--;
                l++;
            }
            r++;
        }

        return res;
    }
}
