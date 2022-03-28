package dsa.medium.array;

public class MinSizeSumSubArray {

    public static void main(String[] args) {
        MinSizeSumSubArray obj = new MinSizeSumSubArray();
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        int result = obj.minSubArrayLen(target, nums);
        System.out.println("Minimum Sub-Array Size = " + result);
    }

    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int length = nums.length;

        int start = 0;
        int currSum = 0;
        for (int i = 0; i < length; i++) {
            currSum += nums[i];
            if (currSum >= target) {
                minLength = Math.min(minLength, i-start+1);
                int j = start;
                while (j <= i) {
                    currSum -= nums[j];
                    if (currSum < target) {
                        start = j+1;
                        break;
                    }
                    minLength = Math.min(minLength, i-j);
                    j++;
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
