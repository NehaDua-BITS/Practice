package lld.snakeladder.service;

import lld.snakeladder.constants.PlayerColor;
import lld.snakeladder.exception.InvalidInputException;

public class ValidationService {

    public static void validateBoard(int boardsize, int numOfSnakes, int numOfLadders) {
        if (boardsize <= 0) {
            throw new InvalidInputException("Board size should be more than 0");
        }

        if (numOfSnakes <= 0 || numOfLadders <= 0) {
            throw new InvalidInputException("Number of snakes and ladders should be more than 0");
        }

        if ((numOfSnakes + numOfLadders) > (boardsize*boardsize)/2) {
            throw new InvalidInputException("Number of snakes and ladders cannot be more than 50% of board size");
        }
    }

    public static void validatePlayers(int numOfPlayers) {
        int maxPlayers = PlayerColor.values().length;
        if (numOfPlayers > maxPlayers) {
            throw new InvalidInputException("Number of players cannot be more than " + maxPlayers);
        }
    }
}
