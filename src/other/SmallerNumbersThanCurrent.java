package other;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SmallerNumbersThanCurrent {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        //保存第一次排序好后的出现位置 即答案
        Map<Integer, Integer> map = new HashMap<>();
        int[] temp = new int[nums.length];
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
            if (!map.containsKey(nums[i])) map.put(nums[i], -1);
        }
        Arrays.sort(temp);
        for (int i = 0; i < temp.length; i++) {
            if (map.get(temp[i]) != -1) map.put(temp[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            ans[i] = map.get(nums[i]);
        }
        return ans;
    }
}
