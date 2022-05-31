package dsa.medium.others;

import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println("Majority Element = " + new MajorityElement().majorityElement(nums));
        System.out.println("Majority Element = " + new MajorityElement().majorityElementOptimised(nums));
    }

    //time=O(n) space=O(n)
    private int majorityElement(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int length = nums.length;
        for (int n : nums) {
            int freq = freqMap.getOrDefault(n, 0) + 1;
            if (freq > length/2) {
                return n;
            }
            freqMap.put(n, freq);
        }
        return 0;
    }

    //time=O(n) space=O(1)
    private int majorityElementOptimised(int[] nums) {
        int length = nums.length;
        int majorityIndex = 0;
        int count = 1;

        for (int i = 1; i < length; i++) {
            if (nums[i] == nums[majorityIndex]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                majorityIndex = i;
                count = 1;
            }
        }

        return isMajorityElement(nums, nums[majorityIndex]) ? nums[majorityIndex] : 0;
    }

    private boolean isMajorityElement(int[] nums, int majority) {
        int count = 0;
        int length = nums.length;

        for (int n : nums) {
            if (n == majority) count++;
            if (count > length/2) return true;
        }

        return false;
    }

}
