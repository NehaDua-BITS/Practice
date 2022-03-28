package dsa.medium.dp;

import java.util.Arrays;

//paths with obstacles
public class UniquePathsII {

    public static void main(String[] args) {
        UniquePathsII obj = new UniquePathsII();
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int countUniquePaths = obj.uniquePathsWithObstacles(obstacleGrid);
        System.out.println("No. of unique paths = " + countUniquePaths);

    }

    private int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) {
            return 0;
        }

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[][] pathsCount = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(pathsCount[i], -1);
        }

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        return uniquePathsWithObstacles(obstacleGrid, pathsCount, 0, 0, rows, cols);
    }

    private int uniquePathsWithObstacles(int[][] obstacleGrid, int[][] pathsCount, int r, int c, int rows, int cols) {
        int rIndex[] = {1, 0};
        int cIndex[] = {0, 1};

        if (r == rows - 1 && c == cols - 1) {//reached bottom-right cell
            return obstacleGrid[r][c] == 0 ? 1 : 0;
        }

        if (pathsCount[r][c] != -1) { //return if already calculated
            return pathsCount[r][c];
        }

        //else calculate unique paths
        int count = 0;
        for (int i = 0; i < 2; i++) {
            int newRow = r + rIndex[i];
            int newCol = c + cIndex[i];
            if (isValid(newRow, newCol, rows, cols, obstacleGrid)) {
                pathsCount[newRow][newCol] = uniquePathsWithObstacles(obstacleGrid, pathsCount, newRow, newCol, rows, cols);
                count += pathsCount[newRow][newCol];
            }
        }
        pathsCount[r][c] = count;

        return pathsCount[r][c];
    }

    private boolean isValid(int newRow, int newCol, int rows, int cols, int[][] obstacleGrid) {
        return newRow >= 0 && newRow < rows
                && newCol >= 0 && newCol < cols
                && obstacleGrid[newRow][newCol] != 1;
    }
}
