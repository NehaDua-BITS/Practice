package dsa.medium.math;

public class TrailingZeroesFactorial {

    public static void main(String[] args) {
        TrailingZeroesFactorial obj = new TrailingZeroesFactorial();
        int n = 100;
        System.out.println("Number of Zeroes = " + obj.countTrailingZeroes(n));
    }

    private int countTrailingZeroes(int n) {

        //count no. of 10s or factors 5s and 2s
        //5s will be <= 2s, so find 5s only
        int count = 0;
        for (int i = 5; n/i >= 1; i = i * 5) {
            count += n/i;
        }
        return count;
    }
}
