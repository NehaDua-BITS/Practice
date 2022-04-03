package dsa.adobe;

import java.util.Arrays;
import java.util.Random;

public class ShuffleDeck {

    public static void main(String[] args) {
        int[] deck = new int[52];
        for (int i = 0; i < 52; i++) {
            deck[i] = i+1;
        }

        ShuffleDeck obj = new ShuffleDeck();
        obj.shuffleDeck(deck);
        System.out.println("Shuffled Deck = " + Arrays.toString(deck));
        obj.shuffleDeck2(deck);
        System.out.println("Shuffled Deck 2 = " + Arrays.toString(deck));
    }

    private void shuffleDeck(int[] deck) {
        int length = deck.length;
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int newPosition = i + random.nextInt(length-i);
            int temp = deck[newPosition];
            deck[newPosition] = deck[i];
            deck[i] = temp;
        }
    }

    private void shuffleDeck2(int[] deck) {
        int length = deck.length;
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int newPosition = random.nextInt(length);
            int temp = deck[newPosition];
            deck[newPosition] = deck[i];
            deck[i] = temp;
        }
    }

}
