//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/?envType=study-plan-v2&envId=top-interview-150

package leetcode_150;

public class _8_Medium_150_best_day_to_buy_sell_stock_II {
    public static int myApproach(int[] prices) {
        int profit = 0;
        int i = 0, j = i;
        while(i < prices.length){
            while(j + 1 < prices.length && prices[j] < prices[j + 1]) j++;
            profit += prices[j] - prices[i];
            i = j + 1; j = i;
        }
        return profit;
    }

    public static int chatGPT(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }


    public static void main(String[] args) {
        int[][] testCases = {
                {3, 2, 6, 5, 0, 3},         // Expected: 7
                {1, 7, 5, 3, 6, 4},         // Expected: 9
                {4, 2, 8, 1, 5},            // Expected: 10
                {1, 2, 3, 2, 3, 4, 5},      // Expected: 5
                {5, 4, 3, 2, 1, 2, 3, 4},   // Expected: 3
                {10, 1, 2, 3, 0, 1},        // Expected: 3
                {1, 3, 2, 8, 4, 9},         // Expected: 13
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] prices = testCases[i];
            int result = myApproach(prices);
            System.out.println("Test Case " + (i + 1) + ": " + result);
        }
        System.out.println();
        for (int i = 0; i < testCases.length; i++) {
            int[] prices = testCases[i];
            int result = chatGPT(prices);
            System.out.println("Test Case " + (i + 1) + ": " + result);
        }
    }
}
