package arrays.practice_problems;

import java.util.Scanner;

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {

        int lowestPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < lowestPrice) {
                lowestPrice = prices[i];
            }

            int profit = prices[i] - lowestPrice;

            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println("Maximum Profit: " + maxProfit(prices));
    }
}