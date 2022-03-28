package dsa.easy.array;

public class NonRepeatedSingleNumber {

    public static void main(String[] args) {
        int nums[] = {2, 1, 2, 9, 9};

        System.out.println(String.format("Non-Repeated number = %s ", new NonRepeatedSingleNumber().singleNumber(nums)));

    }

    private int singleNumber(int[] nums) {
        int result = 0;
        for (int n : nums) {
            result ^= n;
        }
        return result;
    }
}
