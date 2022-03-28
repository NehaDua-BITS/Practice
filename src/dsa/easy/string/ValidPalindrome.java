package dsa.easy.string;

public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome vpObj = new ValidPalindrome();
        String s ="A man, a plan, a canal: Panama";
        boolean isPalindrome = vpObj.isPalindrome(s);
        System.out.println(s + " < is Palindrome > = " + isPalindrome);

        isPalindrome = vpObj.isPalindromeOptimised(s);
        System.out.println(s + " < is Palindrome > = " + isPalindrome);
    }

    public boolean isPalindrome(String s) {
        //sanitise the string
        s = s.toLowerCase();
        s = s.replaceAll("[^0-9a-z]", "");

        char[] chArray = s.toCharArray();
        int length = chArray.length;
        for (int i = 0, j = length-1; i < j; i++, j--) {
            if (chArray[i] != chArray[j]) {
                return false;
            }
        }

        return true;
    }

    private boolean isPalindromeOptimised(String s) {
        char[] chArray = s.toLowerCase().toCharArray();
        int length = chArray.length;

        for (int i = 0, j = length-1; i < j; ) {
            if (!Character.isLetterOrDigit(chArray[i])) {
                i++;
            } else if (!Character.isLetterOrDigit(chArray[j])) {
                j--;
            } else{
                if (chArray[i] != chArray[j]) {
                    return false;
                }
                i++;
                j--;
            }
        }

        return true;
    }


}
