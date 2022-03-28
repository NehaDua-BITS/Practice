package dsa.easy.dp;

import java.util.Arrays;

public class MaxStockProfit {

    public static void main(String[] args) {
        MaxStockProfit obj = new MaxStockProfit();

        int[] prices = {7,6,4,3,10};
        int profit = obj.maxProfit(prices);
        System.out.println("Max Profit = " + profit);
    }

    private int maxProfit(int[] prices) {
        if (prices == null || prices.length == 1) {
            return 0;
        }

        int length = prices.length;

        int[] maxNextPrice = new int[length];
        maxNextPrice[length-1] = 0;
        for (int i = length-2; i>=0; i--) {
            maxNextPrice[i] = Math.max(prices[i+1], maxNextPrice[i+1]);
        }

        System.out.println("Max Prices : " + Arrays.toString(maxNextPrice));
        int maxProfit = 0;
        for (int i = 0; i < length; i++) {
            maxProfit = Math.max(maxProfit, maxNextPrice[i] - prices[i]);
        }

        return maxProfit;
    }
}
