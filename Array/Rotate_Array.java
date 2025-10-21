
import java.util.*;

public class Rotate_Array {

    // Rotate the array to the left by k steps
    public static void rotateArrayLeft(int arr[], int k) {

        if (arr.length == 0) {
            System.out.println("Array is empty");
            return;
        }
        if (k < 0 || k >= arr.length) {
            System.out.println("Invalid rotation count");
            return;
        }
        int n = arr.length;

        // Reverse the first k elements
        reverseArray(arr, 0, k - 1);
        // Reverse the rest of the elements
        reverseArray(arr, k, n - 1);
        // Reverse all the elements
        reverseArray(arr, 0, n - 1);

        System.out.println(Arrays.toString(arr));  // print array correctly

    }

    // Rotate the array to the right by k steps
    public static void rotateArrayRight(int arr[], int k) {

        if (arr.length == 0) {
            System.out.println("Array is empty");
            return;
        }
        if (k < 0 || k >= arr.length) {
            System.out.println("Invalid rotation count");
            return;
        }
        int n = arr.length;
        // Reverse the last k elements
        reverseArray(arr, n - k, n - 1);
        // Reverse the rest of the elements
        reverseArray(arr, 0, n - k - 1);
        // Reverse all the elements
        reverseArray(arr, 0, n - 1);

        System.out.println(Arrays.toString(arr));  // print array correctly

    }

    public static void reverseArray(int arr[], int start, int end) {

        if (arr.length == 0) {
            System.out.println("Array is empty");
            return;
        }
        if (start < 0 || end >= arr.length || start >= end) {
            System.out.println("Invalid indices");
            return;
        }

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        //System.out.println(Arrays.toString(arr));  // print array correctly
    }

    public static void main(String[] args) {
        int arr[] = {9, 7, 5, 4, 3, 1, 6, 2, 8};
        //reverseArray(arr, 0, arr.length - 1);
        rotateArrayLeft(arr, 2);
        rotateArrayRight(arr, 3);
    }
}
