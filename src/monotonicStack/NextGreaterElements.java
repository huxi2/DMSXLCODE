package monotonicStack;


import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElements {

    // 循环数组搜索,等于搜索两遍
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(ans, -1);
        for (int i = 0; i < nums.length * 2; i++) {
            int j = i % nums.length;
            while (!stack.isEmpty() && nums[j] > nums[stack.peek()]) {
                int temp = stack.pop();
                if (ans[temp] == -1)
                    ans[temp] = nums[j];
            }
            stack.push(j);
        }

        return ans;
    }
}
