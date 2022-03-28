package dsa.medium.backtracking;

public class WordSearch {

    public static void main(String[] args) {
        WordSearch obj = new WordSearch();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println("Word exists = " + obj.exist(board, word));

    }

    private boolean exist(char[][] board, String word) {
        if (board == null || (board.length * board[0].length < word.length())) {
            return false;
        }

        int numRows = board.length;
        int numCols = board[0].length;
        boolean[][] visited = new boolean[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (exist(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean exist(char[][] board, String word, int index, int r, int c, boolean[][] visited) {

        int[] rows = {0, 0, 1, -1};
        int[] cols = {1, -1, 0, 0};

        if (isValid(board, r, c, visited) && word.charAt(index) == board[r][c]) {
            visited[r][c] = true;
            index++;
            if (index == word.length()) {
                return true;
            }

            for (int k = 0; k < 4; k++) {
                if (exist(board, word, index, r + rows[k], c + cols[k], visited)) {
                    return true;
                }
            }

            visited[r][c] = false;
        }

        return false;
    }

    private boolean isValid(char[][] board, int r, int c, boolean[][] visited) {
        return r >= 0 && r < board.length
                && c >= 0 && c < board[0].length
                && !visited[r][c];
    }

}
