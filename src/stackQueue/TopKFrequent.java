package stackQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    //优先队列
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        // 小的在前面
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int[] item = {entry.getKey(), entry.getValue()};
            pq.add(item);
            if (pq.size() > k) pq.poll(); // 小的出队
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll()[0];
        }

        return ans;
    }
}
