import java.util.*;

public class OneEditDistance {


    public static void main(String[] args) {


        System.out.println(isOneEditDistance("a", ""));


    }
    public static boolean isOneEditDistance(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(m < n)
            return isOneEditDistance(t, s);

        if(s.equals(t))
            return false;
        if(Math.abs(n - m) > 1)
            return false;

        if(s.equals(t.substring(0, m)))
            return true;

        for(int i = 0; i < n; i++){
            if(s.charAt(i) != t.charAt(i)){
                if(m == n)
                    return s.substring(i + 1).equals(t.substring(i + 1));
                else
                    return s.substring(i).equals(t.substring(i + 1));
            }
        }

        return true;
    }
}
