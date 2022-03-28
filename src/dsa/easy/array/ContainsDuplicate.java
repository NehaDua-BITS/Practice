package dsa.easy.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
//        int[] nums = {1, 3, 7, 2};
//        int[] nums = {1, -1};

        boolean contains = new ContainsDuplicate().containsDuplicate(nums);
        System.out.println(String.format("Array = %s contains %s duplicate", Arrays.toString(nums), contains ? "" : "no"));
    }

    private boolean containsDuplicate(int[] nums) {
        if (nums == null) {
            return false;
        }

        Set<Integer> hashSet = new HashSet<>();
        int length = nums.length;

        for (int i = 0; i < length ; i++) {
            if (!hashSet.add(nums[i])) {
                return true;
            }
        }

        return false;
    }

}
