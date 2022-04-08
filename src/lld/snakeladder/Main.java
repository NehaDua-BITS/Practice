package lld.snakeladder;

import lld.snakeladder.constants.PlayerColor;
import lld.snakeladder.model.Board;
import lld.snakeladder.model.Game;
import lld.snakeladder.model.Player;
import lld.snakeladder.service.InitBoardService;
import lld.snakeladder.service.PlayService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static lld.snakeladder.service.ValidationService.validateBoard;
import static lld.snakeladder.service.ValidationService.validatePlayers;

public class Main {

    private InitBoardService boardService = new InitBoardService();

    public static void main(String[] args) {
        Main main = new Main();

        //take input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter num of players : ");
        int numOfPlayers = scanner.nextInt();
        System.out.println("Enter board size : ");
        int boardSize = scanner.nextInt();
        System.out.println("Enter num of Snakes : ");
        int numOfSnakes = scanner.nextInt();
        System.out.println("Enter num of Ladders : ");
        int numOfLadders = scanner.nextInt();

        //create game
        Board board = main.createGameBoard(boardSize, numOfSnakes, numOfLadders);
        List<Player> players = main.createPlayers(numOfPlayers);
        Game game = new Game(board, players);

        //start playing game
        PlayService playService = new PlayService(game);
        playService.playGame();
    }

    private Board createGameBoard(int boardSize, int numOfSnakes, int numOfLadders) {
        validateBoard(boardSize, numOfSnakes, numOfLadders);
        Board board = new Board(boardSize, numOfSnakes, numOfLadders);
        boardService.initBoard(board);
        return board;
    }

    private List<Player> createPlayers(int numOfPlayers) {
        validatePlayers(numOfPlayers);
        List<Player> players = new ArrayList<>(numOfPlayers);
        PlayerColor[] colors = PlayerColor.values();
        for (int i = 0; i < numOfPlayers; i++) {
            players.add(new Player(colors[i]));
        }
        return players;
    }
}
