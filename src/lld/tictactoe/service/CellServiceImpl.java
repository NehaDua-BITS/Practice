package lld.tictactoe.service;

import lld.tictactoe.constants.Entity;
import lld.tictactoe.constants.GameConstants;
import lld.tictactoe.exception.InvalidInputException;
import lld.tictactoe.exception.InvalidOperationException;
import lld.tictactoe.exception.InvalidPlacementException;
import lld.tictactoe.model.Board;
import lld.tictactoe.model.Cell;
import lld.tictactoe.model.Position;

public class CellServiceImpl implements CellService {

    private static CellServiceImpl serviceInstance;

    public static CellService getInstance() {
        if (serviceInstance == null) {
            serviceInstance = new CellServiceImpl();
        }
        return serviceInstance;
    }

    @Override
    public Cell getCell(int row, int col) {
        return null;
    }

    @Override
    public void markCell(Cell cell, Entity entity) {
        if (!cell.isEmpty()) {
            throw new InvalidPlacementException("Cell is already occupied");
        }
        cell.mark(entity);
    }

    @Override
    public void clearCell(Cell cell) {
        if (cell == null) {
            throw new InvalidInputException("Cell cannot be null for clearing");
        }
        cell.clear();
    }

    @Override
    public void addCell(Board board, int row, int col) {
        Cell[][] cells = board.getCells();
        if (cells == null) {
            throw new InvalidInputException("Cells are null in board");
        }
        if (cells[row][col] != null) {
            throw new InvalidOperationException(String.format("Cell is already added to row %d col %d", row, col));
        }
        if (row < 0 || row > GameConstants.BOARD_SIZE || col < 0 || col > GameConstants.BOARD_SIZE) {
            throw new InvalidInputException(String.format("Invalid row=%d and/or column=%d value for adding cell.", row, col));
        }
        cells[row][col] = new Cell(new Position(row, col));
    }

}
