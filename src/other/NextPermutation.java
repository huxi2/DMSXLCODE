package other;

import org.junit.Test;

import java.util.Arrays;

public class NextPermutation {

    // 从后往前找，找到第一个nums[i] < nums[j]的数字 j > i
    // 将i与j位置交换，然后对[i+1,len]进行排序
    public void nextPermutation(int[] nums) {
        //找到要交换的的i
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    Arrays.sort(nums, i + 1, nums.length);
                    //quickSort(nums,i+1,nums.length-1);

                    return;
                }
            }
        }
        // 排序
        Arrays.sort(nums);
//        quickSort(nums,0,nums.length-1);
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int partition = getPartition(nums, start, end);
        quickSort(nums, start, partition - 1);
        quickSort(nums, partition + 1, end);
    }

    public int getPartition(int[] nums, int l, int r) {
        int hold = nums[l];
        while (l < r) {
            while (l < r && nums[r] > hold) r--;
            nums[l] = nums[r];
            while (l < r && nums[l] <= hold) l++;
            nums[r] = nums[l];
        }
        nums[l] = hold;
        return l;
    }
}
