package other;

import org.junit.Test;

public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] nums) {
        int[] ans = new int[nums.length];
        int odd = 1, even = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                ans[even] = nums[i];
                even += 2;
            } else {
                ans[odd] = nums[i];
                odd += 2;
            }
        }
        return ans;
    }
}
