package dsa.microsoft;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringSegmentation {

    public static void main(String[] args) {
        StringSegmentation obj = new StringSegmentation();

        String str = "cathatdogdogcathat";
        Set<String> dictionary = new HashSet<>(Arrays.asList("dog", "cat", "hat"));

        boolean result = obj.canSegmentCompletely(str, 0, dictionary);
        System.out.println("Can string segment = " + result);
    }

    //slow solution (brute force) - Recursive
    private boolean canSegmentCompletely(String str, int startIndex, Set<String> dictionary) {
        if (str == null || str.length() == 0) {
            return false;
        }

        if (startIndex >= str.length()) {
            return true;
        }

        int length = str.length();
        for (int currIndex = startIndex; currIndex  < length; currIndex++) {
            if (dictionary.contains(str.substring(startIndex, currIndex+1))) {
                if (canSegmentCompletely(str, currIndex+1, dictionary)) {
                    return true;
                }
            }
        }

        return false;
    }

    //faster solution - iterative and DP
    public boolean wordBreak(String s, List<String> wordDict) {

        if (s == null) {
            return false;
        }

        Set<String> dicSet = new HashSet<>(wordDict);

        int length = s.length();
        if (s.length() == 0) {
            return true;
        }

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
