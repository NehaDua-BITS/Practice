package dsa.easy.math;

public class PrimeNumber {
    public static void main(String[] args) {
        int num = 12;
        PrimeNumber obj = new PrimeNumber();

        System.out.println("Is Prime using N/2 = " + obj.isPrime(num));

        System.out.println("Is Prime using root N = " + obj.isPrimeUsingRootN(num));
    }

    //O(sqrt(N))
    public boolean isPrimeUsingRootN(int num) {
        if (num <= 1) {
            return false;
        }

        double max = Math.sqrt(num);
        for (int i = 2; i < max; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    //O(n/2)
    public boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= num/2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
