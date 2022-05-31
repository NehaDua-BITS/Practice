package dsa.microsoft;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetRowColZero {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,1},
                {1,0,1},
                {1,1,1}};
        int rows = matrix.length;
        int cols = matrix[0].length;

        SetRowColZero obj = new SetRowColZero();
        //obj.setZeroes(matrix, rows, cols);
        obj.setZeroesWithNoAux(matrix, rows, cols);

        for (int i = 0; i < rows; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public void setZeroes(int[][] matrix, int rows, int cols) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        //identify zeros in matrix and store rol and col numbers
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        //set all elements of above row and col as zero
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rowSet.contains(i) || colSet.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    /**
     * without using aux space
     * matrix 0th row and 0th col are used for tracking
     * @param matrix
     * @param rows
     * @param cols
     */

    public void setZeroesWithNoAux(int[][] matrix, int rows, int cols) {
        boolean rowFlag = false;
        boolean colFlag = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    //if row 0
                    if (i == 0) {
                        rowFlag = true;
                    }
                    if (j == 0) {
                        colFlag = true;
                    }
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (rowFlag) {
            Arrays.fill(matrix[0], 0);
        }

        if (colFlag) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
