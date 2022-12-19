package hashTale;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] > target && nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (nums[i] + nums[j] > target && nums[i] + nums[j] > 0) break;
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int mid = j + 1;
                int right = nums.length - 1;

                while (mid < right) {
                    //解决溢出问题（long）
                    long sum = (long)nums[i] + nums[j] + nums[mid]; //解决溢出
                    if (sum > target && sum > 0) break;
                    sum += nums[right];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[mid]);
                        temp.add(nums[right]);
                        ans.add(temp);

                        while (right > mid && nums[right] == nums[right - 1]) right--;
                        while (right > mid && nums[mid] == nums[mid + 1]) mid++;
                        right--;
                        mid++;

                    } else if (sum > target) {
                        right--;
                    } else {
                        mid++;
                    }
                }
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = {1000000000,1000000000,1000000000,1000000000,-1000000000,-1000000000,-1000000000,-1000000000};
        int target = 0;
        fourSum(nums, target);

    }
}
