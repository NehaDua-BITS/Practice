package lld.snakeladder.model;

import lld.snakeladder.constants.CellEntityType;

public class Ladder extends CellEntity {

    public Ladder(int startPosition, int endPosition) {
        super(startPosition, endPosition, CellEntityType.LADDER);
    }

}
