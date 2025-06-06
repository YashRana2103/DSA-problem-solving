package utils;

/**
 * Utility class for swapping elements in arrays.
 */
public final class Swap {

    private Swap() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Swaps two elements in an int array.
     */
    public static void swap(int[] arr, int index1, int index2) {
        validateIndices(arr, index1, index2);
        if (index1 == index2) return;

        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    /**
     * Swaps two elements in an Object array (e.g., String[], Integer[]).
     */
    public static <T> void swap(T[] arr, int index1, int index2) {
        validateIndices(arr, index1, index2);
        if (index1 == index2) return;

        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    // Shared validation method for DRY code
    private static void validateIndices(Object arr, int index1, int index2) {
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null.");
        }
        int length = java.lang.reflect.Array.getLength(arr);
        if (index1 < 0 || index1 >= length || index2 < 0 || index2 >= length) {
            throw new IndexOutOfBoundsException(
                    "Invalid indices: index1=" + index1 + ", index2=" + index2 +
                            ". Array length is " + length + "."
            );
        }
    }
}
