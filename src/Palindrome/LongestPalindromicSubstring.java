package Palindrome;

public class LongestPalindromicSubstring {


    public static void main(String[] args) {


        System.out.println(longestPalindromeLength("cbbd".toCharArray()));

    }

    public String longestPalindromeExpandAroundCentre(String s) {
        char[] sArr = s.toCharArray();
        if(sArr.length == 0)
            return "";
        int maxLength = 0;
        int start = 0, end = 0;
        int[] localPalindrome;
        for(int i = 0; i < sArr.length; i++){
            localPalindrome = getPalindromeLength(sArr, i, i);
            int length = localPalindrome[1] - localPalindrome[0] + 1;

            if(length > maxLength){
                maxLength = length;
                start = localPalindrome[0];
                end = localPalindrome[1];
            }
            localPalindrome = getPalindromeLength(sArr, i, i + 1);
            length = localPalindrome[1] - localPalindrome[0] + 1;
            if(length > maxLength){
                maxLength = length;
                start = localPalindrome[0];
                end = localPalindrome[1];
            }
        }

        return s.substring(start, end + 1);
    }

    public int[] getPalindromeLength(char[] sArr, int i, int j){
        while(i >= 0 && j < sArr.length && sArr[i] == sArr[j]){
            i--;
            j++;
        }
        i++;j--;
        return new int[]{i, j};
    }

    public static int longestPalindromeLength(char []str){
        boolean T[][] = new boolean[str.length][str.length];

        for(int i=0; i < T.length; i++){
            T[i][i] = true;
        }

        int max = 1;
        for(int l = 2; l <= str.length; l++){

            for(int i = 0; i < str.length - l + 1; i++){
                int j = i + l-1;
                int len = 0;
                if(l == 2){
                    if(str[i] == str[j]){
                        T[i][j] = true;
                        len = 2;
                    }
                }else{
                    if(str[i] == str[j] && T[i+1][j-1]){
                        T[i][j] = true;
                        len = j - i + 1;
                    }
                }
                if(len > max){
                    max = len;
                }
            }
        }
        return max;
    }

    public String longestPalindromeTusshar(String s) {
        char[] str = s.toCharArray();
        if(str.length == 0)
            return "";
        boolean T[][] = new boolean[str.length][str.length];
        String res = null;
        for(int i=0; i < T.length; i++){
            T[i][i] = true;
        }

        int max = 0;
        for(int l = 1; l <= str.length; l++){
            int len = 0;
            for(int i=0; i < str.length-l+1; i++){
                int j = i + l - 1;
                len = 0;
                if(l == 1){
                    len = 1;
                }
                else if(l == 2){
                    if(str[i] == str[j]){
                        T[i][j] = true;
                        len = 2;
                    }
                }else{
                    if(str[i] == str[j] && T[i+1][j-1]){
                        T[i][j] = true;
                        len = j -i + 1;
                    }
                }
                if(len > max){
                    max = len;
                    res = s.substring(i, j + 1);

                }
            }
        }
        return res;
    }


    public static String longestPalindrome(String s) {
        int n = s.length();
        String res = null;

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }

                display(dp);
                System.out.println("-------------------");

            }
        }

        return res;
    }

    public static void display(boolean[][] dp){
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
