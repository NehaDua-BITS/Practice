package dsa.easy.array.RotateArray;

public interface IRotateArray {

    void rotateArrayUsingAux(int[] nums, int k);

    void rotateArrayWithoutAux(int[] nums, int k);

    static void swap(int[] nums, int start, int end) {
        int temp;
        for (int i = start, j = end; i < j; i++, j--) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
