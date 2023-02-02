package greedy;


import java.util.Arrays;

public class LargestSumAfterKNegations {

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        //尽可能将所有负数变正  然后剩下的全部
        int i = 0, ans = 0;
        for (; i < nums.length && k > 0; i++) {
            if (nums[i] >= 0) break;
            nums[i] = -nums[i];
            k--;
        }
        if (i == nums.length || i > 0 && nums[i] > nums[i - 1]) i--;
        // 处理剩余k
        if (k % 2 == 1) nums[i] = -nums[i];

        for (int num : nums) ans += num;
        return ans;
    }
}
