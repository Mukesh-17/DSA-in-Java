
import java.util.*;

public class Subarray_sum_zero {

    public static void main(String[] args) {
        int arr[] = {0, -2, 2, -8, 1, 7, -15, 23};
        subarraySumZero(arr);
    }

    public static void subarraySumZero(int arr[]) {

        HashMap<Integer, Integer> hm = new HashMap<>();

        int sum = 0;
        int len = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                len = i + 1;
            }
            if (hm.containsKey(sum)) {
                len = Math.max(len, i - hm.get(sum));
            } else {
                hm.put(sum, i);
            }
        }
        System.out.println("Largest subaaray length with sum equal to zero: " + len);
    }
}
