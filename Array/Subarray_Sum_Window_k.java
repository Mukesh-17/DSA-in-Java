
import java.util.*;

public class Subarray_Sum_Window_k {

    public static List<Integer> SubarraySumInWindowK(int arr[], int k) {

        List<Integer> result = new ArrayList<>();
        int windowSum = 0;
        int start = 0;

        for (int end = 0; end < arr.length; end++) {
            windowSum += arr[end];

            if (end - start + 1 == k) {
                result.add(windowSum);
                windowSum -= arr[start];
                start++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 3;
        List<Integer> subarraySums = SubarraySumInWindowK(arr, k);
        System.out.println(subarraySums);  // Output: [6, 9, 12, 15, 18, 21, 24]
    }
}
