package dsa.easy.array;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        MoveZeroes mzObj = new MoveZeroes();
        int[] nums = {2, 0, 0, 1, 2};
        //mzObj.moveZeroes(nums);
        mzObj.moveZeroesOptimised(nums);

        System.out.println("Array after moving all zeroes to right = " + Arrays.toString(nums));
    }

    private void moveZeroesOptimised(int[] nums) {
        int length = nums.length;
        int j = -1;
        for (int i = 0; i < length && j < length; i++) {
            if(nums[i] == 0) {
                //find non-zero
                if (j == -1) {
                    j = i + 1;
                }

                for (; j < length; j++) {
                    if (nums[j] != 0) {
                        //swap
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j++] = temp;
                        break;
                    }
                }
            }
        }
    }

    private void moveZeroes(int[] nums) {
        int zeroPos = 0;
        int nonZeroPos = -1;
        int length = nums.length;

        while (true) {

            while(zeroPos < length && nums[zeroPos] != 0) {
                zeroPos++;
            }

            if (nonZeroPos == -1) {
                nonZeroPos = zeroPos + 1;
            }
            while(nonZeroPos < length && nums[nonZeroPos] == 0) {
                nonZeroPos++;
            }

            //swap zero with non-zero value
            if (zeroPos >= length || nonZeroPos >= length) {
                break;
            }

            int temp = nums[zeroPos];
            nums[zeroPos] = nums[nonZeroPos];
            nums[nonZeroPos] = temp;

        }
    }


}
