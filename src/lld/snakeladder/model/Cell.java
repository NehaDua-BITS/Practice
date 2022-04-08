package lld.snakeladder.model;

public class Cell {

    private int position;

    private CellEntity entity;

    public Cell(int number) {
        this.position = number;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public CellEntity getEntity() {
        return entity;
    }

    public void setEntity(CellEntity entity) {
        this.entity = entity;
    }
}
