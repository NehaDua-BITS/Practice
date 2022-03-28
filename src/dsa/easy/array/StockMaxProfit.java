package dsa.easy.array;

public class StockMaxProfit {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};  //answer = 7
        //int[] prices = {1,2,3,4,5}; //answer = 4
        //int[] prices = {7,6,4,3,1}; //answer = 0
        System.out.println("Max Profit = " + new StockMaxProfit().maxProfit(prices));
    }
    public int maxProfit(int[] prices) {

        int maxProfit = 0;

        if (prices != null) {
            int length = prices.length;
            for (int i = 1; i < length; i++) {
                int diff = prices[i] - prices[i-1];
                if (diff > 0) {
                    maxProfit += diff;
                }
            }
        }

        return maxProfit;
    }
}
