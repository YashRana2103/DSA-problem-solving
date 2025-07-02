//https://takeuforward.org/data-structure/move-all-zeros-to-the-end-of-the-array/

package TUF.Easy;

import static utils.ArrayUtils.print;
import static utils.Swap.swap;

public class Move_zero_to_end {
    public static void brute_force(int[] arr, int n) {
        int[] temp = new int[n];
        int i = 0, j = 0;
        while (i < n) {
            if (arr[i] != 0) {
                temp[j] = arr[i];
                j++;
            }
            i++;
        }
        for (int k = 0; k < n; k++) {
            arr[k] = temp[k];
        }

        // TC: O(n)
        // SC: O(n)
    }

    public static void optimal(int[] arr, int n) {
        // my approach
        for (int i = 0; i < n; i++) {
            if(arr[i] == 0){
                int j = i + 1;
                while(j < n && arr[j] == 0) j++;
                if(j < n) swap(arr, i, j);
            }
        }

        // TUF
//        int j = -1;
//        for (int i = 0; i < n; i++) {
//            if(arr[i] == 0){
//                j = i; break;
//            }
//        }
//
//        if(j == -1) return;
//
//        for (int i = j + 1; i < n; i++) {
//            if(arr[i] != 0){
//                swap(arr, j, i);
//                j++;
//            }
//        }

        // TC: O(n)
        // SC: O(1)
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1, 0, 2, 3, 0, 4, 0, 1};
//        int[] arr = new int[]{1, 2, 0, 1, 0, 4, 0};
//        int[] arr = new int[]{1, 0, 2, 3, 2, 0, 0, 4, 5, 1};
        int[] arr = new int[]{1, 2, 3, 2, 4, 5, 1};

//        brute_force(arr, arr.length);
        optimal(arr, arr.length);
        print(arr);
    }
}
