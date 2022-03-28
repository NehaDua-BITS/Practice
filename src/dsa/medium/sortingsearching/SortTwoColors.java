package dsa.medium.sortingsearching;

import java.util.Arrays;

public class SortTwoColors {

    public static void main(String[] args) {
        SortTwoColors obj = new SortTwoColors();
        int[] nums = {1, 0, 1, 0, 1, 0};
//        obj.sortColorsUsingCount(nums);
        obj.sortColorsUsingDutchNFlag(nums);
        System.out.println("Array after sorting = " + Arrays.toString(nums));
    }

    public void sortColorsUsingCount(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int[] count = new int[2];

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            count[nums[i]]++;
        }

        int index = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[index++] = i;
            }
        }
    }

    public void sortColorsUsingDutchNFlag(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            if (nums[low] == 0) {
                low++;
            } else {
                nums[low] = nums[high];
                nums[high] = 1;
                high--;
            }
        }
    }


}
