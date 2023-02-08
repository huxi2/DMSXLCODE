package stackQueue;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {

    //单调队：使用队列入队保存滑动窗口内的最大值，  队首为大 队尾为小
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            //移动窗口
            //入队前，保证单调 除队首元素入队元素前无比该大的数
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.pollLast();
            }
            //窗口移动后判断最大值是否移除窗口
            if (queue.size() == k || queue.isEmpty() && i >= k && nums[i - k] == queue.peekFirst()) queue.pollFirst();

            //窗口移动结束
            queue.offerLast(nums[i]);
            if (i >= k - 1) ans[i - k + 1] = queue.peekFirst();
        }
        return ans;
    }
}
