package mypackage;

public class PrintArr {
    // Prints the entire array in [1, 2, 3] format
    public static void printArr(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Prints first n elements in [1, 2, 3] format
    public static void printArr(int[] arr, int n) {
        System.out.print("[");
        for (int i = 0; i < n && i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != n - 1 && i != arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
