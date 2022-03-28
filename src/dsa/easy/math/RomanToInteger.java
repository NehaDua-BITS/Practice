package dsa.easy.math;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    private static Map<Character, Integer> romanMap = new HashMap<>();

    static {
        /*
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
         */
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }

    public static void main(String[] args) {
        String s = "VX";
        RomanToInteger obj = new RomanToInteger();
        int val = obj.romanToInt(s);
        System.out.println(s + " => " + val);
    }

    private int romanToInt(String s) {

        int length = s.length();

        int prev = 0;
        int result = 0;
        for (int i = length-1; i >= 0; i--) {
            char ch = s.charAt(i);
            int val = romanMap.get(ch);
            if (i != length-1 && val < prev) {
                val = val * -1;
            }
            result += val;
            prev = val;
        }

        return result;
    }

}
