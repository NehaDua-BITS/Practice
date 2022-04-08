package lld.tictactoe.service;

import lld.tictactoe.constants.GameConstants;
import lld.tictactoe.model.Board;
import lld.tictactoe.model.Cell;

public class BoardServiceImpl implements BoardService {

    private CellService cellService = CellServiceImpl.getInstance();

    private static BoardService serviceInstance;

    public static BoardService getInstance() {
        if (serviceInstance == null) {
            serviceInstance = new BoardServiceImpl();
        }
        return serviceInstance;
    }

    @Override
    public Board createBoard() {
        Board board = new Board(new Cell[GameConstants.BOARD_SIZE][GameConstants.BOARD_SIZE]);
        for (int i = 0; i < GameConstants.BOARD_SIZE; i++) {
            for (int j = 0; j < GameConstants.BOARD_SIZE; j++) {
                cellService.addCell(board, i, j);
            }
        }
        return board;
    }

    @Override
    public Cell getNextFreeCell() {
        return null;
    }

}
