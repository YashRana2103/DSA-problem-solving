//https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150

package Arrays.Easy;


import static mypackage.PrintArr.printArr;
import static mypackage.Swap.swap;

public class Easy_150_2_remove_element {
    public static int brute_force(int[] nums, int val) {
        int n = nums.length;
        int k = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == val) {
                int j = i + 1;
                while (j < n && nums[j] == val) {
                    j++;
                }
                if (j < n) {
                    swap(nums, i, j);
                }
            }
            if (nums[i] != val) {
                k++;
            }
        }
        return k;

        // TC: O(n) or in worst case O(n^2)
        // SC: O(1)
    }

    // traverse the array, pick up the val ele and put it in last and decrement the pointer which points to last index
    public static int better(int[] nums, int val) {
        int n = nums.length;
        int i = 0, j = n - 1;
        while (i <= j) {
            if (nums[i] == val) {
                swap(nums, i, j);
                j--;
            } else {
                i++;
            }
        }
        return i;

        // TC: O(n)
        // SC: O(1)
    }

    public static int optimal(int[] nums, int val){
        int n = nums.length;
        int j = 0;
        for (int i = 0; i < n && j < n; i++) {
            if(nums[i] != val){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;

        // TC: O(n)
        // SC: O(1)
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 2, 3, 4, 5, 3, 1, 0};
//        int[] nums = new int[]{3, 2, 2, 3};
//        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};

//        int k = brute_force(nums, 2);
//        int k = better(nums, 2);
        int k = optimal(nums, 3);
        System.out.println(k);
        printArr(nums);
        printArr(nums, k);
    }
}
