package dsa.easy.math;

import java.util.Arrays;

public class PrimeNumbersBelowN {

    private PrimeNumber obj = new PrimeNumber();

    public static void main(String[] args) {
        int n = 100;
        PrimeNumbersBelowN obj = new PrimeNumbersBelowN();

        int count = obj.primeNumbersBelowN(n);
        System.out.println("Number of prime numbers below " + n + " = " + count);

        count = obj.primeUptoNUsingEratosthenes(n);
        System.out.println("Number of prime numbers below " + n + " using Sieve of Eratosthenes = " + count);
    }

    private int primeNumbersBelowN(int n) {

        int count  = 0;
        for (int i = 1; i < n; i++) {
            if (obj.isPrime(i)) {
                System.out.println(i);
                count++;
            }
        }

        return count;
    }

    //Sieve of Eratosthenes
    //all prime numbers upto N
    private int primeUptoNUsingEratosthenes(int n) {
        boolean isPrime[] = new boolean[n+1];
        Arrays.fill(isPrime, true);

        double max = Math.sqrt(n);
        for (int i = 2; i < max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j = j + i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
                System.out.println(i);
            }
        }
        return count;
    }

}
