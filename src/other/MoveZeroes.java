package other;

import org.junit.Test;

public class MoveZeroes {
    //双指针移动数组
    public void moveZeroes(int[] nums) {
        int i=0,j=0;
        while(j<nums.length){
            if(nums[j]!=0)nums[i++]=nums[j];
            j++;
        }
        while(i< nums.length)nums[i++]=0;
    }
}
