package dsa.easy.dp;

public class HouseRobber {

    public static void main(String[] args) {
        HouseRobber obj = new HouseRobber();
//        int[] nums = {1,2,3,1};
//        int[] nums = {2,7,9,3,1};
        int[] nums = {2,1,1,2};
        System.out.println("Max Money = " + obj.rob(nums));
    }

    private int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = nums.length;
        if (length == 1) return nums[0];
        if (length == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }

        return dp[length-1];
    }

}
