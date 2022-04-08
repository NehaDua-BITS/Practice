package lld.tictactoe.service;

import lld.tictactoe.constants.Entity;
import lld.tictactoe.model.Board;
import lld.tictactoe.model.Cell;

public interface CellService {

    Cell getCell(int row, int col);

    void markCell(Cell cell, Entity entity);

    void clearCell(Cell cell);

    void addCell(Board board, int row, int col);
}
