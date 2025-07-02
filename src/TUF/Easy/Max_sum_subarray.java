package TUF.Easy;

public class Max_sum_subarray {
    private static int maxSumSubarray(int[] nums){
        int maxEnding = 0;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            maxEnding = Math.max(maxEnding + nums[i], nums[i]);
            result = Math.max(maxEnding, result);
        }

        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4}; // 6
//        int[] nums = {4, -1, 2, 1}; // 6
        int[] nums = {1}; // 1

        System.out.println(maxSumSubarray(nums));
    }
}
