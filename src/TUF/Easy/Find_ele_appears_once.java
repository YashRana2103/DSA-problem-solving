//https://takeuforward.org/arrays/find-the-number-that-appears-once-and-the-other-numbers-twice/
//https://leetcode.com/problems/single-number/description/

package TUF.Easy;

import java.util.HashMap;
import java.util.Map;

public class Find_ele_appears_once {
    public static int better2(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int ele : nums)
            hashMap.put(ele, hashMap.getOrDefault(ele, 0) + 1);

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet())
            if (entry.getValue() == 1) return entry.getKey();

        return -1;

        // TC: O(n)
        // SC: O(n)
    }

    public static int optimal(int[] nums){
        int xor = 0;
        for (int ele: nums) xor = xor ^ ele;
        System.gc();
        return xor;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{2, 2, 1};
        int[] nums = new int[]{3, 1, 3, 2, 2, 1, 4};

        System.out.println(better2(nums));
        System.out.println(optimal(nums));
    }
}
