package dsa.easy.others;

public class MissingNumber {

    public static void main(String[] args) {
        int nums[] = {0,2,3,1,4};
        System.out.println("Missing Number = " + new MissingNumber().missingNumber(nums));
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
}
