package dsa.microsoft;

import java.util.*;

//https://leetcode.com/problems/palindromic-substrings/submissions/

public class AllPalindromes {

    public static void main(String[] args) {
        AllPalindromes obj = new AllPalindromes();
        String str = "poppopo";
        List<String> result = obj.allPalindromes(str);
        System.out.println("Palindromes are : \n" + Arrays.toString(result.toArray()));
    }

    public List<String> allPalindromes(String str) {
        Set<String> palindromes = new HashSet<>();

        int length = str.length();
        boolean[][] isPalindrome = new boolean[length][length];

        //set all strings of length 1 as palindrome
        for (int i = 0; i < length; i++) {
            isPalindrome[i][i] = true;
        }

        //check all substrings of length 2
        for (int i = 0; i < length-1; i++) {
            isPalindrome[i][i+1] = (str.charAt(i) == str.charAt(i+1));
        }

        //check for all substrings with size >= 3
        int offset = 2;
        while (offset < length) {
            for (int i = 0; (i+offset) < length; i++) {
                isPalindrome[i][i + offset] = (str.charAt(i) == str.charAt(i+offset)) && isPalindrome[i+1][i+offset-1];
            }
            offset++;
        }

        System.out.println("Current palindrome matrix = ");
        for (int i = 0; i < length; i++) {
            System.out.println(Arrays.toString(isPalindrome[i]));
        }

        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                if (i != j && isPalindrome[i][j]) {
                    palindromes.add(str.substring(i, j+1));
                }
            }
        }

        return new ArrayList<>(palindromes);
    }
}
