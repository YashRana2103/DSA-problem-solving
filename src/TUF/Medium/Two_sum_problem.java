package TUF.Medium;

import java.util.HashMap;
import java.util.Map;

import static sorting.Sorting.mergeSort;
import static utils.ArrayUtils.printWithColor;

public class Two_sum_problem {

    private static Boolean v1_brute_force(int[] nums, int target) {

        for (int curr = 0; curr < nums.length; curr++) {
            for (int i = curr + 1; i < nums.length; i++) {
                if (nums[curr] + nums[i] == target) return true;
            }
        }

        return false;
    }

    private static int[] v2_brute_force(int[] nums, int target) {

        for (int curr = 0; curr < nums.length; curr++) {
            for (int i = curr + 1; i < nums.length; i++) {
                if (nums[curr] + nums[i] == target) return new int[]{curr, i};
            }
        }

        return new int[]{-1, -1};
    }

    private static Boolean v1_hashmap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) map.put(i, nums[i]);

        for (int curr = 0; curr < nums.length; curr++) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if ((entry.getValue() == target - nums[curr]) && entry.getKey() != curr)
                    return true;
            }
        }

        return false;
    }

    private static Boolean v1_hashmap_TUF(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int moreNeeded = target - nums[i];
            if(map.containsKey(moreNeeded)) return true;
            map.put(nums[i], i);
        }

        return false;

        // TC: O(N)
        // SC: O(N)
    }

    private static Boolean v1_two_pointer(int[] nums, int target) {
        mergeSort(nums, 0, nums.length - 1);
        int start = 0, end = nums.length - 1;
        while(start < end){
            int sum = nums[start] + nums[end];
            if(sum == target) return true;
            else if (sum > target) end--;
            else if (sum < target) start++;
        }
        return false;

        // TC: O(N log N) for sorting + O(N) for two-pointer traversal = O(N log N)
        // SC: O(1)
    }

    private static int[] v2_hashmap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) map.put(i, nums[i]);

        for (int curr = 0; curr < nums.length; curr++) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if ((entry.getValue() == target - nums[curr]) && entry.getKey() != curr)
                    return new int[]{curr, entry.getKey()};
            }
        }

        return new int[]{-1, -1};
    }

    private static int[] v2_hashmap_TUF(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int moreNeeded = target - nums[i];
            if(map.containsKey(moreNeeded)) return new int[]{map.get(moreNeeded), i};
            map.put(nums[i], i);
        }

        return new int[]{-1, -1};

        // TC: O(N)
        // SC: O(N)
    }

    private static int[] v2_two_pointer(int[] nums, int target) {
        mergeSort(nums, 0, nums.length - 1);
        printWithColor(nums);
        int start = 0, end = nums.length - 1;
        while(start < end){
            int sum = nums[start] + nums[end];
            if(sum == target) return new int[]{start, end};
            else if (sum > target) end--;
            else if (sum < target) start++;
        }
        return new int[]{-1, -1};

        // TC: O(N log N) for sorting + O(N) for two-pointer traversal = O(N log N)
        // SC: O(1)
    }

    public static void main(String[] args) {
//        int[] nums = {3, 8, 2, 7};
        int[] nums = {2, 6, 8, 11, 5, 9, 21};
        int target = 14;
        System.out.println(v1_brute_force(nums, target));
        printWithColor(v2_brute_force(nums, target));

        System.out.println(v1_hashmap(nums, target));
        printWithColor(v2_hashmap(nums, target));

        System.out.println(v1_hashmap_TUF(nums, target));
        printWithColor(v2_hashmap_TUF(nums, target));

        System.out.println(v1_two_pointer(nums, target));
        printWithColor(v2_two_pointer(nums, target));

    }

}
