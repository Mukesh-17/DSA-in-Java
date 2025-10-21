
import java.util.*;

public class HashMap_Practice {

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        //Insert
        hm.put("India", 150);
        hm.put("Pakistan", 25);
        hm.put("China", 140);
        hm.put("US", 40);

        System.out.println(hm);

        //Get
        System.out.println(hm.get("India"));

        //Remove
        hm.remove("Pakistan");
        System.out.println(hm);

        //Contains key
        System.out.println(hm.containsKey("US"));
        System.out.println(hm.containsKey("Iran"));

        //Size
        System.out.println(hm.size());

        Set<String> keys = hm.keySet();
        System.out.println(keys);
        for (String k : keys) {
            System.out.println("Key is: " + k + " and value is: " + hm.get(k));
        }

        //isEmpty
        System.out.println(hm.isEmpty());
        hm.clear();
        System.out.println(hm.isEmpty());
        HashMap_Practice obj = new HashMap_Practice();
        //obj.majorityElementsThree(new int[]{1, 3, 2, 5, 1, 3, 1, 5, 1});
        obj.majorityElementsThree(new int[]{1, 2});
    }

    public void majorityElementsThree(int nums[]) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (Integer i : nums) {
            if (!hm.containsKey(i)) {
                hm.put(i, 1);
            } else {
                int val = hm.get(i);
                val += 1;
                hm.put(i, val);
            }
        }
        Set<Integer> keys = hm.keySet();
        ArrayList<Integer> res = new ArrayList<>();
        for (Integer k : keys) {
            if (hm.get(k) > (n / 3)) {
                res.add(k);
            }
        }
        System.out.println(res);
    }

}
