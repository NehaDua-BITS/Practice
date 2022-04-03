package dsa.adobe;

public class NumOfSetBits {

    public static void main(String[] args) {
        NumOfSetBits obj = new NumOfSetBits();
        int num = -12;
        int count = obj.countSetBits(num);
        System.out.println(String.format("Number of set bits in %d = %d", num, count));
        System.out.println("Num of set 1s using binary string = " + obj.countSetBitsUsingBinary(num));
    }

    private int countSetBits(int num) {
        int count = 0;
        while (num != 0) {
            if((num & 1) == 1) {
                count++;
            }
            System.out.println(num);
            num = num >>> 1;
        }
        return count;
    }

    private int countSetBitsUsingBinary(int num) {
        String binaryStr = Integer.toUnsignedString(num, 2);
        System.out.println("Binary string = " + binaryStr);

        int count = 0;
        int length = binaryStr.length();
        for (int i = 0; i < length; i++) {
            if (binaryStr.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}
