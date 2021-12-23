package Misc;

public class AtoI {

    public static void main(String[] args){
    System.out.println(myAtoi("200000000000000"));
    }

//    Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
//
//            The algorithm for myAtoi(string s) is as follows:
//
//    Read in and ignore any leading whitespace.
//            Check if the next character (if not already at the end of the string) is '-' or '+'.
//            Read this character in if it is either. This determines if the final result is negative or positive respectively.
//            Assume the result is positive if neither is present.
//    Read in next the characters until the next non-digit charcter or the end of the input is reached. The rest of the string is ignored.
//    Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0.
//    Change the sign as necessary (from step 2).
//    If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range.
//    Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
//    Return the integer as the final result.
//            Note:
//
//    Only the space character ' ' is considered a whitespace character.
//    Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
    public static int myAtoi(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int n = s.length();
        int i =0;
        StringBuilder sb = new StringBuilder();
        int sign = 1; //positive
        //process white space
        while(i < n && s.charAt(i) == ' ') {
            i++;
        }
        //process +, -
        if( i < n && s.charAt(i) == '+') {
            sign =1;
            i++;
        }
        else if( i < n && s.charAt(i) == '-') {
            sign =-1;
            i++;
        }
        //process zero
        while(i < n && s.charAt(i) == '0') {
            i++;
        }
        //process digit
        if(i < n && !Character.isDigit(s.charAt(i))) {
            return 0;
        }
        else if( i < n && Character.isDigit(s.charAt(i))) {
            while(i < n && Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
                i++;
            }
        }
        String finalStr = sb.toString();
        //process the final string
        //just check for overflow in the final string
        i=0; n = finalStr.length(); int total =0;
        while( i < n) {
            int digit = finalStr.charAt(i) - '0';
            if((total > Integer.MAX_VALUE/10) ||
                    (total == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE%10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = 10*total + digit;
            i++;
        }
        return total * sign;
    }
}
