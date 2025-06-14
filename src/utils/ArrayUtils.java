package utils;

/**
 * Utility class for printing integer arrays in styled formats.
 */
public final class ArrayUtils {

    private ArrayUtils() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Prints the full array in [1, 2, 3] format.
     */
    public static void print(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /**
     * Prints the first n elements of the array in [1, 2, 3] format.
     */
    public static void print(int[] arr, int n) {
        System.out.print("[");
        for (int i = 0; i < n && i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != n - 1 && i != arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /**
     * Prints the array in green text in [1, 2, 3] format (ANSI-colored).
     */
    public static void printWithColor(int[] arr) {
        final String RESET = "\u001B[0m";
        final String GREEN = "\u001B[32m";

        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(GREEN + arr[i] + RESET);
            if (i != arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
