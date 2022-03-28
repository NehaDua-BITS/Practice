package dsa.microsoft;

public class BalancedString {

    public static void main(String[] args) {
        BalancedString obj = new BalancedString();
        String str = "CATattac"; //Madam
        System.out.println(str + " is balanced = " + obj.isStringBalanced(str));
    }

    private boolean isStringBalanced(String str) {
        boolean[] lowerCasePresent = new boolean[26];
        boolean[] upperCasePresent = new boolean[26];

        int length = str.length();
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            if (Character.isLowerCase(ch)) {
                lowerCasePresent[ch-'a'] = true;
            } else if (Character.isUpperCase(ch)) {
                upperCasePresent[ch-'A'] = true;
            }
        }

        for (int i = 0; i < 26; i++) {
            if ( (lowerCasePresent[i] && !upperCasePresent[i]) ||
                    (!lowerCasePresent[i] && upperCasePresent[i]) ) {
                return false;
            }
        }
        return true;
    }
}
