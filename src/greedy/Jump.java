package greedy;

import org.junit.Test;

public class Jump {
    // 和跳跃次数  每次改变的最大步数  从中挑选最远的哪个  选择挑选的次数
    public int jump(int[] nums) {
        int ans = 0;
        int curMax = 0;//当前能达到的最远距离
        int maxStep = 0;//在i 到 i+nums[i]中所能达到的最远距离；
        for (int i = 0; i < nums.length - 1 && i <= curMax; i++) {
            if (i + nums[i] > maxStep) maxStep = (i + nums[i]);
            if (i == curMax) {  //从 i~i+nums[i] 为起点中选择跳的最远的
                curMax = maxStep;
                ans++;
            }
        }
        return ans;
    }
}
