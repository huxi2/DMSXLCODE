package greedy;


public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int temp = 0, ans = Integer.MIN_VALUE;
        for (int num : nums) {
            temp += num;
            if (temp > ans) ans = temp;
            if (temp < 0) temp = 0;
        }
        return ans;
    }
}
