package dsa.medium.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Powerset of a set
* No duplicate subsets allowed
 */

public class Subsets {

    public static void main(String[] args) {
        Subsets obj = new Subsets();
        int[] nums = {1,2,3};
        List<List<Integer>> result = obj.subsets(nums);
        System.out.println("Subsets are : \n" + Arrays.toString(result.toArray()));
    }

    private List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums != null && nums.length > 0) {
            result.add(new ArrayList<>()); //add empty subset
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                subset.add(nums[i]);
                subsets(nums, i, result, subset);
                subset.remove(0);
            }
        }
        return result;
    }

    private void subsets(int[] nums, int pos, List<List<Integer>> result, List<Integer> subset) {

        result.add(new ArrayList<>(subset));

        if (subset.size() == nums.length) return;

        for (int j = pos + 1; j < nums.length; j++) {
            subset.add(nums[j]);
            subsets(nums, j, result, subset);
            subset.remove(subset.size() - 1);
        }
    }

}
