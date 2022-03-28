package dsa.hard;

import java.util.*;

public class WordBreak {

    public static void main(String[] args) {
        WordBreak obj = new WordBreak();
        String s = "a";
        List<String> wordDict = new ArrayList<>(Arrays.asList("a"));
        boolean result = obj.wordBreak(s, wordDict);
        System.out.println("Result = " + result);
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }

        Set<String> dicSet = new HashSet<>(wordDict);
        int length = s.length();

        boolean[] wb = new boolean[s.length()+1];
        for (int i = 1; i <= length; i++) {

            if (!wb[i] && dicSet.contains(s.substring(0, i))) {
                wb[i] = true;
            }

            if (i == length && wb[i]) {
                return true;
            }

            if (wb[i]) {
                for (int j = i+1; j <= length; j++) {
                    if (!wb[j] && dicSet.contains(s.substring(i, j))) {
                        wb[j] = true;
                    }

                    if (j == length && wb[j] == true) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

}
