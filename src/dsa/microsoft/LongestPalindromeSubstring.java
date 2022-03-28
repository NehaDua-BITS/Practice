package dsa.microsoft;

public class LongestPalindromeSubstring {

    public static void main(String[] args) {
        LongestPalindromeSubstring obj = new LongestPalindromeSubstring();
        String str = "cbbd";
        System.out.println("Longest Palindrome Substring = " + obj.longestPalindrome(str));
    }

    private String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int length = s.length();
        boolean[][] isPalindrome = new boolean[length][length]; //store if substring (i,j) is palindrome or not
        int maxLength = 1;
        int startIndex = 0;

        //mark substr of length 1 as palindromes
        for (int i  = 0; i < length; i++) {
            isPalindrome[i][i] = true;
        }

        //check if substring of length 2 are palindrome or not
        for (int i = 0; i < length-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                isPalindrome[i][i + 1] = true;
                maxLength = 2;
                startIndex = i;
            }
        }

        //check palindrome for other substring lengths
        for (int k = 3; k <= length; k++) {
            for (int i = 0; i < length-k+1 ; i++) {
                isPalindrome[i][i+k-1] = isPalindrome[i+1][i+k-2] && (s.charAt(i) == s.charAt(i+k-1));
                if (isPalindrome[i][i+k-1]) {
                    maxLength = Math.max(maxLength, k);
                    startIndex = i;
                }
            }
        }

        return s.substring(startIndex, startIndex + maxLength);
    }

}
