package dsa.microsoft;

public class LargestAlphabeticCharacter {

    public static void main(String[] args) {
        LargestAlphabeticCharacter obj = new LargestAlphabeticCharacter();
        String str = "admeDCAB";
        System.out.println("Largest Alphabetic Character = " + obj.largestAlphabeticCharacter(str));
    }

    private String largestAlphabeticCharacter(String str) {
        char result = 0;
        boolean[] lowerCasePresent = new boolean[26];
        boolean[] upperCasePresent = new boolean[26];

        int length = str.length();
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            int index = -1;
            if (Character.isLowerCase(ch)) {
                index = ch - 'a';
                lowerCasePresent[index] = true;
            } else if (Character.isUpperCase(ch)) {
                index = ch - 'A';
                upperCasePresent[index] = true;
            }
            if (index != -1 && lowerCasePresent[index] && upperCasePresent[index]) {
                result = (char) Math.max(result, 'A' + index);
            }
        }

        //OR iterate from right side of array to get maximum
        //if want to iterate again

        return result == 0 ? "-1" : String.valueOf(result);
    }
}
