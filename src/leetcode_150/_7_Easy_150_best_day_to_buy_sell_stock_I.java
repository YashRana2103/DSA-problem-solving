//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/?envType=study-plan-v2&envId=top-interview-150

package leetcode_150;

public class _7_Easy_150_best_day_to_buy_sell_stock_I {
    public static int myApproach2(int[] prices) {
//        int n = prices.length;
//        int p = prices[0];
//        int profit = 0;
//
//        for (int i = 1; i < n; i++) {
//            if (p > prices[i]) p = prices[i];
//            profit = Math.max(profit, prices[i] - p);
//        }
//
//        System.gc();
//        return profit;

        int maxPro = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxPro = Math.max(maxPro, prices[i] - minPrice);
        }
        System.gc();
        return maxPro;
    }

    public static void main(String[] args) {
//        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
//        int[] prices = new int[]{7, 6, 4, 3, 1};
        int[] prices = new int[]{2, 4, 1};

        System.out.println(myApproach2(prices));
    }
}
