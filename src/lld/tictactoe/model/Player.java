package lld.tictactoe.model;

public class Player {

    private String name;

    private boolean isCircle;

    private int numOfMoves;

    public Player(String name, boolean isCircle) {
        this.name = name;
        this.isCircle = isCircle;
    }

    public String getName() {
        return name;
    }

    public boolean isCircle() {
        return isCircle;
    }

    public void incrementMoves() {
        this.numOfMoves++;
    }
}
