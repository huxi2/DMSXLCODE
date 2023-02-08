package greedy;


public class CanJump {
    public boolean canJump(int[] nums) {
        int maxStep = nums[0];
        for (int i = 0; i < nums.length && i <= maxStep; i++) {
            //能到达i 并且从i走最远，更新最远距离
            if (i + nums[i] > maxStep) maxStep = (i + nums[i]);
            if (maxStep >= nums.length) return true;
        }

        return false;
    }
}
