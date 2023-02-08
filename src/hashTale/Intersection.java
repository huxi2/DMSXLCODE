package hashTale;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums1) {
            if (count.getOrDefault(num, 0) == 0)
                count.put(num, 1);
        }
        for (int num : nums2) {
            if (count.getOrDefault(num, 0) > 0) {
                list.add(num);
                count.put(num, count.get(num) - 1);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
