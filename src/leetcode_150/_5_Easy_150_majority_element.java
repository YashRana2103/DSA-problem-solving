//https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150

package leetcode_150;

public class _5_Easy_150_majority_element {
    // using Boyer-Moore Majority Vote Algorithm
    public static int optimal(int[] nums) {
        int n = nums.length;
        int votes = 0, candidate = -1;
        for (int ele: nums) {
            if (votes == 0) candidate = ele;
            votes += (ele == candidate) ? 1 : -1;
        }
        
        int count = 0;
        for (int ele : nums) if (ele == candidate) count++;

        return (count >= n / 2) ? candidate : -1;

        // TC: O(N)
        // SC: O(1)
    }

    // same but chatGPT
    public static int chatGPT(int[] nums){
        int votes = 0, candidate = -1;
        for (int ele: nums) {
            if(votes == 0) candidate = ele;
            votes += (ele == candidate) ? 1 : -1;
        }
        return candidate;

        // TC: O(N)
        // SC: O(1)
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{3, 2, 3};
//        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
//        int[] nums = new int[]{1, 1, 1, 1, 2, 3, 4};
        int[] nums = new int[]{9, 9, 9, 5, 6, 9, 7, 9, 8};

        System.out.println(optimal(nums));
        System.out.println(chatGPT(nums));
    }
}
