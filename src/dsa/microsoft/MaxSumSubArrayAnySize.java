package dsa.microsoft;

//https://leetcode.com/problems/maximum-subarray/

public class MaxSumSubArrayAnySize {

    public static void main(String[] args) {
        MaxSumSubArrayAnySize obj = new MaxSumSubArrayAnySize();
        int[] nums = {5,4,-1,7,8}; //{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Maximum sum sub-array = " + obj.maxSubArray(nums));
    }

    //Kadane's algorithm
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            currSum += nums[i];
            maxSum = Math.max(maxSum, currSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }
}
