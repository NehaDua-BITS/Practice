package dsa.easy.others;

import java.util.Arrays;

public class NumOfOnes {

    public static void main(String[] args) {
        NumOfOnes obj = new NumOfOnes();
        int n = -3;
        int count = obj.hammingWeight(n);
        System.out.println(String.format("No. of 1s in %s = %s", n, count));

        System.out.println("Number of 1s using native method = " + obj.hammingWeightNative(n));
    }

    private int hammingWeight(int n) {
        String binary = Integer.toUnsignedString(n, 2);
        return (int)Arrays.stream(binary.split("")).filter(ch -> ch.equals("1")).count();
    }

    private int hammingWeightNative(int n) {
        char[] signedBinary = convertToBinary(n);
        System.out.println(signedBinary);
        if (n < 0) {
            convertToUnsignedBinary(signedBinary);
        }
        System.out.println(signedBinary);
        return countOnes(signedBinary);
    }

    private int countOnes(char[] signedBinary) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (signedBinary[i] == '1'){
                count++;
            }
        }
        return count;
    }

    private char[] convertToBinary(int n) {
        char[] bits = new char[32];
        Arrays.fill(bits, '0');

        n = Math.abs(n);
        int index = 31;
        while (n > 0) {
            int bit = n % 2;
            n = n/2;
            bits[index--] = (bit == 1) ? '1' : '0';
        }
        System.out.println("Binary using native = " + Arrays.toString(bits));
        return bits;
    }

    private void convertToUnsignedBinary(char[] binary) {

        int i = 31;
        for (; i>=0 && binary[i] == '0'; i--);

        if (i>=0) {
            //found 1st one
            for (i = i-1; i >= 0; i--) {
                if (binary[i] == '0') {
                    binary[i] = '1';
                } else {
                    binary[i] = '0';
                }
            }
        }
    }
}
