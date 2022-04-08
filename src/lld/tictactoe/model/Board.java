package lld.tictactoe.model;

import lld.tictactoe.constants.GameConstants;
import lld.tictactoe.exception.TicTacToeException;

import java.util.Arrays;

public class Board {

    private int size = GameConstants.BOARD_SIZE;

    private Cell[][] cells;

    public Board(Cell[][] cells) {
        this.cells = cells;
    }

    public int getSize() {
        return size;
    }

    public int getTotalCells() {
        return size * size;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void reset() {
        if (cells == null) {
            throw new TicTacToeException("Board has no cells");
        }
        for (int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                cells[i][j].clear();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < GameConstants.BOARD_SIZE; i++) {
            for (int j = 0; j < GameConstants.BOARD_SIZE; j++) {
                sb.append(cells[i][j].isEmpty() ? "--" : cells[i][j].getEntity().toString());
                sb.append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
