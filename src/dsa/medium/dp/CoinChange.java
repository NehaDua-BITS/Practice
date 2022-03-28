package dsa.medium.dp;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        int amount = 6249;
        Arrays.sort(coins);

        int count = new CoinChange().coinChange(coins, amount);
        System.out.println("Number of coins = " + count);
    }

    public int coinChange(int[] coins, int amount) {

        int length = coins.length;
        int[] table = new int[amount+1]; //stores min coins for each value 0....V
        Arrays.fill(table, Integer.MAX_VALUE);
        table[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < length; j++) {
                if (coins[j] <= i) {
                    int res = table[i-coins[j]];
                    if (res != Integer.MAX_VALUE && (res+1) < table[i]) {
                        table[i] = res+1;
                    }
                }
            }
        }

        return table[amount] == Integer.MAX_VALUE ? -1 : table[amount];
    }

}
