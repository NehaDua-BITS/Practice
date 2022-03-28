package dsa.easy.searchsort;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0}, nums2 = {2,5,6};
        int m = 3, n = 3;

        System.out.println("Original Arrays = \n" + Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));

        MergeSortedArray obj = new MergeSortedArray();
        obj.mergeUsingAux(nums1, m, nums2, n);

        System.out.println("Merged Array = " + Arrays.toString(nums1));
    }

    private void mergeUsingAux(int[] nums1, int m, int[] nums2, int n) {

        int[] mergedArray = new int[m+n];

        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                mergedArray[k++] = nums1[i++];
            } else {
                mergedArray[k++] = nums2[j++];
            }
        }

        while (i < m) {
            mergedArray[k++] = nums1[i++];
        }

        while(j < n) {
            mergedArray[k++] = nums2[j++];
        }

        for (int index = 0; index < m+n; index++) {
            nums1[index] = mergedArray[index];
        }
    }
}
