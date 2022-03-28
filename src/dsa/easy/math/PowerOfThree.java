package dsa.easy.math;

public class PowerOfThree {

    private static int k = 3;

    public static void main(String[] args) {
        PowerOfThree obj = new PowerOfThree();
        int n = 9;
        System.out.println("Num = " + n);
        System.out.println("Is Power of " + k + " using Mod = " + obj.powerOfThreeUsingMod(n));
        System.out.println("Is Power of " + k + " using Multiply = " + obj.isPowerOfThreeUsingBase(n));

        System.out.println("\n\nMax Power of 3 = " + obj.powerOfThreeUsingLog(n));
    }

    private boolean isPowerOfThreeUsingBase(int n) {
        String baseStr = Integer.toString(n, 3);
        System.out.println("\nConverted String to base 3 = " + baseStr);
        return baseStr.matches("^10*$");
    }

    private boolean powerOfThreeUsingMod(int n) {
        n = Math.abs(n);
        if (n < 1) return false;

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }


    private boolean powerOfThreeUsingLog(int n) {
        int maxPower = (int)(Math.log(Integer.MAX_VALUE) / Math.log(3));
        return n > 0 && Math.pow(3, maxPower) % n == 0;
    }

}
