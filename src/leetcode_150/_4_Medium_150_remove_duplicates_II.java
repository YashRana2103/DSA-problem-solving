//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150

package leetcode_150;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static utils.ArrayUtils.print;

public class _4_Medium_150_remove_duplicates_II {
    public static int brute_force(int[] arr, int n) {
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < n; i++) {
//            max = Integer.max(arr[i], max);
//        }
//        int[] hashMap = new int[max + 1];
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        }

        // Step 2: Reconstruct array with at most 2 occurrences
        int index = 0;

        // Sorted traversal since original array is sorted
        List<Integer> sortedKeys = new ArrayList<>(hashMap.keySet());
        Collections.sort(sortedKeys);

        for (int key : sortedKeys) {
            int count = Math.min(hashMap.get(key), 2); // only up to 2
            for (int i = 0; i < count; i++) {
                arr[index++] = key;
            }
        }

        return index;

        // TC: O(N)
        // SC: O(1)
    }

    public static int better(int[] arr, int n) {
        if (n <= 2) return n;
        int k = 2;
        for (int i = 2; i < n; i++) {
            if(arr[i] != arr[k - 2]){
                arr[k] = arr[i];
                k++;
            }
        }
        return k;

        // TC: O(N)
        // SC: O(1)
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 2, 2, 3};
//        int[] arr = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};

        System.out.print("Original Array: ");
        print(arr);

        int k = brute_force(arr, arr.length);
//        int k = better(arr, arr.length);
        System.out.println(k);
        print(arr, k);
    }
}
