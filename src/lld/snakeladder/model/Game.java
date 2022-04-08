package lld.snakeladder.model;

import java.util.List;

public class Game {

    private Board board;

    private List<Player> players;

    private Dice dice;

    public Game(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
        dice = new Dice();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }
}
