package dsa.easy.string;

public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger riObj = new ReverseInteger();
        int x  = 12;
        int result = riObj.reverse(x);
        System.out.println(String.format("Original Int = %s ; Reversed Int = %s", x, result));
    }

    private int reverse(int x) {
        int result = 0;
        String s = String.valueOf(x);
        int length = s.length();

        int beginIndex = s.charAt(0) == '-' ? 1 : 0; //ignoring - for reversing
        int endIndex = length-1;
        for (;endIndex >= 0 && s.charAt(endIndex) == '0'; endIndex--); //finding last position for trailing 0 to ignore for reversing

        StringBuilder sb = new StringBuilder(s.substring(beginIndex, endIndex+1));
        sb.reverse();

        if (s.charAt(0) == '-') {
            sb.insert(0, '-');
        }

        try {
            result = Integer.valueOf(sb.toString());
        } catch (NumberFormatException ex) {
        }

        return result;
    }
}
