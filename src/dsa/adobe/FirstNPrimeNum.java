package dsa.adobe;

import java.util.Arrays;

public class FirstNPrimeNum {

    public static void main(String[] args) {
        int n = 20;
        FirstNPrimeNum obj = new FirstNPrimeNum();
        int[] primes = obj.firstNPrimeNums(n);
        System.out.println(String.format("First %d Prime no.s are : %s", n, Arrays.toString(primes)));
    }

    private int[] firstNPrimeNums(int n) {
        int[] primes = new int[n];
        int count = 0;
        int num = 2;
        while (count < n) {
            if (isPrime(num)) {
                primes[count++] = num;
            }
            num++;
        }
        return primes;
    }

    private boolean isPrime(int num) {
        int limit = (int)Math.sqrt((double)num);
        for (int i = 2; i <= limit; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
