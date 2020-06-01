package org.bentonc.codingquestions.geeksforgeeks;

import java.util.List;

/**
 * Stock Buy Sell to Maximize Profit
 *
 * Buy / sell once: https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
 *
 * The cost of a stock on each day is given in an array, find the max profit that you can make by buying and selling
 * once each during that period. For example, if the given array is [20, 1, 2, 90, 10, 110, 50] the maximum profit you
 * could make buying once and selling once would be 109.
 *
 * Buy / sell multiple times: https://www.geeksforgeeks.org/stock-buy-sell/
 *
 * The cost of a stock on each day is given in an array, find the max profit that you can make by buying and selling
 * during that period. For example, if the given array is [100, 180, 260, 310, 40, 535, 695], the maximum profit can
 * earned by buying on day 0, selling on day 3. Again buy on day 4 and sell on day 6. If the given array of prices is
 * sorted in decreasing order, then profit cannot be earned at all.
 */
public class BuySellStock {

    // O(n^2)
    public int buySellOnceBruteForce(final List<Integer> prices) {
        if (prices.size() <= 1) {
            return 0;
        }

        int maxDiff = 0;

        for (int i = 0; i < prices.size(); ++i) {
            for (int j = i + 1; j < prices.size(); ++j) {
                if (prices.get(j) - prices.get(i) > maxDiff) {
                    maxDiff = prices.get(j) - prices.get(i);
                }
            }
        }

        return maxDiff;
    }

    // O(n)
    public int buySellOnceOptimal(final List<Integer> prices) {
        int maxDiff = 0;
        int minValue = prices.get(0);

        for (int i = 1; i < prices.size(); ++i) {
            if ((prices.get(i) - minValue) > maxDiff) {
                maxDiff = prices.get(i) - minValue;
            }

            if (prices.get(i) < minValue) {
                minValue = prices.get(i);
            }
        }

        return maxDiff;
    }

    private int buySellMultipleBruteForce(final List<Integer> prices, final int start, final int end) {
        // If the stocks can't be bought.
        if ((prices.size() <= 1) || (end <= start)) {
            return 0;
        }

        // Initialise the profit.
        int maxProfit = 0;

        // The day at which the stock must be bought.
        for (int i = start; i < end; ++i) {
            // The day at which the stock must be sold.
            for (int j = i + 1; j <= end; ++j) {
                // If buying the stock at ith day and selling it at jth day is profitable.
                if (prices.get(j) > prices.get(i)) {
                    // Update the current profit.
                    int profit = prices.get(j) - prices.get(i);
                    int leftProfit = buySellMultipleBruteForce(prices, start, i - 1);
                    int rightProfit = buySellMultipleBruteForce(prices, j + 1, end);

                    // Update the maximum profit so far.
                    maxProfit = Math.max(maxProfit, profit + leftProfit + rightProfit);
                }
            }
        }

        return maxProfit;
    }

    public int buySellMultipleBruteForce(final List<Integer> prices) {
        return buySellMultipleBruteForce(prices, 0, prices.size() - 1);
    }

    public int buySellMultipleOptimal(final List<Integer> prices) {
        int profit = 0;
        int i = 0;

        while (i < prices.size() - 1) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            while (prices.get(i) < min) {
                min = prices.get(i++);
            }

            while ((i < prices.size()) && (prices.get(i) > max)) {
                max = prices.get(i++);
            }

            profit += (max - min);
        }

        return profit;
    }
}
