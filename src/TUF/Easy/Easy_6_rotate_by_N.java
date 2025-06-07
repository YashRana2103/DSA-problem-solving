package TUF.Easy;

import java.util.Random;

import static utils.ArrayUtils.print;


public class Easy_6_rotate_by_N {
    public static void brute_force(int[] arr, int n, int k, Boolean isLeft) {
        if (n == 0)
            return;
        k = k % n;
        if (k > n)
            return;
        int[] temp = new int[k];
        if (isLeft) {
            for (int i = 0; i < k; i++) {
                temp[i] = arr[i];
            }
            for (int i = 0; i < n - k; i++) {
                arr[i] = arr[i + k];
            }
            for (int i = n - k; i < n; i++) {
                arr[i] = temp[i - n + k];
            }
        } else {
            for (int i = n - k; i < n; i++) {
                temp[i - n + k] = arr[i];
            }
            for (int i = n - k - 1; i >= 0; i--) {
                arr[i + k] = arr[i];
            }
            for (int i = 0; i < k; i++) {
                arr[i] = temp[i];
            }
        }
    }

    // Using reversal technique
    public static void optimal(int[] arr, int n, int k, Boolean isLeft) {
        if (n == 0) return;

        k = k % n;
        if (k > n) return;

        if (isLeft) {
            // ✅ Corrected left rotation
            Reverse(arr, 0, k - 1);        // Reverse first k elements
            Reverse(arr, k, n - 1);             // Reverse remaining elements
            Reverse(arr, 0, n - 1);        // Reverse whole array
        } else {
            // ✅ Right rotation (was already correct)
            Reverse(arr, 0, n - k - 1);    // Reverse first n-k elements
            Reverse(arr, n - k, n - 1);    // Reverse last k elements
            Reverse(arr, 0, n - 1);        // Reverse whole array
        }
    }

    public static void Reverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[][] testCases = {
                {1, 2, 3, 4, 5},
                {10, 20, 30},
                {7},
                {},
                {0, 0, 0, 0},
                {99, 98, 97, 96, 95},
                {-1, -2, -3, -4},
                {1, 2, 3, 4, 5, 6},
        };

        Random random = new Random();
        int index = random.nextInt(testCases.length);
        int[] arr = testCases[index];

        System.out.print("Original Array: ");
        print(arr);

        int k = 2;
//        brute_force(arr, arr.length, k, true);
//        brute_force(arr, arr.length, k, false);
        optimal(arr, arr.length, k, true);
//        optimal(arr, arr.length, k, false);

        System.out.print("After Rotation by " + k + ": ");
        print(arr);
    }
}
