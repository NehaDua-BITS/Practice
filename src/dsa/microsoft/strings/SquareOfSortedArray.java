package dsa.microsoft.strings;

import java.util.Arrays;

public class SquareOfSortedArray {

    public static void main(String[] args) {
        SquareOfSortedArray obj = new SquareOfSortedArray();
        int[] nums = {-2, -1, 0, 1, 2};
        int[] result = obj.sortedSquareArr(nums);
        System.out.println("Sorted square array = " + Arrays.toString(result));
    }

    private int[] sortedSquareArr(int[] nums) {
        int n = nums.length;
        int[] squareArr = new int[n];
        int index = n-1;
        for (int left = 0, right = n-1; left <= right; ) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (rightSquare >= leftSquare) {
                squareArr[index--] = rightSquare;
                right--;
            } else {
                squareArr[index--] = leftSquare;
                left++;
            }
        }

        return squareArr;
    }

}
