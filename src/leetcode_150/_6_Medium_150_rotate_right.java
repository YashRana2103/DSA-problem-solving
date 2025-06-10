//https://leetcode.com/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150

package leetcode_150;

import java.util.Arrays;

public class _6_Medium_150_rotate_right {
    public static void optimal(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k % n == 0) return;
        k %= n;
        // my way
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);

        // Generally Used approach
        // reverse(nums, 0, n - 1);       // Step 1: Reverse entire array
        // reverse(nums, 0, k - 1);       // Step 2: Reverse first k elements
        // reverse(nums, k, n - 1);       // Step 3: Reverse remaining n-k elements

        // Both are same because
        // Reverse(left) + Reverse(right) + Reverse(all)
        // = Reverse(all) + Reverse(first k) + Reverse(last n-k)
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        optimal(nums1, k1);
        System.out.println("After rotating by " + k1 + ": " + Arrays.toString(nums1));
        // Expected: [5, 6, 7, 1, 2, 3, 4]

        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        optimal(nums2, k2);
        System.out.println("After rotating by " + k2 + ": " + Arrays.toString(nums2));
        // Expected: [3, 99, -1, -100]

        int[] nums3 = {1};
        int k3 = 0;
        optimal(nums3, k3);
        System.out.println("After rotating by " + k3 + ": " + Arrays.toString(nums3));
        // Expected: [1]

        int[] nums4 = {1, 2};
        int k4 = 3;
        optimal(nums4, k4);
        System.out.println("After rotating by " + k4 + ": " + Arrays.toString(nums4));
        // Expected: [2, 1]

        int[] nums5 = {};
        int k5 = 4;
        optimal(nums5, k5);
        System.out.println("After rotating by " + k5 + ": " + Arrays.toString(nums5));
        // Expected: []

        int[] nums6 = {1, 2, 3, 4, 5, 6};
        int k6 = 6;
        optimal(nums6, k6);
        System.out.println("After rotating by " + k6 + ": " + Arrays.toString(nums6));
        // Expected: [1, 2, 3, 4, 5, 6] (Full rotation)
    }

}
