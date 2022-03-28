package dsa.medium.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,2,3};
        LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();

        System.out.println("Length of longest Increasing Subsequence : " + obj.lengthOfLIS(nums));
    }

    private int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int arrLength = nums.length;
        int maxLength = 1;
        int subseqLength[] = new int[arrLength];
        subseqLength[arrLength-1] = 1;

        for (int i = arrLength-2; i >= 0; i--) {
            int max = 0;
            for (int j = i+1; j < arrLength; j++) {
                if (nums[j] > nums[i]) {
                    max = Math.max(max, subseqLength[j]);
                }
            }
            subseqLength[i] = max+1;
            maxLength = Math.max(maxLength, subseqLength[i]);
        }

        System.out.println(Arrays.toString(subseqLength));
        return maxLength;
    }

}
