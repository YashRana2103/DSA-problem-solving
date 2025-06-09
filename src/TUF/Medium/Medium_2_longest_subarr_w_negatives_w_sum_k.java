package TUF.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Medium_2_longest_subarr_w_negatives_w_sum_k {
    public static int myApproach(int[] nums, int k) {
        int n = nums.length;
        int lenOfSubArr = 0;
        for (int i = 0; i < n; i++) {
            long prefixSum = 0;
            for (int j = i; j < n; j++) {
                prefixSum += nums[j];
                if (prefixSum == k)
                    lenOfSubArr = Math.max(lenOfSubArr, j - i + 1);
            }
        }
        return lenOfSubArr;
    }

    public static int optimal(int[] nums, int k){
        int n = nums.length;
        int sum = 0;
        int maxLen = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if(sum == k) maxLen = Math.max(maxLen, i + 1);

            int laterPrefix = sum - k;

            if(map.containsKey(laterPrefix)){
                int len = i - map.get(laterPrefix);
                maxLen = Math.max(maxLen, len);
            }

            if(!map.containsKey(sum)) map.put(sum, i);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int k = 10;
        Random rand = new Random();

        int[][] testCases = {
                {1, 2, 3, 4},                      // No negatives, basic
                {5, -1, 2, 3, 1},                  // Mix, sum=10
                {-2, -1, 2, 3, 6, 2},              // Mix, tricky prefix
                {10, -10, 10, -10, 10},            // Alternating pattern
                {1, 6, 8, -1, 7, 4, -12, 5, 5},    // Given in your code
                {-5, 5, 15, -10},                  // Mid-section match // optimal
                {-1, -1, -1, 10},                  // End match // optimal
                {-3, 1, 2, 5, 5},                  // Over-sum
                {2, -2, 2, -2, 2, 2, 6},           // Many small subarrays
                {10},                              // Single element match
                {3, 3, 3, 1},                      // No subarray match
        };

        int i = rand.nextInt(testCases.length); // Random test case index
        int[] nums = testCases[i];

        System.out.println("=== Random Test Case " + (i + 1) + " ===");
        System.out.println("Target Sum (K): " + k);
        System.out.println("Input Array: " + Arrays.toString(nums));

        int my = myApproach(nums, k);
        int optimal = optimal(nums, k);

        System.out.println("myApproach:  " + my);
        System.out.println("better:      " + optimal);
    }
}
