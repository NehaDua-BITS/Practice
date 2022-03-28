package dsa.medium.sortingsearching;

import java.util.Arrays;

public class FindKthLargest {

    public static void main(String[] args) {
        FindKthLargest obj = new FindKthLargest();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(k + "th largest number = " + obj.findKthLargest(nums, k));
    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
