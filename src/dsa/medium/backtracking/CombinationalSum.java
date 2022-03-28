package dsa.medium.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Similar to coin change combinations problem
public class CombinationalSum {

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> result = new CombinationalSum().combinationSum(candidates, target);
        System.out.println("Combinations are : " + Arrays.toString(result.toArray()));
    }

    private List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        Arrays.sort(candidates);
        for (int i = 0; i < candidates.length; i++) {
            subList.add(candidates[i]);
            combinationSum(candidates, i, target - candidates[i], subList, resultList);
            subList.remove(subList.size()-1);
        }
        return resultList;
    }

    private void combinationSum(int[] candidates, int index, int sum, List<Integer> subList, List<List<Integer>> resultList) {
        if (sum == 0) {
            resultList.add(new ArrayList<>(subList));
            return;
        }

        for (int i = index; i < candidates.length && (sum-candidates[i] >= 0); i++) {
            subList.add(candidates[i]);
            combinationSum(candidates, i, sum - candidates[i], subList, resultList);
            subList.remove(subList.size()-1);
        }
    }
}
