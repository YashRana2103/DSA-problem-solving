//https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150

package leetcode_150;

public class _9_Medium_150_jump_game_I {
    // Just ignore it
//    public static boolean myApproach(int[] nums) {
//        int i = 0;
//        int n = nums.length;
//        while (i < n) {
//            if (i == n - 1 || nums[i] >= n - 1 - i) return true;
//
//            if (nums[i] == 0) return false;
//
//            if (nums[i] == 1) {
//                i++;
//            } else {
//                int j = 1;
//                while (j < nums[i] && i + j < n && nums[i + j] < nums[i]) j++;
//
//                if (j < nums[i] && i + j < n && nums[i + j] >= nums[i]) {
//                    i += j;
//                } else {
//                    while (j > 0 && i + j < n && nums[i + j] == 0) j--;
//
//                    if (j == 0) return false;
//                    i += j;
//                }
//            }
//        }
//        return false;
//    }

    public static boolean chatGPT(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false; // Can't even reach this index
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        // Format: input array -> expected output
        int[] nums = {3, 2, 1, 0, 4, 0, 0};

        System.out.println(chatGPT(nums));

        System.out.println(chatGPT(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}));
    }
}
