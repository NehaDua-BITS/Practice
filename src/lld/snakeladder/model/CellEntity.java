package lld.snakeladder.model;

import lld.snakeladder.constants.CellEntityType;

public abstract class CellEntity {

    protected int startPosition;

    protected int endPosition;

    protected CellEntityType cellEntityType;

    public CellEntity(int startPosition, int endPosition, CellEntityType type) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.cellEntityType = type;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public CellEntityType getType() {
        return cellEntityType;
    }
}
