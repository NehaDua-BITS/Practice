package dsa.medium.sortingsearching;

import java.util.Arrays;

public class SortThreeColors {

    public static void main(String[] args) {
        SortThreeColors obj = new SortThreeColors();
        int[] nums = {2, 0, 0, 0, 1, 2, 1, 1, 2, 1};
        //obj.sortColorsUsingCount(nums);
        obj.sortColorsUsingDutchNFlag(nums);
        System.out.println("Array after sorting = " + Arrays.toString(nums));

    }

    private void sortColorsUsingCount(int[] nums) {
        int length = nums.length;
        int[] count = new int[3];
        Arrays.fill(count, 0);

        for (int i = 0; i < length; i++) {
            count[nums[i]]++;
        }

        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[index++] = i;
            }
        }
    }

    private void sortColorsUsingDutchNFlag(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;

        while (mid <= high) {
            if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 0) {
                nums[mid] = nums[low];
                nums[low] = 0;
                low++;
                mid++;
            } else {
                nums[mid] = nums[high];
                nums[high] = 2;
                high--;
            }
        }
    }

}
