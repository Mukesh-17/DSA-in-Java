
import java.util.*;

public class Union_Intersection {

    public static void main(String[] args) {
        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};
        unionIntersection(arr1, arr2);
    }

    public static void unionIntersection(int arr1[], int arr2[]) {

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> setIntersec = new HashSet<>();
        //Union
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        System.out.println(set);
        set.clear();

        //Intersection
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        for (int i = 0; i < arr1.length; i++) {
            if (set.contains(arr1[i])) {
                setIntersec.add(arr1[i]);
            }
        }
        System.out.println(setIntersec);
    }
}
