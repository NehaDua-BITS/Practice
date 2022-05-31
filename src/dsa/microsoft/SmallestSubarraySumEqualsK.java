package dsa.microsoft;

import java.util.HashMap;
import java.util.Map;

/**
 * Use set or map approach if negative numbers are also there
 * else sliding window
 */
public class SmallestSubarraySumEqualsK {

    public static void main(String[] args) {
        SmallestSubarraySumEqualsK obj = new SmallestSubarraySumEqualsK();
        int[] nums = {3, 4, 1, 1, 6};
        int k = 8;
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
        int minLenth = Integer.MAX_VALUE;
        Map<Integer, Integer> sumSet = new HashMap<>();  //to store sum and index
        sumSet.put(0, 0);
        int currSum = 0;

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            currSum += nums[i];

            Integer index = sumSet.get(currSum - k);
            if (index != null) { //to get number equal to (sum-k)
                int length = index == 0 ? i+1 : i - index;
                minLenth = Math.min(minLenth,  length);
            }

            sumSet.put(currSum, i);
        }
        return minLenth == Integer.MAX_VALUE ? -1 : minLenth;
    }
}
