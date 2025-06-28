package sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class Sorting {
    public static void merge(ArrayList<Integer> arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(arr);
        int k = low;
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr.get(left) <= arr.get(right)) {
                temp.set(k, arr.get(left));
                left++;
                k++;
            } else {
                temp.set(k, arr.get(right));
                right++;
                k++;
            }
        }

        while (left <= mid) {
            temp.set(k, arr.get(left));
            left++;
            k++;
        }

        while (right <= high) {
            temp.set(k, arr.get(right));
            right++;
            k++;
        }

        for (int i = low; i <= high; i++) {
            arr.set(i, temp.get(i));
        }
    }

    public static void mergeSort(ArrayList<Integer> arr, int low, int high) {
        if (low >= high) return;
        int mid = low + (high - low) / 2;
//            int mid = (low + high) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5, 7, 12, 6, 1, 2));
        mergeSort(arr, 0, arr.size() - 1);
        System.out.println(arr);
    }
}
