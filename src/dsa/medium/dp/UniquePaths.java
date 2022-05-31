package dsa.medium.dp;

import java.util.Arrays;

public class UniquePaths {

    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        System.out.println("Number of unique paths = " + new UniquePaths().uniquePathsOptimised(m,n));
    }

    private int uniquePathsOptimised(int m, int n) {
        int pathsCount[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(pathsCount[i], -1);
        }
        return uniquePathsUtilOptimised(m, n, 0, 0, pathsCount);
    }

    private int uniquePathsUtilOptimised(int rows, int cols, int r, int c, int[][] pathsCount) {
        int[] row = {0, 1};
        int[] col = {1, 0};

        if (r == rows-1 && c == cols-1) {
            return 1;
        }

        int count = 0;
        for (int i = 0; i < 2; i++) {
            int nextRow = r + row[i];
            int nextCol = c + col[i];
            if (isValidOptimised(nextRow, nextCol, rows, cols, pathsCount)) {
                if (pathsCount[nextRow][nextCol] == -1) {
                    count += uniquePathsUtilOptimised(rows, cols, nextRow, nextCol, pathsCount);
                } else {
                    count += pathsCount[nextRow][nextCol];
                }
            }
        }

        pathsCount[r][c] = count;
        return count;
    }

    private boolean isValidOptimised(int r, int c, int rows, int cols, int[][] pathsCount) {
        return (r >= 0 && r < rows)
                && (c >= 0 && c < cols);
    }

    //    private int uniquePaths(int m, int n) {
//        boolean visited[][] = new boolean[m][n];
//        visited[0][0] = true;
//        return uniquePathsUtil(m, n, 0, 0, visited);
//    }

//    private int uniquePathsUtil(int rows, int cols, int r, int c, boolean[][] visited) {
//        int[] row = {0, 1};
//        int[] col = {1, 0};
//
//        if (r == rows-1 && c == cols-1) {
//            visited[r][c] = false;
//            return 1;
//        }
//
//        int count = 0;
//        for (int i = 0; i < 2; i++) {
//            if (isValid(r + row[i], c + col[i], rows, cols, visited)) {
//                visited[r][c] = true;
//                count += uniquePathsUtil(rows, cols, r + row[i], c + col[i], visited);
//                visited[r][c] = false;
//            }
//        }
//
//        return count;
//    }
//
//    private boolean isValid(int r, int c, int rows, int cols, boolean[][] visited) {
//        return (r >= 0 && r < rows)
//                && (c >= 0 && c < cols)
//                && !visited[r][c];
//    }



}
