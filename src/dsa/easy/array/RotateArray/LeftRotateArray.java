package dsa.easy.array.RotateArray;

import java.util.Arrays;

public class LeftRotateArray implements IRotateArray {

    @Override
    public void rotateArrayUsingAux(int[] nums, int k) {
        int length = nums.length;
        int[] copy = Arrays.copyOf(nums, length);
        k = k % length;

        for (int i = 0; i < length; i++) {
            int newPos = i - k;
            if (newPos < 0) {
                newPos += length;
            }
            nums[newPos] = copy[i];
        }
    }

    @Override
    public void rotateArrayWithoutAux(int[] nums, int k) {
        int length = nums.length;
        k = k % length;

        //rotate entire array
        IRotateArray.swap(nums, 0, length-1);
        //rotate sub-arrays
        k = length - k;
        IRotateArray.swap(nums, 0, k-1);
        IRotateArray.swap(nums, k, length-1);
    }

}
