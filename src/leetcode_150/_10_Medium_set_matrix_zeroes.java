//https://takeuforward.org/data-structure/set-matrix-zero/

package leetcode_150;

import static utils.ArrayUtils.printMatrix;

public class _10_Medium_set_matrix_zeroes {

    // not work with -ve
    public static void brute_force(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (matrix[i][j] == 0) {

                    for (int k = 0; k < m; k++) {
                        matrix[i][k] = matrix[i][k] != 0 ? -1 : 0;
                    }

                    for (int k = 0; k < n; k++) {
                        matrix[k][j] = matrix[k][j] != 0 ? -1 : 0;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = matrix[i][j] == -1 ? 0 : matrix[i][j];
            }
        }

        // TC: (m * n) * (m + n)
        // SC: O(1)
    }

    public static void better(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] rows = new int[n];
        int[] cols = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = (rows[i] == 1 || cols[j] == 1) ? 0 : matrix[i][j];
            }
        }

        // TC: O( 2(n*m) )
        // SC: O(n) + O(m)
    }

    public static void optimal(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int col0 = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j != 0) matrix[0][j] = 0;
                    else col0 = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] != 0)
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }

        if(matrix[0][0] == 0)
            for (int k = 0; k < m; k++) matrix[0][k] = 0;
        if(col0 == 0)
            for (int k = 0; k < n; k++) matrix[k][0] = 0;

        // TC: O( 2(n*m) )
        // SC: O(1)
    }

    public static void main(String[] args) {
        int[][] myMatrix = {
//                {0, 1, 2, 0},
//                {3, 4, 5, 2},
//                {1, 3, 1, 5}
//                {1, 1, 1},
//                {1, 0, 1},
//                {1, 1, 1}
//                {1, 2, 3, 0},
//                {3, 4, 0, 2},
//                {5, 2, 1, 6}
                {1, 2, 0, 5},
                {3, 1, 6, 8},
                {0, 0, 2, 3}
        };
//        brute_force(myMatrix);
//        better(myMatrix);
        optimal(myMatrix);
        printMatrix(myMatrix);
    }
}
