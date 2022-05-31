package random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListToArray {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int[] arr = list.stream().mapToInt(x -> x.intValue()).toArray();
        System.out.println("Array size : " + arr.length);
        System.out.println("Array = " + Arrays.toString(arr));

    }
}
