//https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-interview-150

package leetcode_150;

import java.util.Arrays;

import static utils.ArrayUtils.printWithColor;

public class _13_Medium_150_product_of_array_except_self {

    public static int[] bruteForce(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = 1; // Initialize the result array with 1
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    result[i] *= nums[j]; // Multiply all elements except the current one
                }
            }
        }
        return result;
    }

    // takes too much time for large arrays
    public static int[] better(int[] nums){
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++)
            result[i] = 1; // Initialize result array with 1

        // O(n^2) time complexity
        for (int i = 0; i < n; i++) {

            // O(i - 1) for left side product
            for (int j = 0; j < i; j++) {
                result[i] *= nums[j];
            }

            // O(n - i - 1) for right side product
            for (int j = n - 1; j > i; j--) {
                result[i] *= nums[j];
            }
        }

        return result;
    }

    public static int[] partialOptimal(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
//        Arrays.fill(ans, 1);

        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = 1;
        suffix[n - 1] = 1;

        for (int i = 1; i < n; i++) prefix[i] = prefix[i - 1] * nums[i - 1];
        for (int i = n - 2; i >= 0; i--) suffix[i] = suffix[i + 1] * nums[i + 1];
        for (int i = 0; i < n; i++) ans[i] = prefix[i] * suffix[i];

        return ans;
    }

    public static int[] optimal(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        int curr = 1;
        for (int i = 0; i < n; i++) {
            ans[i] = curr;
            curr *= nums[i];
        }
        curr = 1;
        for (int i = n - 1; i >= 0 ; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        return ans;
    }

    public static int[] githubCopilot(int[] nums) {
        // same as optimal, but with different variable names
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);

        // Calculate prefix products
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Calculate suffix products and multiply with prefix products
        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        // Expected output: [24, 12, 8, 6]
        int[] nums2 = {1, 2, 3, 4, 5};
        // Expected output: [120, 60, 40, 30, 24]
        int[] nums3 = {0, 1, 2, 3, 4};
        // Expected output: [24, 0, 0, 0, 0]
        int[] nums4 = {-1, 1, 0, -3, 3};
        // Expected output: [0, 0, 9, 0, 0]
        int[] nums5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // Expected output: [3628800, 1814400, 1209600, 907200, 725760, 604800, 518400, 453600, 403200, 362880]
        int[] nums6 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        // Expected output: [39916800, 19958400, 13305600, 9988800, 7983360, 6652800, 5715360, 4989600, 4435200, 3991680, 3628800]

//        printWithColor(optimal(nums1));
//        printWithColor(optimal(nums2));
//        printWithColor(optimal(nums3));
//        printWithColor(optimal(nums4));
//        printWithColor(optimal(nums5));
//        printWithColor(optimal(nums6));

        printWithColor(partialOptimal(nums1));
        printWithColor(partialOptimal(nums2));
        printWithColor(partialOptimal(nums3));
        printWithColor(partialOptimal(nums4));
        printWithColor(partialOptimal(nums5));
        printWithColor(partialOptimal(nums6));

        // throws ArrayIndexOutOfBoundsException for large arrays
        // printWithColor(better(nums4));
    }
}
