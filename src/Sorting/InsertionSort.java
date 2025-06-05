package Sorting;

import mypackage.PrintArr;

public class InsertionSort {
    static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 11, 24, 13 };
        // int[] arr = { 12, 11, 13, 5, 6 };
        insertionSort(arr);
        PrintArr.printArr(arr);
    }
}
