package dsa.medium.math;

import java.util.HashMap;
import java.util.Map;

public class Factors {

    public static void main(String[] args) {
        Factors obj = new Factors();
        int n = 1024;
        int root = obj.squareRoot(n);
        System.out.println("Square root = " + root);
    }

    private Map<Integer, Integer> getFactors(int n) {
        Map<Integer, Integer> factors = new HashMap<>(4);

        int[] primes = {2,3,5,7};
        int i = 0;
        int count = 0;
        while (n > 1 && i < primes.length) {
            int rem = n % primes[i];
            if (rem == 0) {
                count++;
                n = n / primes[i];
            } else {
                factors.put(primes[i], count);
                i++;
                count = 0;
            }
        }

        if (count > 0) {
            factors.put(primes[i], count);
        } else if (n > 1) {
            factors.put(n, 1);
        }

        return factors;
    }

    private int squareRoot(int n) {
        if (n == 0 || n == 1) return n;

        Map<Integer, Integer> factors = getFactors(n);
        for (Map.Entry<Integer, Integer> entry: factors.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        int root = 1;
        for (Map.Entry<Integer, Integer> entry : factors.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            for (int i = 1; i <= freq/2; i++) {
                root *= num;
            }
        }

        return root;
    }

}
