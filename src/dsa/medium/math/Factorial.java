package dsa.medium.math;

import java.math.BigInteger;

public class Factorial {

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Factorial = " + new Factorial().factorial(n));
    }

    private BigInteger factorial(int n) {
        BigInteger result = new BigInteger("1");

        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }

}
