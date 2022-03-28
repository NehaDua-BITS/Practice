package dsa.medium.others;

import java.util.Stack;

public class EvaluateReversePolishExpression {

    public static void main(String[] args) {
        EvaluateReversePolishExpression obj = new EvaluateReversePolishExpression();
        String[] tokens = {"4","13","5","/","+"};

        System.out.println("The result of expression = " + obj.evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        int length = tokens.length;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {

            if (tokens[i].equals("+") || tokens[i].equals("-")
                    || tokens[i].equals("*") || tokens[i].equals("/")) {
                //pop elements from stack and push result
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                int result = 0;
                switch(tokens[i]) {
                    case "+":
                        result = operand2 + operand1;
                        break;

                    case "-":
                        result = operand2 - operand1;
                        break;

                    case "/":
                        result = operand2 / operand1;
                        break;

                    case "*":
                        result = operand2 * operand1;
                        break;
                }
                stack.push(result);
            } else {
                //push the operand to stack
                stack.push(Integer.valueOf(tokens[i]));
            }
        }

        return stack.pop();
    }
}
