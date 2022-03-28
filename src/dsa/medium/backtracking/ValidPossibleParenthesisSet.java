package dsa.medium.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidPossibleParenthesisSet {

    public static void main(String[] args) {
        int n = 3; //number of parenthesis pairs
        List<String> possibleParenthesisList = new ArrayList<>(n*2);
        new ValidPossibleParenthesisSet().generatePermutations(n, possibleParenthesisList);

        System.out.println("Permutations = " + Arrays.toString(possibleParenthesisList.toArray()));
    }

    private void generatePermutations(int n, List<String> possibleParenthesisList) {
        generatePermutations(new char[n*2], 0, n, possibleParenthesisList, 0, 0);
        //generatePermutations(new char[n*2], 0, n, 0, 0);
    }

    private void generatePermutations(String str, int n, List<String> possibleParenthesisList, int openCount, int closeCount) {

        if (closeCount == n) {
            possibleParenthesisList.add(str);
            return;
        }

        if (closeCount < openCount) {
            generatePermutations(str + ")", n, possibleParenthesisList, openCount, closeCount+1);
        }

        if (openCount < n) {
            generatePermutations(str + "(", n, possibleParenthesisList, openCount+1, closeCount);
        }

    }

    private void generatePermutations(char[] arr, int pos, int n, List<String> possibleParenthesisList, int openCount, int closeCount) {

        if (closeCount == n) {
            possibleParenthesisList.add(String.valueOf(arr));
            return;
        }

        if (closeCount < openCount) {
            arr[pos] = ')';
            generatePermutations(arr, pos+1, n, possibleParenthesisList, openCount, closeCount+1);
        }

        if (openCount < n) {
            arr[pos] = '(';
            generatePermutations(arr, pos+1, n, possibleParenthesisList, openCount+1, closeCount);
        }

    }

    private void generatePermutations(char[] charArr, int pos, int n, int openCount, int closeCount) {

        if (closeCount == n) {
            System.out.println(charArr);
            return;
        }

        if (closeCount < openCount) {
            charArr[pos] = ')';
            generatePermutations(charArr, pos+1, n, openCount, closeCount+1);
        }

        if (openCount < n) {
            charArr[pos] = '(';
            generatePermutations(charArr, pos+1, n, openCount+1, closeCount);
        }

    }

}
