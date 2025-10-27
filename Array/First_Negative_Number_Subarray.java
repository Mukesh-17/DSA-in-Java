
import java.util.*;

public class First_Negative_Number_Subarray {

    public static List<Integer> firstNegativeInWindow(int arr[], int k) {

        List<Integer> result = new ArrayList<>();
        Queue<Integer> negatives = new LinkedList<>();

        int start = 0;

        for (int end = 0; end < arr.length; end++) {

            //1. Add the current element if it is negative
            if (arr[end] < 0) {
                negatives.add(arr[end]);
            }

            //2. Check if we have reached the window size
            if (end - start + 1 == k) {

                //3. Record the first negative number for the current window
                if (!negatives.isEmpty()) {
                    result.add(negatives.peek());
                } else {
                    result.add(0);
                }

                // 4. Slide the window
                if (arr[start] < 0) {
                    negatives.poll();
                }
                start++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {-1, -1, -1, -1};
        int k = 3;
        List<Integer> firstNegatives = firstNegativeInWindow(arr, k);
        System.out.println(firstNegatives);  // Output: [-1, -1,-7, -15, -15, 0]       
    }
}
