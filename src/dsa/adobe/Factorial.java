package dsa.adobe;

import java.math.BigInteger;

public class Factorial {

    public static void main(String[] args) {
        Factorial obj = new Factorial();
        int n = 100;
        System.out.println(String.format("Iterative Factorial of %d is = %d", n, obj.factorial(n)));
        System.out.println(String.format("Recursive Factorial of %d is = %d", n, obj.recFactorial(n)));
        System.out.println(String.format("BigInteger Factorial of %d is = %s", n, obj.bigIntegerFactorial(n)));
    }

    //basic iterative approach
    private long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int fact = 1;
        while (n > 0) {
            fact *= n;
            n--;
        }
        return fact;
    }

    //recursive approach
    private int recFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * recFactorial(n-1);
    }

    private String bigIntegerFactorial(int n) {
        BigInteger bigInteger = BigInteger.ONE;
        int i = 1;
        while (i <= n) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
            i++;
        }

        return bigInteger.toString();
    }

}
