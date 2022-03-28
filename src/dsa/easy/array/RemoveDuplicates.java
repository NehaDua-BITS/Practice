package dsa.easy.array;

import java.util.Arrays;
import java.util.Objects;

public class RemoveDuplicates {

    public static void main(String[] args) {
        //array of integers
        Integer[] nums = {2, 5, 7, 7, 8, 8, 8, 9, 10, 11, 11, 12, 13, 13, 13, 13};
//        Integer[] nums = null;
//        Integer[] nums = new Integer[0];

        RemoveDuplicates rd = new RemoveDuplicates();

        //remove using auxiliary space
        Integer[] result = rd.removeDuplicatesUsingAux(nums);
        rd.printFinalList(result, result != null ? result.length : 0);

        //remove without using extra space
        int count = rd.removeDuplicatesWithoutAux(nums);
        rd.printFinalList(nums, count);
    }

    private Integer[] removeDuplicatesUsingAux(Integer[] nums) {
        if (nums == null) {
            System.out.println("List is null");
            return null;
        }

        int length = nums.length;

        Integer[] resultList = new Integer[length];
        int j = -1;
        for (int i = 0; i < length; i++) {

            if ( (j == -1) || nums[i] != resultList[j]) {
                resultList[++j] = nums[i];
            }
        }

        System.out.println(String.format("Unique numbers = %s", ++j));

        resultList = Arrays.stream(resultList).filter(Objects::nonNull).toArray(Integer[]::new);
        return resultList;
    }

    private int removeDuplicatesWithoutAux(Integer[] nums) {
        if (nums == null) {
            System.out.println("List is null");
            return 0;
        }

        int lastIndex = -1;
        for (int current = 0; current < nums.length; current++) {
            if ( (lastIndex == -1) || (nums[lastIndex] != nums[current]) ) {
                nums[++lastIndex] = nums[current];
            }
        }

        ++lastIndex;

        System.out.println(String.format("\n\nUnique numbers = %s", lastIndex));
        return lastIndex;
    }

    private void printFinalList(Integer[] nums, int count) {
        System.out.println(String.format("Printing %s elements", count));

        if (nums != null) {
            for (int i = 0; i < count; i++) {
                System.out.print(nums[i] + " ");
            }
        }
    }

}
