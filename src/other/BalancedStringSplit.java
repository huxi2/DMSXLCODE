package other;

public class BalancedStringSplit {
    public int balancedStringSplit(String s) {
        int ans = 0;
        int L = 0, R = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                L++;
            } else if (s.charAt(i) == 'R') {
                R++;
            }
            if (L == R && L != 0) {
                ans++;
                L = 0;
                R = 0;
            }
        }
        return ans;
    }
}
