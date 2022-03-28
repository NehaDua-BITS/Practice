package dsa.medium.array;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {

    public static void main(String[] args) {
        SetMatrixZeroes obj = new SetMatrixZeroes();
        int[][] matrix = {
                {1,1,1,1},
                {1,0,1,0},
                {1,1,1,0}
        };

        System.out.println("The original matrix was : ");
        obj.printMatrix(matrix);

        obj.setZeros(matrix);
        System.out.println("Modified matrix is : ");
        obj.printMatrix(matrix);

//        System.out.println("The original matrix was : ");
//        obj.printMatrix(matrix);
//        obj.setZeroesNoSpace(matrix);
//        System.out.println("Modified matrix using 0 extra space : ");
//        obj.printMatrix(matrix);
    }

    private void setZeros(int[][] matrix)
    {
        if (matrix == null) return;

        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        findZeroes(matrix, rowSet, colSet);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rowSet.contains(i) || colSet.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private void findZeroes(int[][] matrix, Set<Integer> rowSet, Set<Integer> colSet) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
    }

    private void printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

//    public void setZeroesNoSpace(int[][] matrix) {
//
//        int rows = matrix.length;
//        int cols = matrix[0].length;
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (matrix[i][j] == 0) {
//                    matrix[i][0] = 0;
//                    matrix[0][j] = 0;
//                }
//            }
//        }
//
//        for (int i = 1; i < rows; i++) {
//            for (int j = 1; j < cols; j++) {
//                if (matrix[i][0] == 0 || matrix[0][j] == 0){
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//    }
}
