package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExtractEvenOddNumber {

    public static void main(String[] args) {
        ExtractEvenOddNumber obj = new ExtractEvenOddNumber();
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,7,2,4,9,10,12,3));
        System.out.println("Input List : " + Arrays.toString(nums.toArray()));
        System.out.println("Even Numbers : " + Arrays.toString(obj.getEvenNumbers(nums).toArray()));
        System.out.println("Odd Numbers : " + Arrays.toString(obj.getOddNumbers(nums).toArray()));
    }

    private List<Integer> getEvenNumbers(List<Integer> nums) {
        return nums.stream().filter(num -> num%2 == 0).collect(Collectors.toList());
    }

    private List<Integer> getOddNumbers(List<Integer> nums) {
        return nums.stream().filter(num -> num%2 != 0).collect(Collectors.toList());
    }

}
