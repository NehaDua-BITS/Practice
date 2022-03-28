package dsa.easy.array;

import java.util.Arrays;
import java.util.HashSet;

public class ValidSudoku {

    public static void main(String[] args) {
        ValidSudoku vsObj = new ValidSudoku();
//        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
//                {'6','.','.','1','9','5','.','.','.'},
//                {'.','9','8','.','.','.','.','6','.'},
//                {'8','.','.','.','6','.','.','.','3'},
//                {'4','.','.','8','.','3','.','.','1'},
//                {'7','.','.','.','2','.','.','.','6'},
//                {'.','6','.','.','.','.','2','8','.'},
//                {'.','.','.','4','1','9','.','.','5'},
//                {'.','.','.','.','8','.','.','7','9'}};

        char[][] board = {{'7','.','.','.','4','.','.','.','.'},
                {'.','.','.','8','6','5','.','.','.'},
                {'.','1','.','2','.','.','.','.','.'},
                {'.','.','.','.','.','9','.','.','.'},
                {'.','.','.','.','5','.','5','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','2','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'}};

        System.out.println("Is valid Sudoku = " + vsObj.isValidSudoku(board));
    }

    private boolean isValidSudoku(char[][] board) {

        //check all rows
        for (int i = 0; i < 9; i++) {
            if (hasDuplicate(new String(board[i]))) {
//                System.out.println("row issue");
                return false;
            }
        }

        //check for columns
        for (int i = 0; i < 9; i++) {
            HashSet<Character> hashSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (!hashSet.add(board[j][i])) {
//                        System.out.println("column issue");
                        return false;
                    }
                }
            }
        }

        //check for 3*3 grid
        for (int row = 0; row < 9; row+=3) {
            for (int col = 0; col < 9; col+=3) {
                if (!isGridValid(row, col, board)) {
//                    System.out.println("grid issue");
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isGridValid(int row, int col, char[][] board)
    {
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (board[i][j] != '.') {
                    if (!hashSet.add(board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean hasDuplicate(String rowStr) {
        rowStr = rowStr.replace(".", "");
        String[] digits = rowStr.split("");
        HashSet set = new HashSet(Arrays.asList(digits));
        return set.size() != digits.length;
    }
}
