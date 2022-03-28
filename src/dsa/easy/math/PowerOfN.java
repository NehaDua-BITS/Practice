package dsa.easy.math;

public class PowerOfN {

    public static void main(String[] args) {
        int n = 4;
        int num = 256;

        System.out.println(String.format("Is %d Power of %d = %s",num, n, new PowerOfN().isPowerOfN(n, num)));

        System.out.println(String.format("%d Power of %d = %s",num, n, new PowerOfN().getPower(n, num)));

    }

    private boolean isPowerOfN(int n, int num) {
        return convertToBaseString(n, num).matches("^10*$");
    }

    private int getPower(int n, int num) {
        String baseString = convertToBaseString(n, num);
        if(baseString.matches("^10*$")) {
            System.out.println(baseString);
            return baseString.length() - baseString.indexOf("1") -1;
        }

        return -1;
    }

    private String convertToBaseString(int base, int num) {
        return Integer.toString(num, base);
    }

}
