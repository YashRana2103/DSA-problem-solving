package Sorting;

import utils.Swap;
import utils.ArrayUtils;

class SelectionSort {
    static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }

            Swap.swap(arr, i, min);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 11, 24, 13 };
        selectionSort(arr);
        ArrayUtils.print(arr);
    }
}