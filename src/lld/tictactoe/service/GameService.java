package lld.tictactoe.service;

import lld.tictactoe.model.Cell;
import lld.tictactoe.model.Player;

public interface GameService {

    void startGame();

    void restartGame();

    void endGame();

    void play(Player player, Cell cell);

    boolean isWinningMove(Player player, Cell cell);
}
