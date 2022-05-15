package dsa.medium.array;

import java.util.Arrays;

public class LargestPlusSign {

    public static void main(String[] args) {
        int n = 5;
        int[][] mines = {{4,2}};
//        int n = 2;
//        int[][] mines = {{0,0}, {0,1}, {1,0}};

        LargestPlusSign obj = new LargestPlusSign();
        int result = obj.orderOfLargestPlusSign(n, mines);

        System.out.println("Largest Plus Sign Size = " + result);
    }

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int maxOrder = 0;

        int[][] grid = new int[n][n];
        initGrid(grid, n, 1);
        setMines(grid, n, mines);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int max = findMaxLength(i, j, grid, n);
                    maxOrder = Math.max(maxOrder, max);
                }
            }
        }

        return maxOrder;
    }

    private int findMaxLength(int centerRow, int centerCol, int[][] grid, int n) {
        int row[] = {0, 0, 1, -1};
        int col[] = {1, -1, 0, 0};

        int iteration = 1;
        while(true) {
            boolean isValid = true;
            for (int i = 0; i < 4; i++) {
                int newRow = centerRow + (iteration * row[i]);
                int newCol = centerCol + (iteration * col[i]);
                if (!isValidPosition(newRow, newCol, grid, n)) {
                    isValid = false;
                    break;
                }
            }
            if (!isValid) {
                break;
            }
            iteration++;
        }

        return iteration; //no valid arm found
    }

    private boolean isValidPosition(int row, int col, int[][] grid, int n) {
        return row >= 0 && row < n
                && col >= 0 && col < n
                && grid[row][col] == 1;
    }

    private void initGrid(int[][] grid, int n, int val) {
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], val);
        }
    }

    private void setMines(int[][] grid, int n, int[][] mines) {
        int numOfMines = mines.length;
        for (int i = 0; i < numOfMines; i++) {
            grid[mines[i][0]][mines[i][1]] = 0;
        }
    }

}
