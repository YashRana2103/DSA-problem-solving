//https://takeuforward.org/data-structure/longest-subarray-with-given-sum-k/

package TUF.Medium;

import java.util.HashMap;
import java.util.Map;

public class Medium_1_longest_subarr_w_sum_k {
    public static int myApproach(int[] nums, int k) {
        int n = nums.length;
        int lenOfSubArr = 0;
        for (int i = 0; i < n; i++) {
            long prefixSum = 0;
            for (int j = i; j < n; j++) {
                prefixSum += nums[j];
                if (prefixSum == k)
                    lenOfSubArr = Math.max(lenOfSubArr, j - i + 1);
            }
        }
        return lenOfSubArr;
    }

    public static int better(int[] nums, int k){
        int n = nums.length;
        int sum = 0;
        int maxLen = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if(sum == k) maxLen = Math.max(maxLen, i + 1);

            int laterPrefix = sum - k;

            if(map.containsKey(laterPrefix)){
                int len = i - map.get(laterPrefix);
                maxLen = Math.max(maxLen, len);
            }

            if(!map.containsKey(sum)) map.put(sum, i);
        }

        return maxLen;
    }

    public static int optimal(int[] nums, int k){
        int n = nums.length;

        int left = 0, right = 0;
        int sum = nums[0];
        int maxLength = 0;
        while(right < n){
            while(left <= right && sum > k){
                sum -= nums[left];
                left++;
            }

            if(sum == k) maxLength = Math.max(maxLength, right - left + 1);

            right++;
            if(right < n) sum += nums[right];
        }
        return maxLength;

        // TC: O(N) or O(2N)
        // SC: O(1)
    }
    public static void main(String[] args) {
//        int[] nums = new int[]{2, 3, 5};
//        int[] nums = new int[] {2, 3, 5, 1, 9};
//        int[] nums = new int[] {1, 9, 2, 3, 5};
//        int[] nums = new int[] {1, 0, 2, 3, 5, 1, 9};
        int[] nums = new int[]{1, 9, 0, 0, 1, 1, 3, 5, 1, 7, 2};

        System.out.println(myApproach(nums, 10));
        System.out.println(better(nums, 10));
        System.out.println(optimal(nums, 10));
    }
}
