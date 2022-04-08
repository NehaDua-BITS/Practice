package lld.snakeladder.model;

import lld.snakeladder.constants.PlayerColor;

public class Player {

    private int currentPos;

    private PlayerColor color;

    public Player(PlayerColor color) {
        this.color = color;
        this.currentPos = 0;
    }

    public int getCurrentPos() {
        return this.currentPos;
    }

    public void move(int position) {
        this.currentPos += position;
    }

    public PlayerColor getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Player{" +
                "currentPos=" + currentPos +
                ", color=" + color +
                '}';
    }
}
