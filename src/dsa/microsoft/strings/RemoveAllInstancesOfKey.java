package dsa.microsoft.strings;

/**
 *  Given an unsorted array of numbers and a target ‘key’,
 *  remove all instances of ‘key’ in-place and return the new length of the array.
 */
public class RemoveAllInstancesOfKey {

    public static void main(String[] args) {
        RemoveAllInstancesOfKey  obj = new RemoveAllInstancesOfKey();
        int[] nums = {11, 2, 11, 2, 2, 1};
        int key = 2;
        //int result =  obj.removeAllInstances(nums, key);
        int result =  obj.removeAllInstancesInOrder(nums, key);
        System.out.println("New length after key removal = " + result);
        System.out.println("Elements in array are :");
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * Approach to store all keys in second half and
     * other elements in first half
     * Order of array will get changed
     * @param nums
     * @param key
     * @return
     */
    private int removeAllInstances(int[] nums, int key) {
        int start = 0;
        int end = nums.length-1;

        while (start < end) {
            if (nums[start] != key) {
                start++;
            } else {
                int temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
                end--;
            }
        }

        System.out.println("start = " + start + " : end = " + end);
        return start;
    }

    private int removeAllInstancesInOrder(int[] nums, int key) {
        int keyIndex = 0;
        int n = nums.length;
        for (int currIndex = 0; currIndex < n; currIndex++) {
            if (nums[currIndex] != key) {
                nums[keyIndex] = nums[currIndex];
                if (currIndex != keyIndex) {
                    nums[currIndex] = key;
                }
                keyIndex++;
            }
        }

        return keyIndex;
    }
}
