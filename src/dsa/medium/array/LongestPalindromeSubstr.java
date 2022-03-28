package dsa.medium.array;

import java.util.HashMap;

public class LongestPalindromeSubstr {

    public static void main(String[] args) {
        LongestPalindromeSubstr obj = new LongestPalindromeSubstr();
        String s = "babad";
//        String substr = obj.longestPalindrome(s);
//        System.out.println("Longest Palindromic Substring = " + substr);
    }

//    public String longestPalindrome(String s) {
//
//        if (s == null || s.length() <= 1) return s;
//
//        StringBuilder longestPalindrome = new StringBuilder();
//        int maxLength = 0;
//
//        HashMap<String, Boolean> palindromeMap = new HashMap<>();
//        int length = s.length();
//        for (int start = 0; start < length; start++) {
//            for (int end = 2; end <= length; end++) {
//                String substr = s.substring(start, end);
//                boolean isPalindrome = true;
//                if (s.charAt(start) != s.charAt(end-1)) {
//                    palindromeMap.put(substr, false);
//                    continue;
//                }
//
//                if ()
//            }
//        }
//    }
}
