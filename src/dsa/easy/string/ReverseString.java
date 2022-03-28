package dsa.easy.string;

import java.util.Arrays;

public class ReverseString {

    public static void main(String[] args) {

        char[] input = {'h','e','l','l','o'};
        ReverseString obj = new ReverseString();

        System.out.println("Input String : " + Arrays.toString(input));
        obj.reverseString(input);
        System.out.println("Reversed String : " + Arrays.toString(input));
    }

    private void reverseString(char[] s) {
        for (int i = 0, j = s.length-1; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }

}
