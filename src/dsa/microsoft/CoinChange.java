package dsa.microsoft;

import java.util.Arrays;
import java.util.Stack;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
//        int[] coins = {1};
//        int amount = 0;

        int count = new CoinChange().coinChange(coins, amount);
        System.out.println("Minimum num of coins = " + count);
    }

    public int coinChange(int[] coins, int amount) {

        int length = coins.length;
        int[] table = new int[amount+1]; //to save computation
        Arrays.fill(table, Integer.MAX_VALUE);
        table[0] = 0;

        for (int currentAmount = 1; currentAmount <= amount; currentAmount++) {
            for (int i = 0; i < length; i++) {
                if (coins[i] <= currentAmount) {
                    int res = table[currentAmount - coins[i]];
                    if (res != Integer.MAX_VALUE && (res + 1 < table[currentAmount])) {
                        table[currentAmount] = res+1;
                    }
                }
            }
        }

        return table[amount] == Integer.MAX_VALUE ? -1 : table[amount];
    }
}
