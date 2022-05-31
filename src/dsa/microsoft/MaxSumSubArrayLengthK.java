package dsa.microsoft;

public class MaxSumSubArrayLengthK {

    public static void main(String[] args) {
        int k = 2;
        int[] nums = {2, 3, 4, 1, 5};

        MaxSumSubArrayLengthK obj = new MaxSumSubArrayLengthK();
        int maxSum = obj.maxSumSubArrayLengthK(nums, k);
        System.out.println("Maximum sum sub-array of size k = " + maxSum);
    }

    private int maxSumSubArrayLengthK(int[] nums, int k) {

        if (nums == null || nums.length == 0 || nums.length < k) {
            return -1;
        }

        int n = nums.length;
        int currSum = 0;
        int currIndex = 0;
        while (currIndex < k) {
            currSum += nums[currIndex++];
        }

        int maxSum = currSum;
        int startIndex = 0;
        while (currIndex < n) {
            currSum -= nums[startIndex++];
            currSum += nums[currIndex++];
            maxSum = Math.max(currSum, maxSum);
        }

        return maxSum;
    }

}
