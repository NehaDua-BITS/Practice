package dsa.easy.others;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String s = "[[]]";
//        String s = "]";
        System.out.println("Is Valid Expression = " + new ValidParentheses().isValid(s));
    }

    private boolean isValid(String s) {

        Stack<Character> stack = new Stack();

        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else {

                if (stack.empty()) {
                    return false;
                }

                char poppedChar = stack.pop();
                if ( !((poppedChar == '{' && ch == '}') ||
                        (poppedChar == '[' && ch == ']') || (poppedChar == '(' && ch == ')')) ) {
                    return false;
                }
            }
        }

        return stack.empty();
    }
}
