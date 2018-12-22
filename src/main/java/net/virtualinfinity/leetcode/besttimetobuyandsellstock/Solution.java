package net.virtualinfinity.leetcode.besttimetobuyandsellstock;

/**
 * solves https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int best = 0;
        int min = Integer.MAX_VALUE;
        for (int price: prices) {
            if (price < min) {
                min = price;
            } else {
                int profit = price - min;
                if (profit > best) {
                    best = profit;
                }
            }
        }
        return best;
    }
}
