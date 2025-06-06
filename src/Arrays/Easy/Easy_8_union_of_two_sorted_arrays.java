package Arrays.Easy;

import java.util.ArrayList;
import java.util.Arrays;

import static utils.ArrayUtils.print;
import static utils.ArrayUtils.printWithColor;

public class Easy_8_union_of_two_sorted_arrays {
    public static int[] optimal(int[] arr1, int n, int[] arr2, int m) {
        int[] arr3 = new int[n + m];
        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                if (k == 0 || arr3[k - 1] != arr1[i]) arr3[k++] = arr1[i];
                i++;
            } else if (arr1[i] > arr2[j]) {
                if (k == 0 || arr3[k - 1] != arr2[j]) arr3[k++] = arr2[j];
                j++;
            } else {
                if (k == 0 || arr3[k - 1] != arr1[i]) arr3[k++] = arr1[i];
                i++;
                j++;
            }
        }
        while (i < n) {
            if (k == 0 || arr3[k - 1] != arr1[i]) arr3[k++] = arr1[i];
            i++;
        }
        while (j < m) {
            if (k == 0 || arr3[k - 1] != arr2[j]) arr3[k++] = arr2[j];
            j++;
        }

        return Arrays.copyOfRange(arr3, 0, k);
    }

    public static ArrayList<Integer> tuf(int[] arr1, int n, int[] arr2, int m) {
        int i = 0, j = 0;

        ArrayList<Integer> unionArr = new ArrayList<>();
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                if (unionArr.isEmpty() || unionArr.getLast() != arr1[i]) unionArr.add(arr1[i]);
                i++;
            } else if (arr1[i] > arr2[j]) {
                if (unionArr.isEmpty() || unionArr.getLast() != arr2[j]) unionArr.add(arr2[j]);
                j++;
            }
        }
        while (i < n) {
            if (unionArr.isEmpty() || unionArr.getLast() != arr1[i]) unionArr.add(arr1[i]);
            i++;
        }
        while (j < m) {
            if (unionArr.isEmpty() || unionArr.getLast() != arr2[j]) unionArr.add(arr2[j]);
            j++;
        }
        return unionArr;
    }

    public static void main(String[] args) {
//        int[] arr1 = new int[]{1, 2, 3, 4, 5};
//        int[] arr2 = new int[]{2, 3, 4, 4, 5};
//        Output: {1, 2, 3, 4, 5}

        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = new int[]{2, 3, 4, 4, 5, 11, 12};
//        Output: {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}

        int[] arr = optimal(arr1, arr1.length, arr2, arr2.length);
        print(arr);
        printWithColor(arr);

//        ArrayList<Integer> unionArr = new ArrayList<>(tuf(arr1, arr1.length, arr2, arr2.length));
//        System.out.println(unionArr);
    }
}
