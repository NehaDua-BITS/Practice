package dsa.medium.sortingsearching;

import java.util.*;

public class KMostFrequent {

    public static void main(String[] args) {
        KMostFrequent obj = new KMostFrequent();
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] result = obj.topKFrequent(nums, k);
        System.out.println(String.format("Top %d elements = %s", k, Arrays.toString(result)));
    }

    public int[] topKFrequent(int[] nums, int k) {

        int[] mostFreq = new int[k];

        HashMap<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<List<Integer>> freq = new ArrayList<>(length+1);
        for (int i = 0; i <= length; i++) {
            freq.add(new ArrayList<Integer>());
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            List<Integer> list = freq.get(entry.getValue());
            list.add(entry.getKey());
        }

        int count = 0;
        for (int i = length; i >= 0; i--) {
            List<Integer> list = freq.get(i);
            for (Integer num : list) {
                mostFreq[count++] = num;
                if (count >= k) break;
            }
        }

        return mostFreq;
    }


}
