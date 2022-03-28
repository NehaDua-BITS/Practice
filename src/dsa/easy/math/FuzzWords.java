package dsa.easy.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FuzzWords {

    public static void main(String[] args) {
        List<String> result = new FuzzWords().fizzBuzz(15);
        System.out.println(Arrays.toString(result.toArray()));
    }

    private List<String> fizzBuzz(int n) {

        ArrayList<String> list = new ArrayList(n);

        String fb = "FizzBuzz";
        String b = "Buzz";
        String f = "Fizz";

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add(fb);
            } else if (i % 3 == 0) {
                list.add(f);
            } else if (i % 5 == 0) {
                list.add(b);
            } else {
                list.add(String.valueOf(i));
            }
        }

        return list;
    }

}
