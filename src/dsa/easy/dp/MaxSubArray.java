package dsa.easy.dp;

public class MaxSubArray {

    public static void main(String[] args) {
        MaxSubArray obj = new MaxSubArray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Maximum contiguous subarray sum = " + obj.maxSubArray(nums));

        System.out.println("Maximum sum sub-array is : " + obj.maxSumSubArray(nums));

    }

    //Kadane's algorithm - continuing sum on negative range is much more worse than starting a new range
    private int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            currentSum = Math.max(currentSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    private int maxSumSubArray(int[] nums) {
        int currentSum = nums[0];
        int start = 0;
        int end = 0;
        int s = 0;
        int maxSum = nums[0];

        int length = nums.length;
        for (int i = 1; i < length; i++) {
            if (currentSum + nums[i] < nums[i]) {
                currentSum = nums[i];
                s = i;
            } else {
                currentSum += nums[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = s;
                end = i;
            }
        }

        System.out.println("Sub Array : ");
        for (int l = start; l <= end; l++) {
            System.out.println(nums[l]);
        }
        System.out.println("Max Sum = " + maxSum);

        return maxSum;
    }

}
