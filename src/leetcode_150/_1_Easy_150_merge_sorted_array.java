//https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150

package leetcode_150;

import static utils.ArrayUtils.print;

public class _1_Easy_150_merge_sorted_array {
    public static void myApproach(int[] nums1, int m, int[] nums2, int n){
        int[] temp = new int[m + n];
        int k = 0;
        int i = 0;
        int j = 0;

        while(i < m && j < n){
            if(nums1[i] <= nums2[j]){
                temp[k] = nums1[i];
                i++; k++;
            } else {
                temp[k] = nums2[j];
                j++; k++;
            }
        }
        while(i < m){
            temp[k] = nums1[i];
            i++; k++;
        }
        while(j < n){
            temp[k] = nums2[j];
            j++; k++;
        }

        for (int l = 0; l < k; l++) {
            nums1[l] = temp[l];
        }

//        TC: O(m+n)
//        SC: O(n)
    }

    public static void optimal(int[] nums1, int m, int[] nums2, int n){
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        while(p1 >= 0 && p2 >= 0){
            if(nums1[p1] > nums2[p2]){
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        while(p2 >= 0){
            nums1[p] = nums2[p2];
            p2--; p--;
        }
    }

    public static void main(String[] args) {

//        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
//        int[] nums2 = new int[]{2, 5, 6};
//        myApproach(nums1, 3, nums2, 3);
//        optimal(nums1, 3, nums2, 3);

//        int[] nums1 = new int[]{1};
//        int[] nums2 = new int[]{};
//        myApproach(nums1, 1, nums2, 0);
//        optimal(nums1, 1, nums2, 0);

        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        myApproach(nums1, 0, nums2, 1);
        optimal(nums1, 0, nums2, 1);

        print(nums1);
    }
}
