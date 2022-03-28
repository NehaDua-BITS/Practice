package dsa.microsoft;

/**
 * arr[i] indicates maximum jump size
 * target is to reach last index
 */

public class JumpGameToLastIndex {

    public static void main(String[] args) {
        JumpGameToLastIndex obj = new JumpGameToLastIndex();
        int[] nums = {2,3,1,1,4};
        System.out.println("Can Reach Last Index = " + obj.canReachLastIndex(nums));
    }

    private boolean canReachLastIndex(int[] nums) {
        return canReachLastIndex(nums, 0, new boolean[nums.length]);
    }

    private boolean canReachLastIndex(int[] nums, int currIndex, boolean[] visited) {
        if (currIndex == (nums.length-1)) {
            return true;
        }

        visited[currIndex] = true;

        for (int i = 1; i <= nums[currIndex]; i++) {
            int nextIndex = currIndex + i;

            if (nextIndex >= nums.length) break;

            if (!visited[nextIndex]) {
                if (canReachLastIndex(nums, nextIndex, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

}
