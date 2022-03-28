package dsa.medium.math;

public class HappyNumber {

    public static void main(String[] args) {
        int n = 19;
        System.out.println("Is happy number = " + new HappyNumber().isHappy(n));
    }

    private boolean isHappy(int n) {

        int slow = n, fast = n;

        do {
            slow = digitsSquareSum(slow);
            fast = digitsSquareSum(digitsSquareSum(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private int digitsSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n%10) * (n%10);
            n /= 10;
        }

        return sum;
    }
}
