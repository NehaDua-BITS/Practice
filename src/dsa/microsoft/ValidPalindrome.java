package dsa.microsoft;

public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        ValidPalindrome obj = new ValidPalindrome();
        System.out.println("Is Palindrome = " + obj.isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String alphaNumericStr = s.replaceAll("\\W", "");
        StringBuilder sb = new StringBuilder(alphaNumericStr);
        return alphaNumericStr.equals(sb.reverse().toString());
    }
}
