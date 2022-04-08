package lld.snakeladder.service;

import lld.snakeladder.model.Board;
import lld.snakeladder.model.Cell;
import lld.snakeladder.model.Ladder;
import lld.snakeladder.model.Snake;

import static lld.snakeladder.service.PositionHelper.getUniquePosition;

public class InitBoardService {

    public void initBoard(Board board) {
        initCells(board.getCells());
        addSnakes(board.getCells(), board.getNumOfSnakes());
        addLadders(board.getCells(), board.getNumOfLadders());
    }

    private void initCells(Cell[] cells) {
        int boardSize = cells.length;
        for (int i = 1; i <= boardSize ; i++) {
            cells[i-1] = new Cell(i);
        }
    }

    private void addSnakes(Cell[] cells, int numOfSnakes) {
        //add snakes
        int positionLimit = cells.length;
        for (int i = 0; i < numOfSnakes; i++) {
            int position1 = getUniquePosition(positionLimit);
            int position2 = getUniquePosition(positionLimit);
            if (position1 > position2) {
                cells[position1].setEntity(new Snake(position1, position2));
            } else {
                cells[position2].setEntity(new Snake(position2, position1));
            }
        }
    }

    private void addLadders(Cell[] cells, int numOfLadders) {
        //add ladders
        int positionLimit = cells.length;
        for (int i = 0; i < numOfLadders; i++) {
            int position1 = getUniquePosition(positionLimit);
            int position2 = getUniquePosition(positionLimit);
            if (position1 < position2) {
                cells[position1].setEntity(new Ladder(position1, position2));
            } else {
                cells[position2].setEntity(new Ladder(position2, position1));
            }
        }
    }
}
