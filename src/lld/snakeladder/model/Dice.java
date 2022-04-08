package lld.snakeladder.model;

import java.util.Random;

public class Dice {

    private Random random;

    public Dice() {
        this.random = new Random();
    }

    public int roll() {
        int num;
        do {
            num = random.nextInt(7);
        } while (num == 0);

        return num;
    }
}
