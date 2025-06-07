package TUF.Easy;

public class Easy_10_count_max_consecutive_ones {
    public static int optimal(int[] nums){
        int n = nums.length;
        int max = 0, cnt = 0;
        for(int ele: nums){
            cnt = (ele == 1) ? cnt + 1 : 0;
            max = Math.max(cnt, max);
        }

        return max;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 1, 0, 1, 1, 1};
        int[] nums = new int[]{1, 0, 1, 1, 0, 1, 1, 1, 0, 1};

        System.out.println(optimal(nums));
    }
}
