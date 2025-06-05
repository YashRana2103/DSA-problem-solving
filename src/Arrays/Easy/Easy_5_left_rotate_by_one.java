package Arrays.Easy;

import java.util.Random;

import static mypackage.PrintArr.printArr;

public class Easy_5_left_rotate_by_one {
    public static void brute_force(int[] arr, int n){
        if(n < 2) return;
        int[] temp = new int[arr.length];
        int first = arr[0];
        int i = 1;

        for (i = 1; i < n; i++) {
            temp[i - 1] = arr[i];
        }

        temp[n - 1] = first;
        for (int j = 0; j < n; j++) {
            arr[j] = temp[j];
        }

//        -------------------
//        TC: O(n)
//        SC: O(n)
    }

    public static void optimal(int[] arr, int n){
        if(n < 2) return;
        int first = arr[0];
        int i;
        for (i = 0; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[n - 1] = first;

//        -------------------
//        TC: O(n)
//        SC: O(1)
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
        printArr(arr);

        brute_force(arr, arr.length);
//        better(arr, arr.length);

        System.out.print("After Left Rotation by One: ");
        printArr(arr);
    }
}
