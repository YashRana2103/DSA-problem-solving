//https://takeuforward.org/arrays/find-the-missing-number-in-an-array/

package TUF.Easy;

public class Easy_9_find_missing_element {
    public static int myApproach(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return -1;
    }

    public static int optimal1(int[] nums) {
        int n = nums.length;
        int N = n + 1;
        int sum = (N * (N + 1)) / 2;
        int actualSum = 0;
        for (int i = 0; i < n; i++) actualSum += nums[i];
        return sum - actualSum;
    }

    public static int optimal2(int[] nums) {
        int n = nums.length;
        int N = n + 1;
        int xor1 = 0;
        int xor2 = 0;
        for (int i = 0; i < N - 1; i++) {xor2 = xor2 ^ nums[i];
        xor1 = xor1 ^ (i + 1);}
        xor1 = xor1 ^ N;

        return (xor1 ^ xor2);
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 3, 4, 6, 7};
        int[] nums = new int[]{1, 3};

        System.out.println(myApproach(nums));
        System.out.println(optimal1(nums));
        System.out.println(optimal2(nums));
    }
}
