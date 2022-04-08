package lld.snakeladder.service;

import lld.snakeladder.model.CellEntity;
import lld.snakeladder.model.Game;
import lld.snakeladder.model.Player;

import java.util.List;
import java.util.Scanner;

public class PlayService {

    private Game game;

    public PlayService(Game game) {
        this.game = game;
    }

    public void playGame() {
        List<Player> players = game.getPlayers();
        int currentTurn = 0;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nPress 1 to roll dice");
            System.out.println("Press any other key to exit");
            String val = scanner.nextLine();
            if (!val.equals("1")) break;

            //roll dice
            int steps = game.getDice().roll();
            System.out.println("Dice Value : " + steps);
            int newPosition = movePlayer(steps, players.get(currentTurn));
            System.out.println(String.format("Player %s moved to %d position",
                    players.get(currentTurn).getColor(), newPosition));

            if (newPosition == game.getBoard().getCells().length) {
                System.out.println("Player Won : " + players.get(currentTurn));
                break;
            }

            currentTurn = (currentTurn + 1) % players.size();
        }
    }

    public int movePlayer(int steps, Player player) {
        int newPosition = player.getCurrentPos();
        if (player.getCurrentPos() + steps <= this.game.getBoard().getCells().length) {
            newPosition += steps;
            CellEntity cellEntity = game.getBoard().getSnakeOrLadder(newPosition);
            if (cellEntity != null) {
                newPosition = cellEntity.getEndPosition();
                System.out.println(cellEntity.getType() + " encountered. Moving to position = " + newPosition);
            }
            player.move(newPosition);
        }

        return newPosition;
    }


}
