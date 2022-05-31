package dsa.microsoft.strings;

import java.util.Arrays;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/

public class LongestSubstringAllUniqueChars {

    public static void main(String[] args) {
        LongestSubstringAllUniqueChars obj = new LongestSubstringAllUniqueChars();
        String str ="aabccbbcdefac";
        int result = obj.longestSubstring(str);
        System.out.println("Longest substring length = " + result);
    }

    private int longestSubstring(String str) {
        int maxLength = 0;
        int maxStart = 0;
        int[] lastIndex = new int[256]; //to store last occurance of character
        Arrays.fill(lastIndex, -1);
        int n = str.length();

        int start = 0;
        int i = 0;
        for (; i < n; i++) {
            char ch = str.charAt(i);
            if (lastIndex[ch] == -1 || lastIndex[ch] < start) {
                lastIndex[ch] = i;
            } else {
                //remove repeated character from current window
                if (i - start > maxLength) {
                    maxLength = i - start;
                    maxStart = start;
                }
                start = lastIndex[ch]+1;
                lastIndex[ch] = i;
            }
        }

        if (i - start > maxLength) {
            maxLength = i - start;
            maxStart = start;
        }

        System.out.println(str.substring(maxStart, maxStart + maxLength));
        return maxLength;
    }

}
