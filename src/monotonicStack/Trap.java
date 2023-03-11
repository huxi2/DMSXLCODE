package monotonicStack;


import org.junit.Test;

import java.util.Stack;

public class Trap {

    // 单调栈解决接雨水
    // 每次接水平一层雨水
    // 栈顶到栈底存放由小到大的元素   表示第i个柱子的高度，
    // left 存储左侧比当前柱子高的第一个元素   right存右侧
    public int trap(int[] height) {
        int ans = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        // 开始计算蓄水量
        for (int i = 1; i < height.length; i++) {
            if (height[i] == height[stack.peek()]) {
                stack.pop();
            } else if (height[i] > height[stack.peek()]) {//形成沟壑
                int left, mid;
                while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                    mid = stack.pop();
                    if (stack.isEmpty()) break;
                    left = stack.peek();
                    ans += (i - left - 1) * (Math.min(height[left], height[i]) - height[mid]);
                }
            }
            stack.push(i);
        }

        return ans;
    }

    @Test
    public void test() {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int ans = trap(height);
    }

}
