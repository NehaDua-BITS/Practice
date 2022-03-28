package dsa.medium.math;

public class DivideNumbers {

    public static void main(String[] args) {
        DivideNumbers obj = new DivideNumbers();
        int dividend = 21, divisor = 3;
        System.out.println(obj.divide(dividend, divisor));
    }

    private int divide(int dividend, int divisor) {

        int quotient = 0;
        while (dividend >= divisor) {
            dividend = dividend - divisor;
            quotient++;
        }
        return quotient;
    }
}

