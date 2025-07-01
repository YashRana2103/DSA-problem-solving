package TUF.Medium;

import static utils.ArrayUtils.printWithColor;
import static utils.Swap.swap;

public class Sort_zeros_ones_twos {
    private static void optimal(int[] nums) {
        int n = nums.length;
        ;
        int low = 0;
        int high = n - 1;
        int mid = 0;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, mid, low);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 1, 2, 0, 1, 2};
//        int[] arr = {2, 0, 2, 1, 1, 0};
        optimal(arr);
        printWithColor(arr);
    }
}
