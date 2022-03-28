package dsa.microsoft;

import java.util.HashMap;

public class PairEqualNumbers {

    public static void main(String[] args) {
        PairEqualNumbers obj = new PairEqualNumbers();
        int[] nums = {1,2,3,2,1,3};
        boolean pairsPossible = obj.checkIfPairingPossible(nums);
        System.out.println("Equal Numbers pairing possible : " + pairsPossible);
    }

    private boolean checkIfPairingPossible(int[] nums) {
        int length = nums.length;
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        //count occurances of each number
        for (int i = 0; i < length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        //iterate over freq of each number and return false if any is odd
        for (Integer freq : freqMap.values()) {
            if (freq%2 != 0) {
                return false;
            }
        }

        return true;
    }
}
