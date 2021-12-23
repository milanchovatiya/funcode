package AmazonOA;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Assert;
import org.junit.Test;

public class UniqueSubstringofSizeKProblem {

    //Given a string s and an int k, return all unique substrings of s of size k with k distinct characters.

    @Test
    public void uniqueSubstringofSizeKProblemTest() {

        List<String> expected = Arrays.asList("wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag");
        List<String> actual = getUniqueSubstrings("awaglknagawunagwkwagl", 4);
        assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
    }

    public static List<String> getUniqueSubstrings(String str, int k){
        int l = 0, r = 0;
        int count = 0;
        Set<String> resultSet = new HashSet<>();
        Map<Character, Integer> charCountMap = new HashMap<>();
        while(r < str.length()) {
            char rightChar = str.charAt(r);
            charCountMap.put(rightChar, charCountMap.getOrDefault(rightChar, 0) + 1);
            if(charCountMap.get(rightChar) == 1) {
                count++;
            }

            if( r - l + 1 == k) {
                if(count == k) {
                    resultSet.add(str.substring(l, r + 1));
                }
                char leftChar = str.charAt(l);
                charCountMap.put(leftChar, charCountMap.getOrDefault(leftChar, 0) - 1);
                if(charCountMap.get(leftChar) == 0) {
                    count--;
                }
                l++;
            }
            r++;
        }

        return new ArrayList<>(resultSet);
    }

}
