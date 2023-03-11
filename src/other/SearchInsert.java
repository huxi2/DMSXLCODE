package other;

import org.junit.Test;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (left < 0) return 0;
        if (left >= nums.length) return nums.length;

        return nums[left] > target ? left - 1 : left;
    }
}
