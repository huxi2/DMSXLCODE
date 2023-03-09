package monotonicStack;

import org.junit.Test;

import java.util.Stack;

public class LargestRectangleArea {

    //最大矩形  栈底到栈顶存储的是从小到大的  记录左侧最小的
    public int largestRectangleArea(int[] heights) {
        // 数组扩容，在头和尾各加入一个元素
        int [] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        System.arraycopy(heights, 0, newHeights, 1, heights.length);

        heights = newHeights;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            // 这里的逻辑其实是 计算  (mid ~ i-1)组成的上升区间的内存
            if (heights[i] < heights[stack.peek()]) {
                int left, mid;
                while (heights[i] < heights[stack.peek()]) {
                    mid = stack.pop();
                    if (stack.isEmpty()) break;
                    left = stack.peek();
                    int w = (i - left - 1);
                    ans = Math.max(ans, heights[mid] * w);
                }
            }

            stack.push(i);
        }
        return ans;
    }
}
