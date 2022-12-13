package codeArrays;

public class MinSubArrayLen {

    // 滑动窗口
    public int minSubArrayLen(int target, int[] nums) {
        int left = -1, right = 0, sum = 0, ans = nums.length + 1;
        while (right < nums.length) {
            sum += nums[right];
            //连续子数组符合条件
            while (sum >= target) {
                if (right - left < ans) ans = right - left;
                //缩小窗口
                left++;
                sum -= nums[left];
            }
            //增大窗口
            right++;
        }
        // ans > nums.len 表示全部和都小于target
        return ans > nums.length ? 0 : ans;
    }

}
