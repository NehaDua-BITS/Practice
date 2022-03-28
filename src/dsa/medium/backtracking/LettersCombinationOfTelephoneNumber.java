package dsa.medium.backtracking;

import java.util.*;

public class LettersCombinationOfTelephoneNumber {

    public static void main(String[] args) {
        LettersCombinationOfTelephoneNumber obj = new LettersCombinationOfTelephoneNumber();
        String digits = "";
        List<String> combinations = obj.letterCombinations(digits);
        System.out.println("Combinations are : " + Arrays.toString(combinations.toArray()));
    }

    private List<String> letterCombinations(String digits) {
        List<String> resultList = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return resultList;
        }

        String[] telephone = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int length = digits.length();

        Queue<String> queue = new LinkedList<>();
        queue.add("");

        while (!queue.isEmpty()) {
            String s = queue.remove();

            if (s.length() == length) {
                resultList.add(s);
            } else {
                String str = telephone[digits.charAt(s.length()) - '0'];
                for (int i = 0; i < str.length(); i++) {
                    queue.add(s + str.charAt(i));
                }
            }
        }

        return resultList;
    }

}
