package dsa.easy.array;

import java.util.*;

public class IntersectionArrays {

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4,};
//        int[] nums1 = {1,2,2,1};
//        int[] nums2 = {2,2};

        IntersectionArrays obj = new IntersectionArrays();
        //int[] result = obj.intersect(nums1, nums2);
        int[] result = obj.intersectUsingAux(nums1, nums2);

        System.out.println("Intersection array is : " + Arrays.toString(result));
    }

    //time=O(nlogn) space=O(n)  ; 8.13%   6.49%
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> result = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int length1 = nums1.length;
        int length2 = nums2.length;

        int i = 0, j = 0;
        while (i < length1 && j < length2) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            }
            else if (nums1[i] < nums2[j]) {
                i++;
            }
            else {
                j++;
            }
        }

        return result.stream().mapToInt(x -> x.intValue()).toArray();
    }

    //time=O(n) space=O(n)  12.57% ; 0.3MB difference in memory
    public int[] intersectUsingAux(int[] nums1, int[] nums2) {
        HashMap<Integer, MutableInt> map = new HashMap<>();

        //preparing hashmap from 1st array
        for (int n : nums1) {
            MutableInt count = map.get(n);
            if (count == null) {
                map.put(n, new MutableInt());
            } else {
                count.increment();
            }
        }

        //checking elements of second array in hashmap
        ArrayList<Integer> resultList = new ArrayList<>(Integer.min(nums1.length, nums2.length));
        for (int n : nums2) {
            MutableInt count = map.get(n);
            if (count != null) {
                resultList.add(n);
                count.decrement();
                if (count.getCount() == 0) {
                    map.remove(n);
                }
            }
        }

        return resultList.stream().mapToInt(x -> x.intValue()).toArray();
    }

    private class MutableInt {
        private int count = 1; //because counting starts with 1

        public int getCount() {
            return count;
        }

        public void increment() {
            count++;
        }

        public void decrement() {
            count--;
        }
    }

}
