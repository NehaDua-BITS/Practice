package dsa.microsoft;

import java.util.Arrays;

/**
 * Reach last index of array in minimum jumps
 * Used memoization to improve performance and time
 */
public class JumpWithMinCount {

    public static void main(String[] args) {
        JumpWithMinCount obj = new JumpWithMinCount();
        int[] nums = {5,9,3,2,1,0,2,3,3,1,0,0};
        System.out.println("Min Jumps to Reach Last Index = " + obj.reachWithMinJumps(nums));
    }

    private int reachWithMinJumps(int[] nums) {
        int minJumps[] = new int[nums.length];
        Arrays.fill(minJumps, -1);
        int count = reachWithMinJumps(nums, 0, minJumps);
        System.out.println(Arrays.toString(minJumps));
        return count;
    }

    private int reachWithMinJumps(int[] nums, int currIndex, int[] minJumps) {

        if (currIndex == (nums.length-1)) {
            return 0;
        }

        if (nums[currIndex] == 0) {
            return Integer.MAX_VALUE;
        }

        if (minJumps[currIndex] != -1) {
            return minJumps[currIndex];
        }

        int minCount = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[currIndex] && (currIndex+i < nums.length); i++) {
            int c = reachWithMinJumps(nums, currIndex + i, minJumps);
            minCount = Math.min(minCount, c != Integer.MAX_VALUE ? 1 + c : Integer.MAX_VALUE);
        }

        minJumps[currIndex] = minCount;

        return minCount;
    }

}
