package greedy;

import java.util.*;

public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int[] positions = new int[26];
        Arrays.fill(positions, -1);
        // 找到最后一个元素的位置
        for (int i = s.length() - 1; i >= 0; i--) {
            int c = s.charAt(i) - 'a';
            if (positions[c] == -1) positions[c] = i;
        }

        //同走的最远步长
        int max = -1, count = 0;
        for (int i = 0; i < s.length(); i++) {
            count++;
            max = Math.max(max,positions[s.charAt(i)-'a']);

            if (max == i) {
                ans.add(count);
                count = 0;
                max = -1;
            }
        }
        return ans;
    }
}
