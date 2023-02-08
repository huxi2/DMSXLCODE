package greedy;

import java.util.Arrays;

public class FindMinArrowShots {

    public int findMinArrowShots(int[][] points) {
        if (points.length <= 1) return points.length;
        Arrays.sort(points, (o1, o2) -> {
            if (o1[0] != o2[0]) return Integer.compare(o1[0], o2[0]);
            return Integer.compare(o1[1], o2[1]);
        });

        int ans = 1, start = points[0][0], end = points[0][1];
        //贪心
        for (int i = 1; i < points.length; i++) {
            //当前这支箭无法射中 i
            if (points[i][0] > end) {
                ans++;
                start = points[i][0];
                end = points[i][1];
            } else {//可以射中i
                if (start < points[i][0]) start = points[i][0];
                if (end > points[i][1]) end = points[i][1];
            }
        }
        return ans;
    }
}
