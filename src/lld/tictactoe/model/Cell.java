package lld.tictactoe.model;

import lld.tictactoe.constants.Entity;
import lld.tictactoe.exception.InvalidPlacementException;

public class Cell {

    private Position position;

    private Entity entity;

    public Cell(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isEmpty() {
        return entity == null;
    }

    public boolean isCircle() {
        return entity != null && entity == Entity.CIRCLE;
    }

    public void mark(Entity entity) {
        this.entity = entity;
    }

    public void clear() {
        this.entity = null;
    }

    public Entity getEntity() {
        return entity;
    }
}
