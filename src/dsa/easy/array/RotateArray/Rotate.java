package dsa.easy.array.RotateArray;

import java.util.Arrays;

public class Rotate {

    public static void main(String[] args) {

        //right rotating array
        IRotateArray iRotateArray = new RightRotateArray();
        int nums[] = {1, 12, 3,4 ,15, 60, 7, 8, 10};
        int k = 3;

        System.out.println("Original Array : " + Arrays.toString(nums));
        System.out.println("Rotating by " + k + " positions");

//        iRotateArray.rotateArrayUsingAux(nums, k);
        iRotateArray.rotateArrayWithoutAux(nums, k);
        System.out.println("\nArray after right rotation : " + Arrays.toString(nums));

        iRotateArray = new LeftRotateArray();
//        iRotateArray.rotateArrayUsingAux(nums, k);
        iRotateArray.rotateArrayWithoutAux(nums, k);
        System.out.println("\nArray after left rotation : " + Arrays.toString(nums));
    }

}
