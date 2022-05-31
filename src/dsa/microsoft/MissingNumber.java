package dsa.microsoft;

public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = {3,6,1,2,8,4,5};
        MissingNumber obj = new MissingNumber();

        System.out.println("Missing number using summation = " + obj.missingNumberUsingSum(nums));
        System.out.println("Missing number without sum overflow = " + obj.missingNumberWithoutSumOverflow(nums));
        System.out.println("Missing number using xor = " + obj.missingNumberUsingXor(nums));
    }

    /**
     * Problem : can cause overflow
     * @param nums
     * @return
     */
    private int missingNumberUsingSum(int[] nums) {
        int n = nums.length;

        int actualSum = 0;
        for (int i = 0; i < n; i++) {
            actualSum += nums[i];
        }

        int expectedSum = 0;
        for (int i = 1; i <= n+1; i++) {
            expectedSum += i;
        }

        return expectedSum - actualSum;
    }

    /**
     * to avoid overflow keep adding(1 to n+1) and subtracting numbers(given nums)
     * @param nums
     * @return
     */
    private int missingNumberWithoutSumOverflow(int[] nums){
        int n = nums.length;
        int sum = 1;
        for (int i = 2; i <= n+1; i++) {
            sum += i;
            sum -= nums[i-2];
        }

        return sum; //missing number
    }

    private int missingNumberUsingXor(int[] nums) {
        int n = nums.length;

        int xor1 = 0;
        for (int i = 1; i <= n+1; i++) {
            xor1 ^= i;
        }

        int xor2 = 0;
        for (int i = 0; i < n; i++) {
            xor2 ^= nums[i];
        }

        return xor1^xor2;
    }
}
