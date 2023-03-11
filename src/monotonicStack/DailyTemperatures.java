package monotonicStack;


import java.util.Stack;

public class DailyTemperatures {

    // 单调栈栈顶到栈底从小到达
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                ans[stack.peek()] = i-stack.pop();
            }
            stack.push(i);
        }

        return ans;
    }
}
