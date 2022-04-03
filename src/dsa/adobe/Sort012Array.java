package dsa.adobe;

import java.util.Arrays;

public class Sort012Array {

    public static void main(String[] args) {
        int[] nums = {1,0,1,0,2,1,2,0,1,1,2,2,0,0,1,0};

        Sort012Array obj = new Sort012Array();
        System.out.println("Original Array = " + Arrays.toString(nums));
//        nums = obj.sortArray(nums);
//        System.out.println("Sorted Array = " + Arrays.toString(nums));
        System.out.println("Sorted Array using Dutch Flag Algo = " + Arrays.toString(obj.sortArrayUsingDutchFlagAlgo(nums)));
    }

    //simple approach (O(n))
    private int[] sortArray(int[] nums) {
        int[] count = new int[3];
        int arrLength = nums.length;
        for (int i = 0; i < arrLength; i++) {
            count[nums[i]]++;
        }

        for (int countArrIndex = 0, numsArrIndex = 0; countArrIndex < 3; ) {
            if (count[countArrIndex] > 0) {
                nums[numsArrIndex++] = countArrIndex;
                count[countArrIndex]--;
            } else {
                countArrIndex++;
            }
        }

        return nums;
    }

    //using dutch flag solution O(n)
    private int[] sortArrayUsingDutchFlagAlgo(int[] nums) {

        int zerosIndex = 0;
        int onesIndex = 0;
        int twosIndex = nums.length-1;

        while (onesIndex <= twosIndex) {
            if (nums[onesIndex] == 1) {
                onesIndex++;
            } else if (nums[onesIndex] == 2) {
                nums[onesIndex] = nums[twosIndex];
                nums[twosIndex] = 2;
                twosIndex--;
            } else { //it's 0
                nums[onesIndex] = nums[zerosIndex];
                nums[zerosIndex] = 0;
                onesIndex++;
                zerosIndex++;
            }
        }

        return nums;
    }

}
