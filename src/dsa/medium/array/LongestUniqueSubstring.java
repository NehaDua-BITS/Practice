package dsa.medium.array;

import java.util.Arrays;

public class LongestUniqueSubstring {

    public static void main(String[] args) {
        LongestUniqueSubstring obj = new LongestUniqueSubstring();
        String s = "abcabcbb";
        System.out.println("Length of longest unique substring : " + obj.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {

        if (s == null) return 0;

        int[] charIndex = new int[256];
        int length = s.length();

        Arrays.fill(charIndex, -1); //initialize all indices to -1

        int start = 0;
        int maxLength = 0;
        int i = 0;
        for (; i < length; i++) {
            char currentChar = s.charAt(i);
            if (charIndex[currentChar] >= start) {
                maxLength = Math.max(maxLength, i-start);
                start = charIndex[currentChar]+1;
                charIndex[currentChar] = i;
            } else {
                charIndex[currentChar] = i;
            }
        }

        return Math.max(maxLength, i-start);
    }

}
