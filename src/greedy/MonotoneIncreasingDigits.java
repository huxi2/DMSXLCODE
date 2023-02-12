package greedy;

import org.junit.Test;

public class MonotoneIncreasingDigits {
    long ans;
    /*     回溯 从小到大
    public int monotoneIncreasingDigits(int n) {
        if (n <= 9) return n;
        backtrack(n, 0, 1);
        return (int)ans;
    }

    //
    public void backtrack(int n, long current, int start) {
        if (current > ans) ans = current;
        for (int i = start; i < 10 && current * 10 + i <= n; i++) {
            System.out.println(current);
            backtrack(n, current * 10 + i, i);
        }
    }
     */

    /*  回溯 从大到小
    public int monotoneIncreasingDigits(int n) {
        if (n <= 9) return n;
        backtrack(n, 0, 1);
        return (int)ans;
    }

    //
    public void backtrack(int n, long current, int start) {
        System.out.println(current);
        if(current == 123)
            System.out.println(1);
        if (current > ans) ans = current;
        for (int i = 9; i >= start; i--) {
            if(current * 10 + i <= n)
                backtrack(n, current * 10 + i, i);
        }
    }
    */


    public int monotoneIncreasingDigits(int n) {
        String strNum = String.valueOf(n);
        int[] temp = new int[strNum.length()];
        int change = strNum.length();//
        for (int i = strNum.length() - 1; i >= 0; i--) {
            temp[i] = strNum.charAt(i) - '0';
            if (i == strNum.length() - 1) continue;
            if (temp[i] > temp[i + 1]) {// 这种 98 -> 88   8后面的所有值都变成9 ->89
                temp[i]--;
                change = i + 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < temp.length; i++) {
            ans *= 10;
            ans += i < change ? temp[i] : 9;
        }
        return ans;
    }
}
