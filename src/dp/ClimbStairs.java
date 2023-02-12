package dp;


public class ClimbStairs {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int n1 = 1, n2 = 2, i = 3, ans = 0;
        while (i <= n) {
            ans = n1 + n2;
            n1 = n2;
            n2 = ans;
            i++;
        }
        return ans;
    }
}
