package dsa.adobe;

import java.util.Arrays;
import java.util.Random;

public class ShuffleArray {

    private final int[] nums;
    private int length;

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        ShuffleArray obj = new ShuffleArray(arr);
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.reset()));
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.reset()));
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.shuffle()));
    }

    public ShuffleArray(int[] nums) {
        this.length = nums.length;
        this.nums = Arrays.copyOf(nums, length);
    }

    public int[] reset() {
        return Arrays.copyOf(nums, length);
    }

    public int[] shuffle() {
        int[] shuffledArr = Arrays.copyOf(nums, length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int newIndex = i + random.nextInt(length-i);
            int temp = shuffledArr[i];
            shuffledArr[i] = shuffledArr[newIndex];
            shuffledArr[newIndex] = temp;
        }
        return shuffledArr;
    }
}
