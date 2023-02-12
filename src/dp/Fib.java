package dp;


public class Fib {
    public int fib(int n) {
        if (n <= 1) return n;
        int i = 2, n0 = 0, n1 = 1, ans = 0;
        while (i <= n) {
            ans = n0 + n1;
            n0 = n1;
            n1 = ans;
            i++;
        }
        return ans;
    }
}
