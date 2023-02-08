package hashTale;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FourSumCount {

    //前两个、后两个数组求和，然后对求和后的数组再次求和
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> sum1 = new HashMap<>(); // 统计nums1 + nums2出现的次数
        Map<Integer, Integer> sum2 = new HashMap<>(); // 统计nums3 + nums4出现的次数
        for (int num1 : nums1)
            for (int num2 : nums2)
                sum1.put(num1 + num2, sum1.getOrDefault(num1 + num2, 0) + 1);

        for (int num3 : nums3)
            for (int num4 : nums4)
                sum2.put(num3 + num4, sum2.getOrDefault(num3 + num4, 0) + 1);
        Set<Integer> set1 = sum1.keySet();
        Set<Integer> set2 = sum2.keySet();

        int ans = 0;
        for (int num1 : set1) {
            for (int num2 : set2) {
                if (num1 + num2 == 0) {
                    ans += sum1.get(num1) * sum2.get(num2);
                }
            }
        }
        return ans;
    }

}
