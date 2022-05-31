package dsa.microsoft;

import java.util.*;

public class SumOfTwoIntegers {

    public static void main(String[] args) {
        SumOfTwoIntegers obj = new SumOfTwoIntegers();
        int[] nums = {3,2,4,2};
        int sum = 4;
        //System.out.println("Sum pair exists using sorting : " + Arrays.toString(obj.hasSumPairUsingSorting(nums, sum)));
        System.out.println("Sum pair exists using aux space : " + Arrays.toString(obj.hasSumPairUsingAuxSpace(nums, sum)));
        System.out.println("Sum pair exists using aux space : " + Arrays.toString(obj.findPairUsingAuxOptimised(nums, sum)));
    }

    /**
     * using sorting
     * @param nums
     * @param targetSum
     * @return
     */
    private int[] hasSumPairUsingSorting(int[] nums, int targetSum) {
        int[] pair = new int[2];
        Arrays.sort(nums);

        int n = nums.length;
        for (int start=0, end=n-1; start < end; ) {
            int sum = nums[start] + nums[end];
            if (sum == targetSum) {
                pair[0] = nums[start];
                pair[1] = nums[end];
                break;
            } else if(sum < targetSum) {
                start++;
            } else {
                end--;
            }
        }
        return pair;
    }

    private int[] hasSumPairUsingAuxSpace(int[] nums, int target) {
        int[] pair = new int[2];
        Map<Integer, List<Integer>> numIndexMap = new HashMap<>();

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int finalI = i;
            numIndexMap.compute(nums[i], (k, v) -> {
                if (v == null) {
                    v = new ArrayList<>();
                }
                v.add(finalI);
                return v;
            });
        }

        for (int i = 0; i < n; i++) {
            int secondNum = target - nums[i];
            List<Integer> indexList = numIndexMap.get(secondNum);
            if(indexList != null) {
                for (int j = 0; j < indexList.size(); j++) {
                    if (i != indexList.get(j)) {
                        pair[0] = i;
                        pair[1] = indexList.get(j);
                        break;
                    }
                }
            }
        }
        return pair;
    }

    /**
     * O(n) time and O(n) space
     * single iteration total
     * @param nums
     * @param target
     * @return
     */
    private int[] findPairUsingAuxOptimised(int[] nums, int target) {
        int[] pair = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int secondNum = target - nums[i];
            if (map.containsKey(secondNum)) {
                pair[0] = i;
                pair[1] = map.get(secondNum);
                break;
            }
            map.put(nums[i], i);
        }
        return pair;
    }
}
