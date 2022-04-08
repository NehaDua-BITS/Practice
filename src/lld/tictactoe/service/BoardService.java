package lld.tictactoe.service;

import lld.tictactoe.model.Board;
import lld.tictactoe.model.Cell;

public interface BoardService {

    Board createBoard();

    Cell getNextFreeCell();
}
