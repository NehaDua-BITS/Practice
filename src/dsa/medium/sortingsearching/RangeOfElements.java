package dsa.medium.sortingsearching;

import java.util.Arrays;

public class RangeOfElements {
    public static void main(String[] args) {
        RangeOfElements obj = new RangeOfElements();

        int[] nums = {5,7,7,8,8,10};
        int target = 8;

        System.out.println(Arrays.toString(obj.searchRange(nums, target)));
    }

    public int[] searchRange(int[] nums, int target) {
        int first = searchUsingBinary(nums, 0, nums.length-1, target, true);
        int last = searchUsingBinary(nums, 0, nums.length-1, target, false);
        return new int[]{first, last};
    }

    private int searchUsingBinary(int[] nums, int start, int end, int target, boolean isFirst) {

        int result = -1;

        while (start <= end) {

            int mid = (start+end)/2;

            if (target == nums[mid]) {
               result = mid;
               if (isFirst) {
                   end = mid - 1;
               } else {
                   start = mid+1;
               }
            }
            else if (target > nums[mid]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        return result;
    }

    private int[] search(int[] nums, int target) {
        int[] result = {-1, -1};
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            if (target == nums[i]) {
                result[0] = i;
                for (i=i+1; i < length && target == nums[i]; i++);
                result[1] = i-1;
                break;
            }
        }

        return result;
    }
}
