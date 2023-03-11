package other;

import org.junit.Test;

public class ValidMountainArray {

    public boolean validMountainArray(int[] arr) {
        if (arr.length <= 2) return false;

        int maxNum = 0;//峰值
        //只允许出现1个峰值，不允许出现极小值 或两个相等的点
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) maxNum += 1;
            if (arr[i - 1] > arr[i] && arr[i] < arr[i + 1]) return false;
            if (arr[i - 1] == arr[i] || arr[i] == arr[i + 1]) return false;
            if (maxNum > 1) return false;
        }
        return maxNum == 1;
    }
}
