package dsa.adobe;

public class ReverseWordByWord {

    public static void main(String[] args) {

        ReverseWordByWord obj = new ReverseWordByWord();
        String inputString = "Welcome to geeksforgeeks ";
        System.out.println("String with reversed words = " + obj.reverseWordsInString(inputString));
        System.out.println("String reversed word by word = " + obj.reverseStringByWords(inputString));
    }

    private String reverseWordsInString(String inputString) {
        StringBuilder result = new StringBuilder();

        int length = inputString.length();
        int startIndex = 0;
        int currIndex = 0;
        for (; currIndex < length; currIndex++) {
            if (Character.isSpaceChar(inputString.charAt(currIndex))) {
                result.append(reverseWord(inputString.substring(startIndex, currIndex)));
                result.append(inputString.charAt(currIndex));
                startIndex = currIndex + 1;
            }
        }

        result.append(reverseWord(inputString.substring(startIndex, currIndex)));

        System.out.println("length 1 : " + result.length());
        return result.toString();
    }

    private String reverseStringByWords(String s) {
        StringBuilder result = new StringBuilder();

        String inputString = reverseWord(s);
        int length = inputString.length();
        int startIndex = 0;
        int currIndex = 0;
        for (; currIndex < length; currIndex++) {
            if (Character.isSpaceChar(inputString.charAt(currIndex))) {
                result.append(reverseWord(inputString.substring(startIndex, currIndex)));
                result.append(inputString.charAt(currIndex));
                startIndex = currIndex + 1;
            }
        }

        result.append(reverseWord(inputString.substring(startIndex, currIndex)));

        System.out.println("Length 2 = " + result.length());
        return result.toString();
    }

    private String reverseWord(String str) {
        if (str == null || str.length() == 1) {
            return str;
        }
        return new StringBuilder(str).reverse().toString();
    }
}
