package dsa.medium.math;

public class Power {

    public static void main(String[] args) {
        double x = 2.0000;
        int n = -2147483648;
        double power = new Power().myPow(x, n);
        System.out.println("Power using normal calculation = " + power);
    }

    public double myPow(double x, int n) {
        double result = _myPow(x, Math.abs(n));
        return n < 0 ? (1.0/result) : result;
    }

    public double _myPow(double x, int n) {
        if (x  == 1.0 || n == 1 || x == 0.0) {
            return x;
        }
        if (n == 0) {
            return 1.0;
        }

        double val = _myPow(x, n/2);
        double result = val * val;
        if (Math.abs(n)%2 != 0) {
            result *= x;
        }

        return result;
    }

}
