package sorting;

import utils.ArrayUtils;
import utils.Swap;

public class BubbleSort {
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            Boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    Swap.swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 11, 24, 13 };
        bubbleSort(arr);
        ArrayUtils.print(arr);
    }
}
