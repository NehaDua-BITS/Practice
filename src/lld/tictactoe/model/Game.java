package lld.tictactoe.model;

import lld.tictactoe.constants.GameConstants;
import lld.tictactoe.constants.GameStatus;
import lld.tictactoe.exception.InvalidInputException;
import lld.tictactoe.exception.MaxLimitException;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Board board;

    private List<Player> players;

    private GameStatus gameStatus;

    public Game(Board board) {
        this(board, null);
    }

    public Game(Board board, List<Player> players) {
        this.board = board;
        validatePlayers(players);
        this.players = players;
        this.gameStatus = GameStatus.CREATED;
    }

    private void validatePlayers(List<Player> players) {
        for (Player player : players) {
            validatePlayer(player);
        }
    }

    public Board getBoard() {
        return board;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        //validations
        validatePlayer(player);
        players.add(player);
    }

    public void startGame() {
        this.gameStatus = GameStatus.IN_PROGRESS;
    }

    public void restartGame() {
        this.board.reset();
        this.players = null;
        this.gameStatus = GameStatus.CREATED;
    }

    public void endGame() {
        this.gameStatus = GameStatus.COMPLETED;
    }

    private void validatePlayer(Player player) {
        if (player == null) {
            throw new InvalidInputException("Player cannot be null");
        }
        if (players != null && players.size() == GameConstants.MAX_PLAYERS) {
            throw new MaxLimitException("Number of players cannot be more than " + GameConstants.MAX_PLAYERS);
        }
        if (players == null) {
            players = new ArrayList<>();
        } else if (players.size() == 1 && (players.get(0).isCircle() == player.isCircle())) {
            throw new InvalidInputException("Both players cannot be of same type");
        }
    }
}
