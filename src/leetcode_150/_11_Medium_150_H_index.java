//https://leetcode.com/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150
//https://www.youtube.com/watch?v=mgG5KFTvfPw

package leetcode_150;

public class _11_Medium_150_H_index {
    public static int better(int[] citations) {
        int n = citations.length;
        int[] paperCount = new int[n + 1];

        for (int citation : citations)
            paperCount[Math.min(citation, n)]++;

        int papers = 0;
        for (int i = n; i > 0; i--) {
            papers += paperCount[i];
            if (papers >= i) return i;
        }
        return 0;


        // TC: O(n) // We traverse the citation array once to fill the paperCount array, and then we traverse the paperCount array once to find the H-index.
        // SC: O(n) // The space complexity is O(n) because we use an additional array of size n+1 to store the count of papers with citations.
    }

    public static void main(String[] args) {
        int[] citations1 = {3, 0, 6, 1, 5}; // Output: 3
        int[] citations2 = {1, 3, 1}; // Output: 1
        int[] citations3 = {0, 0, 0, 0, 0}; // Output: 0
        int[] citations4 = {1, 2, 3, 4, 5}; // Output: 3
        int[] citations5 = {5, 5, 5, 5, 5}; // Output: 5
        int[] citations6 = {0, 1, 2, 3, 4, 5}; // Output: 3
        int[] citations7 = {10, 8, 5, 4, 3}; // Output: 4
        int[] citations8 = {6, 5, 3, 1, 0}; // Output: 3
        int[] citations9 = {1, 2, 3, 4, 5, 6}; // Output: 3
        int[] citations10 = {0, 1, 2, 3, 4, 5, 6}; // Output: 4

        System.out.println(better(citations1));
        System.out.println(better(citations2));
        System.out.println(better(citations3));
        System.out.println(better(citations4));
        System.out.println(better(citations5));
        System.out.println(better(citations6));
        System.out.println(better(citations7));
        System.out.println(better(citations8));
        System.out.println(better(citations9));
        System.out.println(better(citations10));

    }
}
