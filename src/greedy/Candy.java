package greedy;


import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        int[] hold = new int[ratings.length];
        hold[0] = 1;
        //从前往后分配
        for (int i = 1; i < ratings.length; i++) {
            hold[i] = ratings[i] > ratings[i - 1] ? hold[i - 1] + 1 : 1;
        }

        //从后往前分配
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && hold[i] <= hold[i + 1]) {
                hold[i] = hold[i + 1] + 1;
            }
        }
        return Arrays.stream(hold).sum();
    }
}
