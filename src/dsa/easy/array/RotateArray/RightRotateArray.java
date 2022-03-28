package dsa.easy.array.RotateArray;

import java.util.Arrays;

public class RightRotateArray implements IRotateArray {

    @Override
    public void rotateArrayUsingAux(int[] nums, int k) {
        int length = nums.length;
        int[] auxArray = Arrays.copyOf(nums, length);

        for (int i = 0; i < length; i++) {
            nums[(i+k) % length] = auxArray[i];
        }
    }

    @Override
    public void rotateArrayWithoutAux(int[] nums, int k) {
        int length = nums.length;
        k = k % length;

        //rotate entire array
        IRotateArray.swap(nums, 0, length - 1);
        //rotate both sub-arrays separated by k
        IRotateArray.swap(nums, 0, k-1);
        IRotateArray.swap(nums, k, length-1);
    }

}


