package lld.tictactoe.main;

import lld.tictactoe.constants.GameConstants;
import lld.tictactoe.exception.TicTacToeException;
import lld.tictactoe.model.Board;
import lld.tictactoe.model.Cell;
import lld.tictactoe.model.Game;
import lld.tictactoe.model.Player;
import lld.tictactoe.service.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Driver {

    private CellService cellService = new CellServiceImpl();

    private GameService gameService;

    public static void main(String[] args) {
        Player player1 = new Player("Player1", true);
        Player player2 = new Player("Player2", false);
        List<Player> players = new ArrayList<>(Arrays.asList(player1, player2));
        Game game = new Game(BoardServiceImpl.getInstance().createBoard(), players);
        game.startGame();

        new Driver().playGame(game);
    }

    private void playGame(Game game) {
        Board board = game.getBoard();
        List<Player> players = game.getPlayers();

        gameService = new GameServiceImpl(game);
        Scanner scanner = new Scanner(System.in);
        int numOfMoves = 0;
        int turn = 0;
        int maxMoves = GameConstants.BOARD_SIZE * GameConstants.BOARD_SIZE;
        while (numOfMoves < maxMoves) {
            System.out.println("Enter row and col number (0-2) & -1 to End Game : ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if (row == -1 || col == -1) {
                System.out.println("Exiting game !!");
                gameService.endGame();
                break;
            }

            if (!areRowColValid(row, col)) {
                System.out.println("Error: Enter valid values");
                continue;
            }

            try {
                Cell cell = board.getCells()[row][col];
                gameService.play(players.get(turn), cell);
                if (gameService.isWinningMove(players.get(turn), cell)) {
                    System.out.println(String.format("Player %d won !!", turn+1));
                    System.out.println(board);
                    break;
                }
                numOfMoves++;
                turn = (turn+1) % GameConstants.MAX_PLAYERS;
            } catch(TicTacToeException ex) {
                System.out.println("Move Failed : " + ex.getMessage());
            }
            System.out.println("Current Board : \n" + board);
        }
    }
    private static boolean areRowColValid(int row, int col) {
        return row >= 0 && col >=0
                && row < GameConstants.BOARD_SIZE
                && col < GameConstants.BOARD_SIZE;
    }

}
