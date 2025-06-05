//https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150

package leetcode_150;

import static mypackage.PrintArr.printArr;

public class Easy_150_3_remove_duplicates_I {
    public static int brute_force(int[] arr, int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Integer.max(arr[i], max);
        }
        int[] hashMap = new int[max + 1];

        for (int i = 0; i < n; i++) {
            hashMap[arr[i]]++;
        }
        int j = 0;
        for (int i = 0; i < max + 1 && j < n; i++) {
            if (hashMap[i] != 0) {
                arr[j] = i;
                j++;
            }
        }
        return j;
    }

    public static int better(int[] arr, int n){
        int j = 0, i = j + 1;
        while(j < n && i < n){
            while(i < n && arr[i] <= arr[j]) ++i;
            if(i < n) arr[++j] = arr[i];
        }
        return j + 1;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1, 1, 2};
//        int[] arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] arr = new int[]{1, 2, 2, 2, 3, 3, 4, 4, 4, 5};

//        int k = brute_force(arr, arr.length);
        int k = better(arr, arr.length);
//        int k = optimal(arr, arr.length);
        System.out.println(k);
        printArr(arr);
        printArr(arr, k);
    }
}
