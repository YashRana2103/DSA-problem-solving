//https://www.youtube.com/watch?v=oTTzNMHM05I

package others;

import java.util.*;

//Fractional Knapsack Problem
public class Knapsack_maxProfit_by_weight {

    static class Item {
        int profit, weight;
        double ratio;
        int index;

        Item(int profit, int weight, int index) {
            this.profit = profit;
            this.weight = weight;
            this.index = index;
            this.ratio = (double) profit / weight;
        }
    }

    public static void main(String[] args) {
        int[] profits = {10, 5, 15, 7, 6, 18, 3};
        int[] weights = {2, 3, 5, 7, 1, 4, 1};
        int n = profits.length;
        int maxWeight = 15;

        double[] taken = new double[n]; // Stores how much of each item is taken (0 <= x <= 1)
        double totalProfit = 0;

        List<Item> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            items.add(new Item(profits[i], weights[i], i));
        }

        // Sort by profit/weight ratio in descending order
        items.sort((a, b) -> Double.compare(b.ratio, a.ratio));

        int remainingCapacity = maxWeight;

        for (Item item : items) {
            if (remainingCapacity == 0) break;

            if (item.weight <= remainingCapacity) {
                // Take whole item
                taken[item.index] = 1;
                totalProfit += item.profit;
                remainingCapacity -= item.weight;
            } else {
                // Take fractional part
                double fraction = (double) remainingCapacity / item.weight;
                taken[item.index] = fraction;
                totalProfit += item.profit * fraction;
                remainingCapacity = 0;
            }
        }

        // Print results
        System.out.println("Taken Array (fractions): " + Arrays.toString(taken));
        System.out.println("Total Profit: " + totalProfit);
    }
}
