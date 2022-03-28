package dsa.easy.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        PascalTriangle obj = new PascalTriangle();
        List<List<Integer>> list = obj.generate(5);

        System.out.println("Pascal Triangle is : ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(Arrays.toString(list.get(i).toArray()));
        }
    }

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList();

        for (int i = 0; i < numRows; i++) {

            List<Integer> list = new ArrayList();
            list.add(1);

            if (i != 0) {
                List<Integer> prevRow = result.get(i-1);
                int length = prevRow.size();
                for (int j = 0; j < length-1; j++) {
                    list.add(prevRow.get(j) + prevRow.get(j+1));
                }
                list.add(1);
            }

            result.add(list);
        }

        return result;
    }
}
