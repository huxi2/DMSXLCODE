package greedy;


import java.util.Arrays;

public class FindContentChildren {
    // g人  s饼干
    public int findContentChildren(int[] g, int[] s) {
        boolean[] flag = new boolean[s.length];
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0;
        // 小饼干给胃口小的人
        for (int k : g) {
            for (int j = 0; j < s.length; j++) {
                if (!flag[j] && s[j] > k) {
                    flag[j] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
}
