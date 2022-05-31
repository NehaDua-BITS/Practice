package dsa.microsoft;

/**
 * longest subsequence that increases before decreasing
 */
public class LongestSubsequence {

    public static void main(String[] args) {
        LongestSubsequence obj = new LongestSubsequence();
        int[] nums = {0,1,0,3,2,3};
        int maxLength = obj.longestSubsequence(nums);
        System.out.println("Length of longest increasing subsequence : " + maxLength);
    }

    private int longestSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxLength = 1;
        int n = nums.length;
        int[] subseqLength = new int[n];
        subseqLength[n-1] = 1;
        for (int i=n-2; i>=0; i--) {
            int max = 0;
            for (int j = i+1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    max = Math.max(max, subseqLength[j]);
                }
            }
            subseqLength[i] = max+1;
            maxLength = Math.max(maxLength, subseqLength[i]);
        }

        return maxLength;
    }
}
