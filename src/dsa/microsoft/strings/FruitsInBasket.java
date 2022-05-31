package dsa.microsoft.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Similar to LongestSubstringKDistinctChars with k = 2
 */
public class FruitsInBasket {

    public static void main(String[] args) {
        FruitsInBasket obj = new FruitsInBasket();
        char[] arr = {'A', 'A', 'B', 'A', 'C', 'C', 'B', 'B', 'C', 'A'};
        int k = 2;
        String s = new String(arr);
        int result = obj.longestSubstring(s, k);
        System.out.println("Max Fruits in 2 Baskets = " + result);
    }

    private int longestSubstring(String str, int k) {
        Map<Character, Integer> charFreqMap = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        int maxStart = 0;

        int n = str.length();
        for (int i = 0; i < n; i++) {
            Integer freq = charFreqMap.get(str.charAt(i));
            if (freq != null) { //already exists just increment count
                charFreqMap.put(str.charAt(i), freq+1);
            } else {
                //check current unique chars count
                if (charFreqMap.size() == k) {
                    //remove few chars
                    while (start < i && charFreqMap.size() >= k) {
                        Integer count = charFreqMap.computeIfPresent(str.charAt(start), (key, value) -> {
                            value = value - 1;
                            return value;
                        });
                        if (count == 0) {
                            charFreqMap.remove(str.charAt(start));
                        }
                        start++;
                    }
                }
                charFreqMap.put(str.charAt(i), 1);
            }

            if (maxLength < i-start+1) {
                maxLength = i-start+1;
                maxStart = start;
            }
        }
        System.out.println(str.substring(maxStart, maxStart+maxLength));
        return maxLength;
    }


}
