package dsa.easy.array;

import java.util.HashMap;

public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement obj = new MajorityElement();
        int[] nums = {2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2};
//        int[] nums = {2};
        int result = obj.findMajorityElement(nums);

        System.out.println("Majority element is : " + result);

        System.out.println("Majority element using Boyer-Moore algorithm : " + obj.findMajorityElementUsingMooreAlgo(nums));
    }

    /**
     * O(n) approach using O(n) extra space
     * @param nums
     * @return
     */
    private int findMajorityElement(int[] nums) {
        int majorityElement = -1;

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int targetCount = nums.length/2;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int element : nums) {
            int count = map.getOrDefault(element, 0) + 1;
            map.put(element, count);
            if (count > targetCount) {
                majorityElement = element;
                break;
            }
        }

        return majorityElement;
    }

    /**
     * O(n) approach with constant i.e. O(1) space
     * using Boyer-Moore algorithm
     * @param nums
     * @return
     */
    private int findMajorityElementUsingMooreAlgo(int[] nums) {
        int majorityElement = -1;
        int currentCount = 0;

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (currentCount == 0) {
                currentCount = 1;
                majorityElement = nums[i];
            } else if (majorityElement == nums[i]) {
                currentCount++;
            } else {
                currentCount--;
            }
        }

        return majorityElement;
    }
}
