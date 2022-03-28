package dsa.easy.array;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum obj = new TwoSum();
//        int[] nums = {2,7,11,15};
//        int target = 9;

        int[] nums = {2,7,10,5};
        int target = 12;

        int[] pair = obj.findPair(nums, target);
        System.out.println(String.format("Pair with sum = %s is : %s", target, Arrays.toString(pair)));
    }

    //beats 57% runtime
    private int[] findPair(int[] nums, int target) {
        int[] pair = new int[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null && index != i) {
                pair = new int[2];
                pair[0] = i;
                pair[1] = index;
                break;
            }
        }

        return pair;
    }
}
