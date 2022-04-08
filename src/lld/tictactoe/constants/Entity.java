package lld.tictactoe.constants;

public enum Entity {
    CIRCLE,
    CROSS;

    @Override
    public String toString() {
        return this.name() == Entity.CIRCLE.name() ? "O" : "X";
    }
}
