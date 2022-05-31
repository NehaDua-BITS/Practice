package dsa.microsoft;

import java.util.TreeSet;

//time : O(nlogn)
//space: O(n)
public class MaxSubArraySumLessThanEqualK {

    public static void main(String[] args) {
        MaxSubArraySumLessThanEqualK obj = new MaxSubArraySumLessThanEqualK();
        int[] nums = {5, -2, 6, 3, -5};
        int k = 15;
        System.out.println(obj.subarraySum(nums, k));
    }

    /**
     * Nums can be -ve or +ve
     * Maximum sum sub-array that has sum <= k
     * use tree set for storing commulative sums
     * find index i and j such that cummSum(j) - cummSum(i) <= k
     *
     */

    public int subarraySum(int[] nums, int k) {
        long maxSum = Long.MIN_VALUE;
        TreeSet<Long> sumSet = new TreeSet<>();
        sumSet.add(0L);
        long currsum = 0;

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            currsum += nums[i];

            Long sum = sumSet.ceiling(currsum - k); //to get smallest number larger than (sum-k)
            if (sum != null) {
                maxSum = Math.max(maxSum, currsum - sum);
            }
            sumSet.add(currsum);
        }
        return (int)maxSum;
    }
}
