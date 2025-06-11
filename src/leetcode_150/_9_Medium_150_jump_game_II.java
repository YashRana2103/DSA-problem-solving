//https://leetcode.com/problems/jump-game-ii/description/?envType=study-plan-v2&envId=top-interview-150

package leetcode_150;

import java.util.Random;
import static utils.ArrayUtils.printWithColor;

public class _9_Medium_150_jump_game_II {
    // will not work, and is not logically correct
    // Exception case: 7,0,9,6,9,6,1,7,9,0,1,2,9,0,3
    public static int myApproach(int[] nums) {
        int maxReach = 0;
        int jumpCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) return jumpCount;
            if (maxReach < i + nums[i]) {
                maxReach = i + nums[i];
                jumpCount++;
            }
        }
        return -1;
    }

    public static int chatGPT(int[] nums) {
        int jumps = 0, currentEnd = 0, maxReach = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);

            if (i == currentEnd) {
                jumps++;
                currentEnd = maxReach;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[][] testCases = {
                {7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3}, // Expected: 2
                {2, 3, 1, 1, 4},             // Expected: 2
                {1, 1, 1, 1},                // Expected: 3
                {4, 1, 1, 1, 1},             // Expected: 1
                {1, 2, 3, 4, 5},             // Expected: 3
                {1, 1, 1, 1, 1, 1},          // Expected: 5
                {1, 1, 1, 10, 1, 1},         // Expected: 4
                {6, 2, 4, 0, 5, 1, 1, 4, 2, 9}, // Expected: 2
                {1},                         // Expected: 0
                {2, 1},                      // Expected: 1
                {3, 2, 1, 0, 4}              // Invalid for Jump II, don't include if constraints are strict
        };

        Random random = new Random();
        int index = random.nextInt(testCases.length);
        int[] selected = testCases[index];

        System.out.print("Selected test case: ");
        printWithColor(selected);

        System.out.println("myApproach = " + myApproach(selected));
        System.out.println("chatGPT = " + chatGPT(selected));
    }
}
