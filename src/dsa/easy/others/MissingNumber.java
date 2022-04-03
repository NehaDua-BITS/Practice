package dsa.easy.others;

public class MissingNumber {

    public static void main(String[] args) {
        int nums[] = {0,2,3,1,4};
        System.out.println("Missing Number = " + new MissingNumber().missingNumber(nums));
        System.out.println("Missing Number using XOR = " + new MissingNumber().missingNumberXOR(nums));
    }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int correctSum = (n*(n+1))/2;

        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        return correctSum - actualSum;
    }

    public int missingNumberXOR(int[] nums) {

        int n = nums.length;

        int x1 = nums[0];
        for (int i = 1; i < n; i++) {
            x1 ^= nums[i];
        }

        int x2 = 0;
        for (int i = 1; i <= n; i++) {
            x2 ^= i;
        }

        return x1 ^ x2;
    }
}
