package codeArrays;

/**
 * 704. 二分查找 https://leetcode.cn/problems/binary-search/
 */
public class BinSearch {

    // 将区间定义为 [low,high]  此时while(low<=high) 因为 low == high 是有意义的
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    // 将区间定义为 [low,high)  此时while(low<high) 因为 low == high 是无意义的
    public int search2(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) low = mid + 1;
            else high = mid; // 此时mid一定不等于target
        }
        return -1;
    }
}
