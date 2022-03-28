package dsa.microsoft;

public class SignOfProduct {

    public static void main(String[] args) {
        int[] nums = {-2,11,-3,-5,-9};
        SignOfProduct obj = new SignOfProduct();
        char sign = obj.signOfProduct(nums);
        System.out.println("Sign of product = " + sign);
    }

    private char signOfProduct(int[] nums) {
        int length = nums.length;
        int countNegative = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0)
                return '0';

            if (nums[i] < 0) {
                countNegative++;
            }
        }

        return (countNegative == 0 || (countNegative>0 && countNegative%2 == 0)) ? '+' : '-';
    }
}
