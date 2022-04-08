package lld.tictactoe.service;

import lld.snakeladder.exception.InvalidInputException;
import lld.tictactoe.constants.Entity;
import lld.tictactoe.constants.GameConstants;
import lld.tictactoe.constants.GameStatus;
import lld.tictactoe.exception.InvalidOperationException;
import lld.tictactoe.model.Cell;
import lld.tictactoe.model.Game;
import lld.tictactoe.model.Player;

public class GameServiceImpl implements GameService {

    private Game game;

    private CellService cellService;

    public GameServiceImpl(Game game) {
        if (game == null) {
            throw new InvalidInputException("Game cannot be null");
        }
        this.game = game;
        this.cellService = new CellServiceImpl();
    }

    @Override
    public void startGame() {
        game.startGame();
    }

    @Override
    public void restartGame() {
        if (game.getGameStatus() != GameStatus.IN_PROGRESS || game.getGameStatus() != GameStatus.COMPLETED) {
            throw new InvalidOperationException(String.format("Game in %s state cannot be restarted", game.getGameStatus()));
        }
        game.restartGame();
    }

    @Override
    public void endGame() {
        game.endGame();
    }

    public void play(Player player, Cell cell) {
        this.cellService.markCell(cell, player.isCircle() ? Entity.CIRCLE : Entity.CROSS);
        player.incrementMoves();
    }

    @Override
    public boolean isWinningMove(Player player, Cell cell) {
        int row = cell.getPosition().getRow();
        int col = cell.getPosition().getCol();
        Entity entity = player.isCircle() ? Entity.CIRCLE : Entity.CROSS;
        Cell[][] cells = game.getBoard().getCells();

        //check row
        boolean won = true;
        for (int j = 0; j < GameConstants.BOARD_SIZE; j++) {
            if(cells[row][j].getEntity() != entity) {
                won = false;
                break;
            }
        }

        //check col
        if (!won) {
            won = true;
            for (int i = 0; i < GameConstants.BOARD_SIZE; i++) {
                if (cells[i][col].getEntity() != entity) {
                    won = false;
                    break;
                }
            }
        }

        //if diagonal
        if (!won && row == col) {
            won = true;
            for (int i = 0; i < GameConstants.BOARD_SIZE; i++) {
                if (cells[i][i].getEntity() != entity) {
                    won = false;
                    break;
                }
            }
        }

        if (!won && row == GameConstants.BOARD_SIZE-col-1) {
            won = true;
            for (int i = GameConstants.BOARD_SIZE-1; i>=0; i--) {
                if (cells[GameConstants.BOARD_SIZE-i-1][i].getEntity() != entity) {
                    return false;
                }
            }
        }


        return won;
    }

}
