package dsa.medium.sortingsearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigzagConversion {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int n = 3;
        String result = new ZigzagConversion().convert(s, n);
        System.out.println("Zigzag string = " + result);
    }

    private String convert(String s, int numRows) {
        if (numRows == 0 || s == null || s.length() == 0) {
            return null;
        }

        StringBuilder resultSb = new StringBuilder();
        List<List<Character>> zigzagStore = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            zigzagStore.add(new ArrayList<>());
        }

        int row = 0;
        int col = 0;
        int rOperand = 0;
        int cOperand = 1;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            List<Character> list = zigzagStore.get(row);
            while (list.size() < (col-1)){
                list.add(' ');
            }
            list.add(s.charAt(i));

            if (numRows > 1) {
                if (row == numRows - 1) {
                    rOperand = -1;
                    cOperand = 1;
                } else if (row == 0) {
                    rOperand = 1;
                    cOperand = 0;
                }
            }

            row += rOperand;
            col += cOperand;

        }

        System.out.println(Arrays.toString(zigzagStore.toArray()));

        for (int i = 0; i < numRows; i++) {
            List<Character> sublist = zigzagStore.get(i);
            for (int j = 0; j < sublist.size(); j++) {
                if (!Character.isSpaceChar(sublist.get(j))) {
                    resultSb.append(sublist.get(j));
                }
            }
        }

        return resultSb.toString();
    }
}
