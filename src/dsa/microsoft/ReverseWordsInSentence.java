package dsa.microsoft;

public class ReverseWordsInSentence {

    public static void main(String[] args) {
        ReverseWordsInSentence obj = new ReverseWordsInSentence();
        String input = "sphinx of black quartz judge my vow";

//        String reverseStr = obj.reverseWords(input);
//        System.out.println("Reversed string = " + reverseStr);

        String reverseStr = obj.reverseWordsNative(input);
        System.out.println("Reversed string = " + reverseStr);
    }

    /**
     * using tokenisation
     * @param input
     * @return
     */
    private String reverseWords(String input) {
        String[] tokens = input.split("\\s+");
        int n = tokens.length;
        for (int i = 0, j = n-1; i < j; i++, j--) {
            String temp = tokens[i];
            tokens[i] = tokens[j];
            tokens[j] = temp;
        }

        return String.join(" ", tokens);
    }

    /**
     * reverse without using any string function
     * @param input
     * @return
     */
    private String reverseWordsNative(String input) {
        StringBuilder sb = new StringBuilder(input);
        int length = input.length();

        //reverse entire string
        reverse(sb, 0, length-1);

        System.out.println(sb.toString());

        //reverse word by word
        int start = 0;
        int end = -1;
        for (int i = 0; i < length; i++) {
            if (Character.isSpaceChar(sb.charAt(i))) {
                reverse(sb, start, end);
                start = i+1;
                end = i;
            } else {
                end++;
            }
        }

        reverse(sb, start, end);

        return sb.toString();
    }

    private void reverse(StringBuilder sb, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char ch = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, ch);
        }
    }
}
