package dsa.easy.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StringToInt {

    public static void main(String[] args) {
        StringToInt obj = new StringToInt();

        //read the input from console
        System.out.println("Enter a string : ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println("String value = " + input);
        System.out.println("Integer value = " + obj.myAtoi(input));

        List<Integer> list = Collections.unmodifiableList(Arrays.asList(1, 3, 6, 10, 5));
    }

    private int myAtoi(String s) {
        char[] arr = s.toCharArray();
        int length = arr.length;
        //remove leading spaces
        int start = 0;
        for (; start < length && arr[start] == ' '; start++);

        StringBuilder sb = new StringBuilder();
        if (start < length && (arr[start] == '-' || arr[start] == '+')) {
            if (arr[start++] == '-') {
                sb.append("-");
            }
        }

        //remove leading +/- sign
        for (int i = start; i < length; i++) {
            if (!Character.isDigit(arr[i])) {
                break;
            }
            sb.append(arr[i]);
        }

        Integer result = 0;
        try {
            result = Integer.valueOf(sb.toString());
        } catch(NumberFormatException ex) {
            if (sb.length() > 0 && !(sb.length() == 1 && sb.charAt(0) == '-')) {
                result = sb.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }

        return result;
    }
}
