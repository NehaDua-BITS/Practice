package lld.snakeladder.model;

import lld.snakeladder.constants.CellEntityType;

public class Snake extends CellEntity {

    public Snake(int bitePosition, int tailPosition) {
        super(bitePosition, tailPosition, CellEntityType.SNAKE);
    }
}
