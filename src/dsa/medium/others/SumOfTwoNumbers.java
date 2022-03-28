package dsa.medium.others;

public class SumOfTwoNumbers {

    public static void main(String[] args) {
        SumOfTwoNumbers obj = new SumOfTwoNumbers();
        int a = 5, b = 7;
        int sum = obj.getSum(a, b);
        System.out.println("Sum of 2 numbers without using arithmetic operators = " + sum);
    }

    public int getSum(int a, int b) {

        while (b != 0) {
            int sum = a ^ b;
            int carry = a & b;
            a = sum;
            b = (carry << 1);
        }

        return a;
    }
}
