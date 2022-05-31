package dsa.microsoft;

public class PositiveSubArraySumGreaterEqualK {

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 2, 8};
        int k = 7;
        PositiveSubArraySumGreaterEqualK obj = new PositiveSubArraySumGreaterEqualK();
        int minSize = obj.findMinSubArray(nums, k);
        System.out.println("Minimum size sub-array with sum >= k : " + minSize);
    }

    public int findMinSubArray(int[] nums, int k) {
        return 0;
    }

}
