package dsa.adobe;

import java.util.Arrays;

public class SumFirstNPrimeNum {

    public static void main(String[] args) {
        SumFirstNPrimeNum obj = new SumFirstNPrimeNum();
        int n = 10;
        int sum = obj.sumFirstNPrimes(n);
        System.out.println(String.format("Using Normal Operation : Sum of first %d Prime nums = %d", n, sum));

        sum = obj.sumPrimeNumUsingSieve(n);
        System.out.println(String.format("Using Sieve : Sum of first %d Prime nums = %d", n, sum));;
    }

    private int sumFirstNPrimes(int n) {
        int sum = 0;
        int count = 0;
        int num = 2;
        while (count < n) {
            if (isPrime(num)) {
                //System.out.print(num + " ");
                sum += num;
                count++;
            }
            num++;
        }
        return sum;
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

    private int sumPrimeNumUsingSieve(int n) {
        int sum = 0;
        int count = 0;
        boolean[] sieve = createSieve(1000);
        for (int i = 0; i <= 1000 && count < n; i++) {
            if (sieve[i]) {
                sum += i;
                count++;
            }
        }
        return sum;
    }

    //create Sieve of Eratosthenis
    private boolean[] createSieve(int max) {

        boolean[] sieve = new boolean[max+1];
        Arrays.fill(sieve, true);
        sieve[1] = false;
        sieve[0] = false;

        for (int n = 2; n*n <= max; n++) {
           if (sieve[n]) { //is prime
               //mark all factors of n as non-prime
               for (int i = 2*n; i <= max; i+=n) {
                   sieve[i] = false;
               }
           }
        }

        return sieve;
    }
}
