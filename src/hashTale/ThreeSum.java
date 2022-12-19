package hashTale;

import java.util.*;

public class ThreeSum {
    //双指针 无去重
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) break;
            int mid = i + 1, right = nums.length - 1;
            while (mid < right) {
                int sum = nums[i] + nums[mid] + nums[right];
                if (sum == 0) {
                    if (set.add("*" + nums[i] + nums[mid] + nums[right])) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[mid]);
                        temp.add(nums[right]);
                        ans.add(temp);
                    }
                    mid++;
                } else if (sum > 0) {
                    right--;
                } else {
                    mid++;
                }
            }
        }
        return ans;
    }

    //双指针 去重
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int mid = i + 1, right = nums.length - 1;
            while (mid < right) {
                int sum = nums[i] + nums[mid] + nums[right];
                if (sum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[mid]);
                    temp.add(nums[right]);
                    ans.add(temp);
                    //去重
                    while (mid < right && nums[mid] == nums[mid + 1]) mid++;
                    while (mid < right && nums[right] == nums[right - 1]) right--;
                    //找到答案同时收缩
                    right--;
                    mid++;
                } else if (sum > 0) {
                    right--;
                } else {
                    mid++;
                }
            }
        }
        return ans;
    }
}
