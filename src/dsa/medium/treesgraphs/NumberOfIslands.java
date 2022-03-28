package dsa.medium.treesgraphs;

import java.util.Arrays;

public class NumberOfIslands {

    //4 possible directions
    int[] rowOffset = {0, 0, -1, 1};
    int[] colOffset = {-1, 1, 0, 0};

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '1'}
        };

        System.out.println("Number of islands = " + new NumberOfIslands().numIslands(grid));
    }

    public int numIslands(char[][] grid) {

        int count = 0;

        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        boolean visited[][] = new boolean[rows][cols];
        for(int i = 0; i < rows; i++) {
            Arrays.fill(visited[i], false);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    count++;
                    identifyConnectedOnes(grid, i, j, visited);
                }
            }
        }

        return count;

    }

    private void identifyConnectedOnes(char[][] grid, int row, int col, boolean[][] visited) {

        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            if (isSafe(grid, row+rowOffset[i], col+colOffset[i], visited)) {
                identifyConnectedOnes(grid, row + rowOffset[i], col + colOffset[i], visited);
            }
        }
    }

    private boolean isSafe(char[][] grid, int r, int c, boolean[][] visited) {
        return (r>=0 && r<grid.length) && (c>=0 && c<grid[0].length) &&
                (visited[r][c] == false) && (grid[r][c] == '1');
    }
}
