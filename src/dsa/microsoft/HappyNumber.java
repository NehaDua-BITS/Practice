package dsa.microsoft;

/**
 * Use loop in linked list logic
 * fast and slow pointers will meet somewhere in loop
 */
public class HappyNumber {

    public static void main(String[] args) {
        int n = 19;
        HappyNumber obj = new HappyNumber();
        System.out.println(obj.isHappy(n));
    }

    public boolean isHappy(int n) {

        int slow = n;
        int fast = n;

        do {
            slow = squareOfDigits(slow);
            fast = squareOfDigits(squareOfDigits(fast));
        } while(slow != fast);

        return slow == 1;
    }

    private int squareOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += (digit * digit);
            n=n/10;
        }
        return sum;
    }
}
