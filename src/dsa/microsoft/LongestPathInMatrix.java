package dsa.microsoft;

import java.util.Arrays;

//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/submissions/

public class LongestPathInMatrix {

    public static void main(String[] args) {
        LongestPathInMatrix obj = new LongestPathInMatrix();
//        int[][] matrix = {{1,2},
//                {3,3}
//        };
        int[][] matrix = {
                {9,9,4},
                {6,6,8},
                {2,1,1}
        };
        int result = obj.findLongestIncreasingPath(matrix);
        System.out.println("Longest Path length = " + result);
    }

    private int findLongestIncreasingPath(int[][] matrix) {
        int maxLength = Integer.MIN_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] longestPath = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(longestPath[i], -1);
        }

        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = true;
                maxLength = Math.max(maxLength, findLongestIncreasingPath(matrix, i, j, visited, 1, longestPath));
                visited[i][j] = false;
            }
        }
        return maxLength;
    }

    private int findLongestIncreasingPath(int[][] matrix, int row, int col, boolean[][] visited, int length, int[][] longestPath) {
        int[] rows = {1, -1, 0, 0};
        int[] cols = {0, 0, 1, -1};

        int maxLength = 0;
        for (int i = 0; i < rows.length; i++) {
            int nextRow = row + rows[i];
            int nextCol = col + cols[i];
            if (isValid(matrix, matrix[row][col], nextRow, nextCol, visited)) {
                if (longestPath[nextRow][nextCol] != -1) {
                    maxLength = Math.max(maxLength, longestPath[nextRow][nextCol]);
                } else {
                    visited[nextRow][nextCol] = true;
                    int result = findLongestIncreasingPath(matrix, nextRow, nextCol, visited, 1, longestPath);
                    maxLength = Math.max(maxLength, result);
                    visited[nextRow][nextCol] = false;
                }
            }
        }

        longestPath[row][col] = maxLength + length;
        return longestPath[row][col];
    }

    private boolean isValid(int[][] matrix, int currValue, int nextRow, int nextCol, boolean[][] visited) {
        return nextRow>=0 && nextRow < matrix.length
                && nextCol >=0 && nextCol < matrix[0].length
                && !visited[nextRow][nextCol]
                && matrix[nextRow][nextCol] > currValue;
    }
}
