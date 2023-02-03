package greedy;


import java.util.Arrays;

public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0, costSum = 0;
        int[] rest = new int[gas.length];

        //从消费和花销 剩余油量最高的点出发。
        for (int i = 0; i < gas.length; i++) {
            rest[i] = gas[i] - cost[i];
            gasSum += gas[i];
            costSum += cost[i];
        }
        if (costSum > gasSum) return -1;
        // 剩余油量检测，若到达某点油量为负数， 那么0-i 都不能作为起点
        int ans = 0, sum = -1;
        for (int i = 0; i < rest.length; i++) {
            if (sum < 0) {
                ans = i;
                sum = 0;
            }
            sum += rest[i];
        }
        return ans;
    }
}
