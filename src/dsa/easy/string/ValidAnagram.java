package dsa.easy.string;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {

    public static void main(String[] args) {
        ValidAnagram obj = new ValidAnagram();
        String s = "god";
        String t = "dogd";

//        boolean result = obj.isAnagram(s, t);
//        boolean result = obj.isAnagramUsingMap(s, t);
        boolean result = obj.isAnagramOptimised(s, t);
        System.out.println(s + " and " + t + " are anagrams = " + result);
    }

    private boolean isAnagramOptimised(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        char[] arr = s.toCharArray();
        for (char ch : arr) {
            count[ch-'a']++;
        }

        arr = t.toCharArray();
        for (char ch : arr) {
            count[ch-'a']--;
            if (count[ch-'a'] < 0) {
                return false;
            }
        }

        return true;
    }


    //using sorting
    private boolean isAnagram(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.toString(sArray).equals(Arrays.toString(tArray));
    }

    //using hashmap
    private boolean isAnagramUsingMap(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        //iterate over tring to get count of chars
        char[] sArray = s.toCharArray();
        int sLength = sArray.length;
        for (int i = 0; i < sLength; i++) {
            char ch = sArray[i];
            Integer count = map.get(ch);
            if (count == null) {
                map.put(ch, 1);
            } else {
                map.put(ch, count + 1);
            }
        }

        char[] tArray = t.toCharArray();
        int tLength = tArray.length;
        for (int i = 0; i < tLength; i++) {
            char ch = tArray[i];
            Integer count = map.get(ch);
            if (count == null) {
                return false;
            }

            if (--count == 0) {
                map.remove(ch);
            } else {
                map.put(ch, count);
            }
        }

        return map.isEmpty();
    }
}
