package TUF.Easy;

public class Majority_ele_nByTwo {
    private static int majorityEle(int[] nums, int n) {
        int counter = 0;
        int currEle = nums[0];

        for (int i = 0; i < n; i++) {
            if (counter == 0) {
                currEle = nums[i];
                counter++;
            } else if (nums[i] == currEle) {
                counter++;
            } else {
                counter--;
            }
        }

        return currEle;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 2, 1, 1, 1, 2, 2};
//        int[] nums = {3, 2, 3};
//        int[] nums = {4, 4, 2, 4, 3, 4, 4, 3, 2, 4};
        int[] nums = {1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 1, 2, 3};

        System.out.println(majorityEle(nums, nums.length));
    }
}
