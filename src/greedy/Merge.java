package greedy;

import java.util.Arrays;
import java.util.LinkedList;

public class Merge {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, ((o1, o2) -> {
            if (o1[0] != o2[0]) return Integer.compare(o1[0], o2[0]);
            return Integer.compare(o1[1], o2[1]);
        }));

        LinkedList<int[]> list = new LinkedList<>();
        int[] t = intervals[0];
        for (int i = 0; i < intervals.length; i++) {
            if (t[1] < intervals[i][0]) {//前一个合并结束
                list.add(new int[]{t[0], t[1]});
                t = intervals[i];
            } else {
                t[1] = Math.max(t[1], intervals[i][1]);
            }

            if (i == intervals.length - 1) {
                list.add(new int[]{t[0], t[1]});
            }
        }
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

}
