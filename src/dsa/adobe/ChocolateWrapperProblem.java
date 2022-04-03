package dsa.adobe;

public class ChocolateWrapperProblem {

    public static void main(String[] args) {
        int money = 16;
        int price = 2;
        int wrappers = 2;

        ChocolateWrapperProblem obj = new ChocolateWrapperProblem();
        int result = obj.getMaxChocolates(money, price, wrappers);
        System.out.println("Using Naive Approach: Maximum num of Chocolates = " + result);

        result = obj.maxChocolatesUsingFormula(money, price, wrappers);
        System.out.println("Using Fromula: Maximum num of Chocolates = " + result);

    }

    private int getMaxChocolates(int money, int price, int wrappers) {
        //edge case
        if (money < price) {
            return 0;
        }

        int totalChocolates = money/price;
        int currentWrappers = totalChocolates;
        while (currentWrappers >= wrappers) {
            int extraChocolates = currentWrappers/wrappers;
            currentWrappers = (currentWrappers % wrappers) + extraChocolates; //wrappers from previous step and new extraChocolates
            totalChocolates += extraChocolates;
        }

        return totalChocolates;
    }

    private int maxChocolatesUsingFormula(int money, int price, int wrappers) {
            // Corner case
            if (money < price)
                return 0;

            // First find number of chocolates
            // that can be purchased with the
            // given amount
            int choc = money / price;

            // Now just add number of chocolates
            // with the chocolates gained by
            // wrapprices
            choc = choc + ((choc - 1) / (wrappers - 1));
            return choc;
    }

}
