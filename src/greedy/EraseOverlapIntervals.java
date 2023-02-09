package greedy;

import org.junit.Test;

import java.util.Arrays;

public class EraseOverlapIntervals {
    // 贪心 有交集的区域删除范围大的区间 保证前面的是无交叉的
    public int eraseOverlapIntervals(int[][] intervals) {
        int ans = 0;
        // 按照起点排序， 范围大的排在前
        Arrays.sort(intervals, ((o1, o2) -> {
            if (o1[0] != o2[0]) return Integer.compare(o1[0], o2[0]);
            return Integer.compare(o2[1], o1[1]);
        }));

        //
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (end > intervals[i][0]) {
                //需要删除
                ans++;
                //选择范围大的删除
                end = Math.min(end, intervals[i][1]);
            } else {
                // 无需删除
                end = intervals[i][1];
            }
        }
        return ans;
    }
}
