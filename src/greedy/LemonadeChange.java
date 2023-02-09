package greedy;


public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int[] count = new int[2];
        for (int bill : bills) {
            if (bill == 5) {
                count[0]++;
            } else if (bill == 10) {
                if (count[0] == 0) return false;
                count[0]--;
                count[1]++;
            } else {//两种情况  有10 无10
                if (count[1] > 0 && count[0] > 0) {
                    count[0]--;
                    count[1]--;
                } else if (count[1] == 0 && count[0] >= 3) {
                    count[0] -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
