package codeArrays;

public class GenerateMatrix {

    public int[][] generateMatrix(int n) {
        //经过分析 不考虑方向，每个方向上走的步长为 n n-1 n-1 n-2 n-2 ....  2 2 1 1
        // i,j  direct 表示方向 0右j++ 1下i++ 2左j-- 3上i--
        // step表示每个方向走多长， 除开始沿着direct 走n  接下来走两个 n-1   走几个用times记录
        int i = 0, j = 0, direct = 0, step = n, num = 1, times = 1;
        int[][] ans = new int[n][n];
        while (step >= 1) {
            //沿着某个方向上走step
            while (times > 0) {
                for (int k = 0; k < step; k++) {
                    ans[i][j] = num;
                    int flag = k == step - 1 ? 1 : 0;//判断转向需求  最后一步走完需要转向，不是沿着当前方向进行
                    switch((direct+flag)%4){
                        case 0: j++;break;
                        case 1: i++;break;
                        case 2: j--;break;
                        case 3: i--;break;
                    }
                    num++;
                }
                //更新方向
                times--;
                direct = (direct + 1) % 4;
            }
            //更新步数和次数
            times = 2;
            step--;
        }
        return ans;
    }
}
