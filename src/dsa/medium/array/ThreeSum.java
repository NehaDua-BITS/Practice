package dsa.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum obj = new ThreeSum();
        int[] nums = {-2,0,0,2,2};
        System.out.println("Triplets are : ");
        List<List<Integer>> tripletsList = obj.threeSum(nums);
        System.out.println(Arrays.toString(tripletsList.toArray()));
    }

    private List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);

        int length = nums.length;

        for (int i = 0; i < length-2; i++) {
            //avoiding duplicates
            if (i == 0 || nums[i] > nums[i-1]) {
                int desiredSum = -nums[i];
                for (int start = i + 1, end = length - 1; start < end; ) {

                    //avoiding duplicates
                    if (start != i+1 && nums[start] == nums[start-1]) {
                        start++;
                        continue;
                    }

                    //avoiding duplicates
                    if (end != length-1 && nums[end] == nums[end+1]) {
                        end--;
                        continue;
                    }

                    int sum = nums[start] + nums[end];
                    if (sum == desiredSum) {
                        //found triplet
                        result.add(prepareTriplet(nums[i], nums[start], nums[end]));
                        start++;
                        end--;
                    } else if (sum < desiredSum) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }

        return result;
    }

    private List<Integer> prepareTriplet(int a, int b, int c) {
        List<Integer> triplet = new ArrayList<>(3);
        triplet.add(a);
        triplet.add(b);
        triplet.add(c);
        return triplet;
    }
}
