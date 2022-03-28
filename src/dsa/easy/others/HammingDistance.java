package dsa.easy.others;

import java.util.Arrays;

//The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
public class HammingDistance {

    public static void main(String[] args) {
        HammingDistance obj = new HammingDistance();
        int x = 1;
        int y = 3;
        System.out.println(String.format("Hamming distance between %d & %d = %s", x, y, obj.hammingDistance(x,y)));
    }

    private int hammingDistance(int x, int y) {
        int distance = 0;
        char[] xBinary = convertToBinary(x);
        char[] yBinary = convertToBinary(y);

        System.out.println(xBinary);
        System.out.println(yBinary);

        for (int i = 0; i < 32 ; i++) {
            if (xBinary[i] != yBinary[i]) {
                distance++;
            }
        }

        return distance;
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

        return bits;
    }
}
