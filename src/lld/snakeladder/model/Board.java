package lld.snakeladder.model;

import lld.snakeladder.exception.InvalidPositionException;

public class Board {

    private int size;

    private Cell[] cells;

    private int numOfSnakes;

    private int numOfLadders;

    public Board(int size, int numOfSnakes, int numOfLadders) {
        this.size = size;
        this.cells = new Cell[size*size];
        this.numOfSnakes = numOfSnakes;
        this.numOfLadders = numOfLadders;
    }

    public int getSize() {
        return size;
    }

    public Cell[] getCells() {
        return cells;
    }

    public int getNumOfSnakes() {
        return numOfSnakes;
    }

    public int getNumOfLadders() {
        return numOfLadders;
    }

    public boolean hasSnakeOrLadder(int position) {
        if (position <= 0 || position > this.size) {
            throw new InvalidPositionException("Invalid Position");
        }
        return cells[position-1].getEntity() != null;
    }

    public CellEntity getSnakeOrLadder(int position) {
        if (position <= 0 || position > cells.length) {
            throw new InvalidPositionException("Invalid Position");
        }
        return cells[position-1].getEntity();
    }
}
