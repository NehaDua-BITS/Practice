package dsa.medium.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        Permutations obj = new Permutations();
        int[] nums = {1,2,3};
        List<List<Integer>> result = obj.permute(nums);

        System.out.println(Arrays.toString(result.toArray()));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            List<Integer> subList = new ArrayList<>();
            subList.add(nums[i]);
            boolean[] visited = new boolean[length];
            visited[i] = true;
            permute(nums, list, subList, visited);
        }
        return list;
    }

    private void permute(int[] nums, List<List<Integer>> resultList, List<Integer> subList, boolean[] visited) {

        if (subList.size() == nums.length) {
            resultList.add(new ArrayList<>(subList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                subList.add(nums[i]);
                visited[i] = true;

                permute(nums, resultList, subList, visited);

                subList.remove(subList.size()-1);
                visited[i] = false;
            }
        }

    }

}
