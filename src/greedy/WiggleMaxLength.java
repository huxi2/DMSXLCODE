package greedy;


public class WiggleMaxLength {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int ans = 1, preDiff = 0, curDiff = 0;
        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i - 1];
            if ((preDiff <= 0 && curDiff > 0) || (preDiff >= 0 && curDiff < 0)){
                ans++;
                preDiff = curDiff; // 仅当组成摆动序列时才更新preDiff
            }
        }
        return ans;
    }

}
