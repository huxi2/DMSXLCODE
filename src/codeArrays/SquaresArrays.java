package codeArrays;

public class SquaresArrays {
    //双指针 中心扩散
    // 从第一个非负数开始 找到绝对值小的放到ans的首端
    // 查找 left指向第一个负数，right指向第一个非负数
    public int[] sortedSquares(int[] nums) {
        int left, right = 0;
        if (nums[0] >= 0) {//全是非负数
            left = -1;
        } else {
            while (right < nums.length && nums[right] < 0) right++;
            left = right - 1;
        }

        //开始计算平方数
        int loc = 0;
        int[] ans = new int[nums.length];

        while (loc < nums.length) {
            if (left < 0) {//只存在非负数
                while (right < nums.length) {
                    ans[loc++] = nums[right] * nums[right];
                    right++;
                }
            } else if (right >= nums.length) {//只存在负数
                while (left >= 0) {
                    ans[loc++] = nums[left] * nums[left];
                    left--;
                }
            } else {//负数非负数都存在
                if (-nums[left] < nums[right]) {
                    ans[loc++] = nums[left] * nums[left];
                    left--;
                } else {
                    ans[loc++] = nums[right] * nums[right];
                    right++;
                }
            }
        }
        return ans;
    }

    //双指针  中心汇集
    // 从两端开始 找到绝对值大的放到ans的尾端
    public int[] sortedSquares2(int[] nums) {
        int left = 0, right = nums.length - 1, loc = nums.length - 1;
        int[] ans = new int[nums.length];

        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                ans[loc--] = nums[left] * nums[left];
                left++;
            } else {
                ans[loc--] = nums[right] * nums[right];
                right--;
            }
        }
        return ans;
    }

}
