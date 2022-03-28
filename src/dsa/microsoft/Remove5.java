package dsa.microsoft;

public class Remove5 {

    public static void main(String[] args) {
        int num = 895;

        Remove5 obj = new Remove5();
        System.out.println("Max number after removing 5 = " + obj.maxNumAfterRemovingDigit(num));
    }

    private int maxNumAfterRemovingDigit(int num) {
        if (num == 0) return 0;

        int max = Integer.MIN_VALUE;
        String numStr = String.valueOf(num);
        int length = numStr.length();

        for (int i = 0; i < length; i++) {
            if (numStr.charAt(i) != '-' && numStr.charAt(i) != '+') {
                if (numStr.charAt(i) == '5') {
                    String temp = numStr.substring(0, i) + ((i+1 < length) ? numStr.substring(i+1) : "");
                    System.out.println("Number = " + temp);
                    max = Math.max(max, Integer.parseInt(temp));
                }
            }
        }

        return max;
    }

}
