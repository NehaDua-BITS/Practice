package dsa.microsoft;

import java.util.Arrays;

public class JumpGameToZero {

    public static void main(String[] args) {
        JumpGameToZero obj = new JumpGameToZero();
        int[] nums = {3, 4, 2, 3, 0, 3, 1, 2, 1};
        int startIndex = 5;
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        boolean canReach = obj.canReach(nums, startIndex, visited);
        System.out.println("Can Reach 0 = " + canReach);
    }

    private boolean canReach(int[] nums, int currIndex, boolean[] visited) {

        if (nums[currIndex] == 0) {
            return true;
        }

        visited[currIndex] = true;

        int leftIndex = currIndex - nums[currIndex];
        if (leftIndex >= 0 && !visited[leftIndex]) {
            if (canReach(nums, leftIndex, visited)) {
                return true;
            }
        }

        int rightIndex = currIndex + nums[currIndex];
        if (rightIndex < nums.length && !visited[rightIndex]) {
            return canReach(nums, rightIndex, visited);
        }
        return false;
    }

}
