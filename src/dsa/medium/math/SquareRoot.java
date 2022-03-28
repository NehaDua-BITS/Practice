package dsa.medium.math;

public class SquareRoot {

    public static void main(String[] args) {
        SquareRoot obj = new SquareRoot();
        int x = 2147395599;
        System.out.println("Square Root of " + x + " = " + obj.mySqrt(x));
    }

    private int mySqrt(int x) {
        if ( x==0 || x==1) return x;

        //use binary search for finding floor value
        long low = 1, high = x/2;
        long ans = 0;
        while (low <= high) {
            long mid = (low+high)/2;
            long midSquare = mid * mid;
            if (midSquare == x) {
                return (int)mid;
            }

            if (midSquare < x) {
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return (int)ans;
    }

}
