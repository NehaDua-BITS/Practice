package dsa.microsoft;

import java.util.Stack;

public class BasicCalculator {

    public static void main(String[] args) {
        BasicCalculator obj = new BasicCalculator();
        String s = "1*2-3/4+5*6-7*8+9/10";
        int result = obj.calculate(s);
        System.out.println("Result = " + result);
    }

    public int calculate(String s) {

        Stack<Integer> numberStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        int length = s.length();

        StringBuilder numSb = new StringBuilder();
        for (int i = 0; i < length; i++) {

            if (s.charAt(i) == ' ') {
                continue;
            }

            if (s.charAt(i)>='0' && s.charAt(i)<='9') {
                //push to number stack
                numSb.append(s.charAt(i));
            } else {
                //push collected number to stack
                numberStack.push(Integer.valueOf(numSb.toString()));
                numSb = new StringBuilder();

                //push operator to stack
                Character currOperator = s.charAt(i);
                while (!operatorStack.isEmpty() &&
                        !topHasLessPriority(operatorStack.peek(), currOperator)) {
                    int operand2 = numberStack.pop();
                    int operand1 = numberStack.pop();
                    int result = performOperation(operand1, operand2, operatorStack.pop());
                    numberStack.push(result);
                }
                operatorStack.push(currOperator);
            }
        }

        if (numSb.length() > 0) {
            numberStack.push(Integer.valueOf(numSb.toString()));
        }

        while (!operatorStack.isEmpty()) {
            Character operation = operatorStack.pop();
            Integer op2 = numberStack.pop();
            Integer op1 = numberStack.pop();
            numberStack.push(performOperation(op1, op2, operation));
        }

        return numberStack.pop();
    }

    private Integer performOperation(Integer operand1, Integer operand2, Character operatorOnTop) {
        System.out.println(operand1 + " " + operatorOnTop + " " + operand2);
        switch (operatorOnTop) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
        }
        return -1;
    }

    private boolean topHasLessPriority(Character topChar, Character currChar) {
        switch (currChar) {
            case '*':
            case '/':
                return topChar == '+' || topChar == '-';
            default:
                return false;
        }
    }

}
